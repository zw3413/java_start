package webdownloader;

/*import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.framed.FrameReader.Handler;
import okio.BufferedSink;
import okio.Okio;

//
public final class WebsiteDownloader {
    private static final int CONNECT_TIMEOUT_MILLIS = 10000;
    private static final int READ_TIMEOUT_MILLIS = 10000;
    private static final int MAX_THREAD_COUNT = 10;

    private static final String SP_WEBSITE_DOWNLOADER = "sp_website_downloader";
    private static final String SP_WEBSITE_DOWNLOADER_FILE = "sp_website_downloader_img";

    static final Pattern FILE_NAME_REGEX = Pattern.compile("/((?:.(?!/))+$)");
    static final Pattern EXTRACT_REGEX = Pattern.compile("((?:http://|https://|//|/|\\.+/)[^\"|^)]*)\\.(json|js|css|png|gif|html|jpeg|jpg)(.*?)(?:\"|\\))", Pattern.CASE_INSENSITIVE);

    private static ExecutorService downloaderService;

    private static ExecutorService getDownloaderService() {
        if (downloaderService == null) {
            synchronized (WebsiteDownloader.class) {
                if (downloaderService == null)
                    downloaderService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
            }
        }
        return downloaderService;
    }

   // private Context context;
    private String path;
    private String url;
    private String indexName;
    private String domain;
    private String cssPath;
    private String jsPath;
    private Set<String> fileUrlsDiff;
    private Set<String> cache;
    private Map<String, String> requestHeader;
    private Callback callback;
    private boolean separatorSourceFile;
    private boolean absoluteAllPaths;
    private boolean isPack;
    private Handler handler; //lazy init

    private Set<String> fileUrlsCaches = new HashSet<String>();
    private List<TagProperty> tagProperties = new ArrayList<TagProperty>();
    private List<TagProperty> successList = new ArrayList<TagProperty>();
    private List<TagProperty> failList = new ArrayList<TagProperty>();
    private OkHttpClient okHttpClient = new OkHttpClient();

    private volatile int waitToCacheCount;
    
    //构造函数，需要一个安卓全局信息context参数， 用于创建Builder
 /*   public WebsiteDownloader(Context context) {
        this(new Builder(context)
                .absoluteAllPaths(true)
                .cache("js")
                .cache("css"));
    }*/
    //构造函数，需要一个Builder参数
    public WebsiteDownloader(Builder builder) {
        this(builder, null);
    }
    //构造函数，需要一个Builder参数，还需要一个OkHttpClient的实例
    public WebsiteDownloader(Builder builder, OkHttpClient okHttpClient) {
    	//将参数传进来的Builder的属性赋值给本对象
  //      this.context = builder.context; //获取全局环境
        this.path = builder.path; 
        this.indexName = builder.indexName;
        this.separatorSourceFile = builder.separatorSourceFile;
        this.absoluteAllPaths = builder.absoluteAllPaths;
        this.cache = Collections.unmodifiableSet(builder.cache);
        this.requestHeader = Collections.unmodifiableMap(builder.requestHeader);
        
        //获取已经下载的图片的urls，通过全局环境，需要一个参数：SP_WEBSITE_DOWNLOADER,还需要一个参数：Context.MODE_PRIVATE
      //  SharedPreferences sp = context.getSharedPreferences(SP_WEBSITE_DOWNLOADER, Context.MODE_PRIVATE);
        //获取已下载图片Url的 StringSet， 需要一个参数：保存路径，还需要一个参数：保存String的StringSet
     //   fileUrlsDiff = sp.getStringSet(SP_WEBSITE_DOWNLOADER_FILE + getSourceFolderName(), new HashSet<String>());
        if (okHttpClient == null) {//检查传进来了一个有效的OkHttpClient实例
            this.okHttpClient = new OkHttpClient.Builder() //如果传进来的OkHttpClient实例无效，则新建OkHttpClient实例
                    .connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)//设置连接超时时间
                    .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)//设置读取超时时间
                    .addInterceptor(new Interceptor() { //添加拦截器
                        @Override//拦截器中的处理函数
                        public Response intercept(Chain chain) throws IOException { 
                            return addHeaders(chain); //添加拦截器，将本对象中的属性requestHeader中的内容放入request对象中
                        }
                    })
                    .build();//创建新的OkHttpClient
        } else {//如果传进来的OkHttpClient实例有效
            this.okHttpClient = okHttpClient //将传进来的实例赋值给对象本身属性
                    .newBuilder()
                    .addInterceptor(new Interceptor() {//添加拦截器
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            return addHeaders(chain);
                        }
                    }).build();
        }
    }

    private Response addHeaders(Interceptor.Chain chain) throws IOException {
        Request origin = chain.request();//先获取request对象
        Request.Builder requestBuilder = origin.newBuilder();//调用Request的newBuilder方法创建Request.Builder对象
        for (Map.Entry<String, String> entry : requestHeader.entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());//遍历requestHeader中的所有键值对，并将所有的键值对添加进requestBuilder
        }
        return chain.proceed(requestBuilder.build());//交给下一个chain处理，将重进创建的request对象传下去
    }

    /**
     * @param url the url of the website you want to download
     * @return
     */
    public WebsiteDownloader url(String url) { //提供想要下载的网站的url
        this.url = url;//将url赋值给本对象的属性
        isPack = url.contains(".zip");//检测url是否指向一个压缩包
        if (!isPack) {//如果不是压缩包
            HttpUrl httpUrl = HttpUrl.parse(url);//将url解析为一个HttpUrl对象
            domain = httpUrl.scheme() + "://" + httpUrl.host() + ":" + httpUrl.port();//拼接完整请求链接地址
        }
        return this;//返回本WebsiteDownloader对象
    }

    /**
     * @param callback add file download callback
     * @return
     */
    public WebsiteDownloader callback(Callback callback) {
        this.callback = callback;
        if (callback != null && handler == null) {//如果callback不为空，并且 handler为空
        	synchronized (WebsiteDownloader.class) {// 为本对象的类加锁，锁定里面的静态成员
                if (handler == null) {//如果handler为空
                    handler = new Handler(Looper.getMainLooper());//创建新的handler，
                }
            }
        }
        return this;
    }

    public void execute() {
        if (isPack) {
            downloadZip();//如果下载对象是压缩包，则下载压缩包
        } else {
            downloadHtml();//不是压缩包，则下载HTML
        }
    }

    private void downloadZip() {
        getDownloaderService().execute(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                try {
                    String fileName;
                    Matcher matcher = FILE_NAME_REGEX.matcher(url);
                    if (matcher.find()) {
                        fileName = matcher.group(1);
                    } else throw new IOException("url is illegal");

                    Response response = okHttpClient.newCall(request).execute();

                    //create the website folder
                    File folder = new File(path);
                    folder.mkdirs();

                    File downloadedFile = new File(path, fileName);

                    BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
                    sink.writeAll(response.body().source());
                    sink.close();

                    FileUtil.unpackZip(path, fileName);
                    renameIndexIfNecessary();
                    findResourceDirectory();
                    success();
                } catch (IOException e) {
                    e.printStackTrace();
                    failed();
                }
            }
        });
    }

    /**
     * Please ensure that your zip root directory only contains one html file,
     * or something unpredictable may happen
     **/
    private void renameIndexIfNecessary() throws IOException {
        List<File> files = FileUtil.getAllFiles(path);
        for (File file : files) {
            final String name = file.getName();
            if (name.endsWith(".html")) {
                if (!name.substring(0, name.length() - 5).equals(indexName)) {
                    FileUtil.replaceFile(new File(path, indexName + ".html"), new File(path, name));
                }
                return;
            } else if (name.endsWith(".htm")) {
                FileUtil.replaceFile(new File(path, indexName + ".html"), new File(path, name));
                return;
            }
        }

        //no index found throw an exception
        throw new IOException("no index file found");
    }

    /**
     * only work when download a zip file, and you should cache css path and js path
     * on your own
     */
    private void findResourceDirectory() {
        ArrayList<File> files = new ArrayList<File>();
        FileUtil.getAllDirectory(path, files);
        for (File file : files) {
            final String path = file.getPath();
            String lowerPath = path.toLowerCase();
            if (lowerPath.endsWith("css")) {
                cssPath = path + File.separator;
            } else if (lowerPath.endsWith("js")) {
                jsPath = path + File.separator;
            }
        }
    }

    private void downloadHtml() {
        getDownloaderService().execute(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        doCache(response.body().string());
                    } else {
                        failed();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    failed();
                }
            }
        });
    }

   // @SuppressWarnings("ResultOfMethodCallIgnored")
    private void doCache(String data) {
        //创建网站文件夹
        File folder = new File(path);
        folder.mkdirs();
        //创建资源文件夹
        File source = new File(getSourceFolderPath());
        source.mkdirs();
        File file = new File(folder, indexName + "_temp.html");
        Matcher matcher = EXTRACT_REGEX.matcher(data);
        List<TagProperty> waitToDownload = new ArrayList<TagProperty>();
        while (matcher.find()) {
            TagProperty tagProperty = new TagProperty(matcher.group(1), matcher.group(2), matcher.group(3));

            boolean isCacheExt = isCacheExt(tagProperty.ext);

            if (isCacheExt) {
                final String diffName = tagProperty.getUrlWithQueries();

                fileUrlsCaches.add(diffName);
                if (!isUrlExists(diffName)) {
                    waitToDownload.add(tagProperty);
                    waitToCacheCount++;
                }
                tagProperties.add(tagProperty);
            }

            if (absoluteAllPaths) {
                final String group = matcher.group();
                final String replaceString = group.substring(0, group.length() - 1);
                if (isCacheExt) {
                    data = data.replace(replaceString, tagProperty.format());
                } else {
                    data = data.replace(replaceString, tagProperty.getUrlWithQueries());
                }
            }
        }

        for (TagProperty tag : waitToDownload) {
            tag.download();
        }

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
            outWriter.append(data);
            outWriter.close();
            fOut.flush();
            fOut.close();

            //Cache index
            if (waitToCacheCount == 0) {
                validateCaches();
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    private void validateCaches() {
        getDownloaderService().execute(new Runnable() {
            @Override
            public void run() {
                //rename all temp files and delete old files
                FileUtil.replaceFile(new File(path, indexName + ".html"), new File(path, indexName + "_temp.html"));
                for (TagProperty tp : successList) {
                    File old = new File(getSourceFolderPath(), tp.getEntireFileName());
                    File fresh = new File(getSourceFolderPath(), tp.getTempFileName());
                    FileUtil.replaceFile(old, fresh);
                }

                //store current image urls for future diff
          //      SharedPreferences sp = context.getSharedPreferences(SP_WEBSITE_DOWNLOADER, Context.MODE_PRIVATE);
           //     sp.edit().putStringSet(SP_WEBSITE_DOWNLOADER_FILE + getSourceFolderName(), fileUrlsCaches).commit();

                success();
            }
        });
    }

    private void failed() {
        if (callback != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onDownloadFailed();
                }
            });
        }
    }

    private void success() {
        if (callback != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onDownloadFinished();
                }
            });
        }
    }

    private String getSourceFolderName() {
        return separatorSourceFile ? indexName + "_resource" : "resource";
    }

    //使用 path getSourceFolderName() 来拼接资源文件夹路径
    public String getSourceFolderPath() {
        return path + getSourceFolderName() + File.separator;
    }

    public String getIndex() {
        return path + indexName + ".html";
    }

    public String getPath() {
        return path;
    }

    public String getCssPath() {
        return (isPack && !TextUtils.isEmpty(jsPath)) ? cssPath : getSourceFolderPath();
    }

    public String getJsPath() {
        return (isPack && !TextUtils.isEmpty(jsPath)) ? jsPath : getSourceFolderPath();
    }

    public String getIndexUrl() {
        return "file://" + getIndex();
    }

    public boolean isIndexExists() {
        return new File(getIndex()).exists();
    }

    private boolean isCacheExt(String ext) {
        return cache.contains(ext);
    }

    private boolean isUrlExists(String diff) {
        for (TagProperty t : tagProperties) {
            if (t.getUrlWithQueries().equals(diff)) return true;
        }
     //   for (String s : fileUrlsDiff) {
       //     if (s.equals(diff)) return true;
      //  }
        return false;
    }

    private boolean isImage(String ext) {
        return ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg")
                || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("gif");
    }
    //内部类
    private class TagProperty {
        String addr;
        String ext;
        String extra;
        
        TagProperty(String addr, String ext, String extra) {
            this.addr = addr.trim();
            this.ext = ext;
            this.extra = extra.trim();
        }

        @Override
        public String toString() {
            return "{" + "addr" + ":" + addr + ","
                    + "format" + ":" + ext + ","
                    + "extra" + ":" + extra + "}";
        }

        @Override
        public int hashCode() {
            return addr.hashCode()
                    + ext.hashCode()
                    + extra.hashCode();
        }

        String getFileName() {
            Matcher matcher = FILE_NAME_REGEX.matcher(addr);
            if (matcher.find()) {
                return matcher.group(1);
            } else return "";
        }

        String getEntireFileName() {
            return getFileName() + "." + ext;
        }

        String getTempFileName() {
            return getFileName() + "_temp." + ext;
        }

        String format() {
            return getSourceFolderName() + File.separator +
            		getEntireFileName() + (TextUtils.isEmpty(extra) ? "" : extra);
        }

        String getUrl() {
            String tagUrl = addr + "." + ext;
            if (tagUrl.startsWith("//")) return "http:" + tagUrl;
            if (!URLUtil.isValidUrl(tagUrl)) {
                tagUrl = domain + tagUrl;
            }
            return tagUrl;
        }

        String getUrlWithQueries() {
            return getUrl() + (TextUtils.isEmpty(extra) ? "" : extra);
        }

        void download() {
            getDownloaderService().execute(new Runnable() {
                @Override
                public void run() {
                    Request request = new Request.Builder()
                            .url(getUrlWithQueries())
                            .get()
                            .build();
                    try {
                        Response response = okHttpClient.newCall(request).execute();
                        File downloadedFile = new File(getSourceFolderPath(), getTempFileName());
                        BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
                        sink.writeAll(response.body().source());
                        sink.close();

                        synchronized (WebsiteDownloader.this) {
                            successList.add(TagProperty.this);
                            if (successList.size() + failList.size() == waitToCacheCount) {
                                if (failList.size() == 0) validateCaches();
                                else failed();
                            }
                        }

                    } catch (IOException e) {
                        synchronized (WebsiteDownloader.this) {
                            failList.add(TagProperty.this);
                            if (successList.size() + failList.size() == waitToCacheCount)
                                failed();
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static final class Builder {
      //  private Context context;
        private String path;
        private String indexName;
        private boolean separatorSourceFile;
        private boolean absoluteAllPaths;
        private Set<String> cache;
        private Map<String, String> requestHeader;

    /*    public Builder(Context context) {
            this.context = context;
            cache = new HashSet<String>();
            requestHeader = new HashMap<String, String>();
            indexName = "index";
            path = context.getFilesDir() + File.separator + "website" + File.separator;
        }*/
        public Builder() {
            cache = new HashSet<String>();
            requestHeader = new HashMap<String, String>();
            indexName = "index";
            path = "/Users/weizhang/Documents/temp" + File.separator + "website" + File.separator;
        }

        /**
         * @param path where the file will be stored
         * @return
         */
        public Builder savePath(String path) {
            if (path.lastIndexOf(File.separator) != (path.length() - 1)) {
                path = path + File.separator;
            }
            this.path = path;
            return this;
        }

        /**
         * @param indexName default is index.html
         * @return
         */
        public Builder indexName(String indexName) {
            this.indexName = indexName;
            return this;
        }

        /**
         * @param extension Add extensions you want to cache
         * @return
         */
        public Builder cache(String extension) {
            cache.add(extension);
            return this;
        }

        /**
         * @param key   key of request header
         * @param value value of request header
         * @return
         */
        public Builder requestHeader(String key, String value) {
            requestHeader.put(key, value);
            return this;
        }

        /**
         * @param absoluteAllPaths whether replace all the paths into absolute path
         * @return
         */
        public Builder absoluteAllPaths(boolean absoluteAllPaths) {
            this.absoluteAllPaths = absoluteAllPaths;
            return this;
        }

        /**
         * @param separatorSourceFile if set false every resource will store in the same recourse file
         * @return
         */
        public Builder separatorSourceFile(boolean separatorSourceFile) {
            this.separatorSourceFile = separatorSourceFile;
            return this;
        }

        public WebsiteDownloader build() {
            return new WebsiteDownloader(this);
        }
    }
}
