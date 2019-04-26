package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过GenericServlet提供的方法来获得上下文.
		ServletContext sc=getServletContext();
		//绑定数据
		sc.setAttribute("userlist", "Sally,Tony");
		
		
		
		
		
		
		
	}

}
