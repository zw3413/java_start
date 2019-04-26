package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentLengthFilter implements Filter{

	private FilterConfig config;

	public CommentLengthFilter() {
		System.out.println("CommentLengthFilter()");
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("CommentLengthFilter.destroy() ");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("CommentLengthFilter.doFilter() begin...");
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String number=config.getInitParameter("number");
		String content=request.getParameter("content");
		if(content!=null) {
			if(content.length() > Integer.parseInt(number)){
				out.println("字数超过限制，请保持输入字数小于:"+number);
			
			}else {
				arg2.doFilter(arg0, arg1);
			}
		}else {
			throw new RuntimeException("没有在request对象中找到comment参数");
		}
		System.out.println("CommentLengthFilter.doFilter() end..");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentLengthFilter.init() ");
		this.config=arg0;
	}

}
