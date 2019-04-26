package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取servlet上下文对象
		ServletContext sc=getServletContext();
		//从servlet上下文对象中获取绑定数据
		String userlist=(String)sc.getAttribute("userlist");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(userlist);
		
		//读取全局的初始化参数
		String company=(String)sc.getInitParameter("company");
		out.println(company);
		out.close();
		
	}
}
