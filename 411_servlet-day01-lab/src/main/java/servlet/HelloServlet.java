package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet()");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("doGet Hello World!");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost()");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("doPost Hello World!");
		out.println("</body>");
	}

	public void doDelete() {
		System.out.println("doDelete()");
	}

	public void doPut() {
		System.out.println("doPut()");
	}
}