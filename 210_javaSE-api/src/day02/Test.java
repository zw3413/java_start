package day02;

/**
 * 解析HTTP请求中的请求信息
 * 请求行格式
 * method uri protocol-version
 * 方法 资源路径 协议版本
 * 
 * 例如：
 * GET /index.html HTTP/1.1
 * 
 * @author soft01
 */
public class Test {

	public static void main(String[] args) {
		
		String method;
		String url;
		String protocol;
		String request="Get /reg?username=fanchuanqi&password=123456 HTTP/1.1";
		String regex="\\w+\\s+/\\w+\\?\\w+=\\w+&\\w+=\\w+\\s\\w+/\\w\\.\\w";

		System.out.println(request.matches(regex));
		
		String[] data=request.split("\\s");
		method=data[0];
		url=data[1];
		protocol=data[2];
		System.out.println("method="+method);
		System.out.println("url="+url);
		System.out.println("protocol="+protocol);
		parseUrl(url);
	}
	public static void parseUrl(String url){
		/*
		 * loc:/reg
		 * username:fanchuangqi
		 * password:123456
		 */
		String[] data1=url.split("\\?");
		String loc=data1[0];
		String[] data2=data1[1].split("=");
		String username=data2[0];
		String password=data2[2];
		System.out.println("loc:"+loc);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
	
	}
}
