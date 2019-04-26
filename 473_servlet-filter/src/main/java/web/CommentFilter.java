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

public class CommentFilter implements Filter{
	
	private FilterConfig config;
	
	/*
	 * 容器启动之后，会立即创建过滤器实例
	 * （只会创建一个)
	 */
	
	public CommentFilter() {
		System.out.println("CommentFilter()");
	}
	/*
	 * 容器销毁过滤器之前，会调用
	 * destroy()方法（只会执行一次)
	 */
	public void destroy() {
		System.out.println("CommentFilter.destroy()");
	}
	/*
	 * 初始化之后，容器会调用doFilter方法处理请求.
	 * FilterChain对象（过滤器链)：如果调用了该对象的doFilter方法，容器会继续向后调用
	 * （即继续调用后面的filter或者servlet），否则中断请求，返回结果。
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		
		System.out.println("CommentFilter.doFilter() begin.");
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String content=request.getParameter("content");
		//读取初始化参数
		String illegal=config.getInitParameter("illegal");
		if(content.indexOf(illegal) != -1){
			//中断请求，返回结果
			out.println("评论内容非法.");
		}else {
			//继续向后调用
			arg2.doFilter(arg0,arg1);
		}
		System.out.println("CommentFilter.doFilter() end.");
	}
/*
 * 实例化之后，会立即初始化。init方法只会调用一次。
 * 注：FilterConfig对象用于读取初始化参数
 * 同 servlet的初始化函数 init(ServletConfig config)中的ServletConfig类似，都是来自于web.xml的初始化参数
 */
	public void init(FilterConfig arg0) throws ServletException {
		config=arg0;
		System.out.println("CommentFilter.init()");
		
	}

	
	
}
