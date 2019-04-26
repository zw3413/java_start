package com.tedu.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tedu.common.HttpContext;
/**
 * Http请求对象
 * 封装一个Http请求相关信息
 * @author soft01
 */
public class HttpRequest {
	private String head;
/*
 * 请求行相关信息
 */
	//请求方法
	private String method;
	//请求资源URI （URI统一资源定位）
	private String uri;
	//请求协议版本
	private String protocol;
	//消息报头信息
	private Map<String,String> header;
	//存储客户端传递过来的参数
	private Map<String,String> parameters;
	
	public HttpRequest(InputStream is) throws Exception{
		head=this.getClass().getName()+" "+Thread.currentThread().getId()+" ";
		System.out.println(head+"HttpRequest构造方法执行");
		try{
			//1.解析请求行
			parseRequestLine(is);
			//2.解析消息头
			parseRequestHeader(is);
			//3.解析消息正文(略)
			
			System.out.println(head+"初始化/解析 HttpRequest 完成。");
		}catch(Exception e){
			throw e;
		}
	}
	private void parseRequestHeader(InputStream is) throws IOException {
		/*
		 * 消息头由若干行组成
		 * 每行格式：
		 * name:valueCRLF
		 * 当多有消息头全部发送过来后，浏览器会单独发送一个CRLF结束
		 * 
		 * 实现思路：
		 * 1：死循环下面步骤
		 * 2：读取一行字符串
		 * 3：判断该字符串是否为空字符串
		 * 	若是空字符串说明读到最后单独的CRLF，那么就可以停止循环，不用再解析消息头信息
		 * 4：若不是空串，则按照“：”截取名字与对应的值，并存入header这个Map中
		 */
		System.out.println(head+"解析 消息头 开始执行");
		String line="";
		int i=0;
		header=new HashMap<String,String>();
		while((line=readLine(is)).length()!=0){
			int index=line.indexOf(":");
			header.put(line.substring(0, index), line.substring(index+1).trim());
		}
		System.out.println(head+"消息头解析完毕。");
		System.out.println(head+"解析到以下信息：");
		Set<Entry<String,String>> set=header.entrySet();
		for(Entry e:set){
			System.out.println(e.getKey()+"="+e.getValue());
		}
	}
	
	private void parseRequestLine(InputStream is) throws IOException {
		System.out.println(head+"解析 请求行 开始执行");
		String line=readLine(is);
		System.out.println(head+line);
		//判断一下是否是空的请求行，如果是，抛出异常，结束线程。如果不是，继续执行。
		if(!(line.length()>0)){
			System.out.println(head+"侦测到空的请求行,即将结束进程。");
		//空的请求行，抛出异常，结束线程。
			throw new RuntimeException(head+"空的请求行！！结束线程。");
		}
		String[] str=line.split("\\s");
		method=str[0];
		//uri=str[1];
		parseUri(str[1]);
		System.out.print(" uri:"+uri);
		protocol=str[2];
		System.out.println(head+"解析 请求行 完毕!");
		System.out.println(head+"解析到以下信息：");
		System.out.println("method="+method);
		System.out.println("uri="+uri);
		System.out.println("protocol="+protocol);
	}
	private String readLine(InputStream is) throws IOException{
		/*
		 * 连续读取若干字符，直到连续读到了CR（13）LF（10）为止
		 */
		//c1是本次读到的字符，c2是上次读到的字符
		StringBuilder builder=new StringBuilder();
		int c1=-1,c2=-1;
		try{
			while((c1=is.read())!=-1){
				if(c1==HttpContext.LF&&c2==HttpContext.CR){
					break;
				}
				builder.append((char)c1);
				c2=c1;
			}
		}catch(IOException e){
			e.printStackTrace();
			throw e;
		}
		String line=builder.toString().trim();
		return line;
	}
	public Map<String,String> getHeader(){
		return header;
	}
	public String getMethod() {
		return method;
	}
	public String getUri() {
		return uri;
	}
	public String getProtocol() {
		return protocol;
	}
	/**
	 * 处理uri
	 */
	private void parseUri(String uri){
		/**
		 * http://localhost:8088/index.html
		 * http://localhost:8088/reg?username=zhang&password=198887&nickname=wei
		 * 在GET请求中，URI可能会有上面两种情况。
		 * HTTP协议中规定，GET请求中的URI可以传递参数，
		 * 而规则是请求的资源后面以“？”分隔，之后则为所有要传递的参数，每个参数由：name=value的格式保存，每个参数之间使用“&”分割。
		 * 这里的处理要求：
		 * 将"?"之前的内容保存到属性uri上
		 * 将“？”之后的每个参数放入属性parameters中，
		 * 其中key为参数名，value为参数值。
		 */
		//1.实例化HashMap用于初始化属性parameters
		parameters=new HashMap<String,String>();
		if(uri.contains("?")){
			String[] str=uri.split("/");
			String path=str[1];
			System.out.println("path: "+path);
			this.uri="/" +path.split("\\?")[0];
			String parameterStr=path.split("\\?")[1];
			String[] paraStrArry=parameterStr.split("&");
			for(int i=0;i<paraStrArry.length;i++){
				String name=paraStrArry[i].split("=")[0];
				String value=null;
				if(paraStrArry[i].split("=").length>1) {
					value=paraStrArry[i].split("=")[1];
				}
				parameters.put(name,value );
			}
		}else{
			this.uri=uri;
		}
	}
	/**
	 * 根据参数名，获取参数值
	 */
	public String getParameter(String name){
		return parameters.get(name);
	}
}
