package web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CheckcodeVerifyFilter implements Filter {
    public CheckcodeVerifyFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//获取session中保存的number数据
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("number");
		String numberS="";
		if(obj!=null) {
			numberS=(String)obj;
		}else {
			throw new RuntimeException("验证码异常");
		}
		String numberR=request.getParameter("number");
		if(numberS.equals(numberR)) {
			//session中保存的验证码与用户输入的验证码一致，验证成功
			chain.doFilter(request, response);			
		}else {
			//用户输入的验证码同session中保存的不一致，验证失败
			request.setAttribute("msg", "验证码输入错误，请重试");
			request.getRequestDispatcher(request.getContextPath()+
					request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"),request.getRequestURI().lastIndexOf("."))+".jsp")
			.forward(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
