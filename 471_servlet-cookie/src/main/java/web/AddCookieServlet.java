package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//牛奶器访问本服务，本服务为本次请求创建cookie,
		//并发送set-cookie消息头给牛奶器，让牛奶器在其本地创建cookie,
		//以后每次牛奶器访问本ip的时候，都会将所保存的cookie随消息头发往服务器。
		Cookie c=new Cookie("uname","king");
		c.setMaxAge(40);
		response.addCookie(c);
		Cookie c2=new Cookie("city",URLEncoder.encode("北京","utf-8"));
		response.addCookie(c2);
	}
}
