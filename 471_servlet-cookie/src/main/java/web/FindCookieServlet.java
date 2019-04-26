package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FindCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		if(cookies==null) {
			//检查请求消息头，没有发现牛奶器发送cookie信息
			out.println("服务器没有从牛奶器接收到任何cookie.");
		}else {
			for(Cookie c:cookies) {
				out.println(c.getName()+"="+URLDecoder.decode(c.getValue(),"utf-8")+"<br/>");
			}
		}
		out.close();
	}
}
