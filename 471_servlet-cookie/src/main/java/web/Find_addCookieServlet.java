package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Find_addCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//练习：先查看有没有名字为cart的cookie，
		//如果有，则显示该cookie的值，如果没有，则添加 “cart”“1，2，3”。
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//获取浏览器cookie列表
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			String value=null;
			for(Cookie c:cookies) {
				if("cart".equals(c.getName())) { 
					value=c.getValue();
					break;
				}
			}
	
			if(value!=null) {				
				out.println("牛奶器本地已经保存有关于cart的有本网站cookie信息：<br/>");
				out.print("cart=="+value);
			}else {
				out.println("牛奶器的cookie中没有名字为cart的信息，本次response将会使用set-cookie为浏览器添加cart的cookie信息");
				Cookie c=new Cookie("cart","hello");
				response.addCookie(c);
			}
		}else {
			out.println("牛奶器本地没有保存本网站任何cookie信息，"
					+ "本次response将使用set-cookie消息头使浏览器本地添加临时cart cookie信息:"
					+ "cart=\"1,2,3\"");
			Cookie c=new Cookie("cart","hello");
			response.addCookie(c);		
		}
		out.close();
	}
}
