package com.tedu.core;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.Socket;

import org.dom4j.DocumentException;

import com.tedu.common.HttpContext;
import com.tedu.dao.ServletMapping;
import com.tedu.http.HttpRequest;
import com.tedu.http.HttpResponse;
import com.tedu.service.LogServlet;
import com.tedu.service.RegServlet;
import com.tedu.service.UpdateServlet;
/**
 * 处理响应客户连接的线程
 * @author soft01
 *
 */
public class ClientHandler implements Runnable{
	
	private Socket socket;
	private HttpRequest request;
	private HttpResponse response=null;
	private String head;
	static {
		try {
			ServletMapping.initServletMapping();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public ClientHandler(Socket socket) throws Exception{
		this.socket=socket;
		head=this.getClass().getName()+" "+Thread.currentThread().getId()+" ";
	}
	/**
	 * 线程所执行的任务：(non-Javadoc)
	 * 1.用socket得到is
	 * 2.使用is得到请求信息
	 * 3.进行相应的处理
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		InputStream in=null;
		try{
			//创建对应的请求对象
			System.out.println(head+"创建/初始化/解析 request 对象。");
			request=new HttpRequest(socket.getInputStream());
			//创建对应的响应对象
			System.out.println(head+"创建并初始化 response 对象。");
			response=new HttpResponse(socket.getOutputStream());
		}catch(RuntimeException e){
			e.printStackTrace();
			System.out.println(head+"---------------遇到错误，即将关闭线程-------------");
			return;
		}catch(Exception e){
			e.printStackTrace();
///*----->>*/throw e;
		}
			/*
			 * 处理用户请求
			 */
		try{
			//获取用户请求资源路径
			/*
			 * //index.html
			 */
			File file=new File("webapp"+request.getUri());
			//默认首页功能
			if(file.isDirectory())
				file=new File(file.getPath()+File.separator+"index.html");
			if(file.exists()){
				System.out.println(head+"检测到所请求的文件资源，开始创建响应消息。");
				int status=HttpContext.STATUS_CODE_OK;
				response.responseFile(status,file);
			//查看是否请求一个功能
			}
//			else if("reg".equals(request.getUri())){
//				System.out.println(head+"开始注册");
//				RegServlet servlet=new RegServlet();
//				servlet.service(request,response);
//				
//			}else if("login".equals(request.getUri())){
//				System.out.println(head+"开始登录");
//				LogServlet servlet=new LogServlet();
//				servlet.service(request, response);
//				
//			}else if("update".equals(request.getUri())) {
//				System.out.println(head+"开始更新");
//				UpdateServlet servlet=new UpdateServlet();
//				servlet.service(request, response);
//				
//			}
			else{
				try {
					invoke(request.getUri(),request,response);
				}catch(Exception e) {
					System.out.println(head+"没有找到所请求的资源，开始创建404响应消息,不包含响应正文。");
					File file404=new File("webapp"+file.separator+"404.html");
					int status=HttpContext.STATUS_CODE_NOTFOUND;
					response.responseFile(status,file404);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(socket!=null){
				try{
					System.out.println(head+"响应完毕，关闭socket，结束线程。");
					socket.close();
					System.out.println("-------------------------------------");
					try {
						this.finalize();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void invoke(String uri,HttpRequest request,HttpResponse response)throws Exception {
		//根据uri找到类名
		//动态加载类到内存
		//动态创建对象
		//动态查找方法 service
		//动态调用方法
		System.out.println(head+"开始根据浏览器请求的URL通过反射查找相应的servlet");
		String className=ServletMapping.get(uri);
		Class cls=Class.forName(className);
		Object obj=cls.newInstance();
		Method method=cls.getDeclaredMethod("service", request.getClass(),response.getClass());
		System.out.print(head);
		System.out.print(" 已经找到 \"");
		System.out.print(uri);	
		System.out.print("\"相应的servlet:\"");
		System.out.print(className);
		System.out.println("。开始执行。");
		method.invoke(obj,request,response);
	}
}
