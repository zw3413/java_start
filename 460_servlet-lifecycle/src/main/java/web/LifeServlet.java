package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet{
	public LifeServlet() {
		System.out.println("LifeServlet()");
	}
	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		System.out.println("service()");
		PrintWriter out=response.getWriter();
		//通过继承自GenericServlet提供的方法
		//来获得ServletConfig对象
		ServletConfig config=this.getServletConfig();
		out.println(config);
		out.println("<br/>");
		String company=config.getInitParameter("company");
		out.println(company);
		out.println("<br/>");
		out.close();
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy()");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		
	}
}
