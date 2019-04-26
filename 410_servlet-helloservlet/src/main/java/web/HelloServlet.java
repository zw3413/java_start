package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public HelloServlet() {
		System.out.println("HelloServlet");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		System.out.println("service()");
		String name=request.getParameter("name");
		/*
		 * 告诉浏览器服务器返回的数据类型，
		 * （了解）
		 * 设置content-type消息头，用来告诉浏览器，
		 * 服务器返回的数据的mime类型（由http协议规定）。
		 */
		
		response.setContentType("text/html");
		/*
		 * 将数据写入response对象。
		 * (了解）
		 * servlet容器会从response对象中获取数据，然后打包发送给浏览器
		 */
		PrintWriter out=response.getWriter();
		out.println("<h1>Hello "+name+"</h1>");
		out.println("<p> 1. request.toString():"+request.toString()+"</p>");
		out.println("<p> 2. request.getMethod():"+request.getMethod()+"</p>");
		out.println("<p> 3. request.getRequestURI():"+request.getRequestURI()+"</p>");
		out.println("<p> 4. request.getProtocol():"+request.getProtocol()+"</p>");
		out.println("<p> 5. request.getAttributeNames():"+request.getAttributeNames()+"</p>");
		out.close();
	}
}
