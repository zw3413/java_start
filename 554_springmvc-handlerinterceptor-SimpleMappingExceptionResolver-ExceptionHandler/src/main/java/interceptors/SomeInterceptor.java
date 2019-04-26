package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor {

	/**
	 * DispatcherServlet会先调用拦截器的preHandler方法，如果该方法的返回值为true,
	 * 则继续向后执行（调用后续的拦截器或者是处理器）
	 * Object handler:处理器的方法对象，通过这个对象可以通过java反射得到后面处理器的方法名，参数类型等等，一般不用。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle(()");
		
		return true;
	}
	/**
	 * 处理器的方法已经执行完毕，正准备将处理结果（ModelAndView)返回给前端控制器DispatcherServlet之前，
	 * 执行postHandle方法（可以在该方法里面，修改返回结果）。
	 * ModelAndView modelAndView:处理器返回的处理结果。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle()");
		
	}

	/**
	 * 最后执行的方法
	 * Exception ex:处理器如果发生了异常，可以自己try catch解决，也可以throw出来，交给拦截器处理。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("afterCompletion()");
		
	}

}
