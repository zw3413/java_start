package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class SomeServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		System.out.println("service()");
		//获得请求资源路径
		String uri=request.getRequestURI();
		System.out.println("uri:"+uri);
		//分析请求资源路径
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(action);
		//依据分析结果做不同的处理
		if("/list".equals(action)) {
			System.out.println("处理员工列表请求");
		}else if("/add".equals(action)){
			System.out.println("处理添加员工请求");
		}else if("/load".equals(action)) {
			
		}else if("/update".equals(action)) {
			
		}else if("/del".equals(action)) {
			
		}
	}
	public SomeServlet() {
		System.out.println("SomeServlet()");
	}
		
}
