package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_Date extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Date currentTime=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("<p>当前服务器系统时间："+sdf.format(currentTime)+"</P>");
		out.println("<p>传入的用户名为："+name+",年龄为："+age+"</p>");
		out.println("<form action=''>"
				+ "<table style='border:1px solid black;'>"
				+ "<tr><td>name</td><td><input name='name'/></td></tr>"
				+ "<tr><td>age</td><td><input name='age'/></td></tr>"
				+ "<tr><td colspan='2'><input type='submit' value='提交'></td></tr> "
				+ "</table>"
				+ "</form>");
		String a=request.getParameter("a");
		out.println("a:"+a);
		out.close();
	}

}
