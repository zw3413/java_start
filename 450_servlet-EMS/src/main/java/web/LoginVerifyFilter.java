package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class LoginVerifyFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;

		ServletContext sc=request.getServletContext();
		//获取当前请求的session对象，如果没有，就创建一个新的。
		HttpSession session=request.getSession();
		//获取当前请求的session对象中的user对象
		entity.User user=(User) session.getAttribute("user");
		if(user==null) {
			//还未登陆，没有获取有效session。创建session并转发到login.jsp页面
			request.setAttribute("msg", "请先登陆...");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else {
			arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
