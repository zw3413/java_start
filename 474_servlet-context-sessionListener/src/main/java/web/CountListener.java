package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {

	/*
	 * session对象创建之后执行 sessionCreated方法。
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated()");
		//获取ServletContext 通过参数HttpSessionEvent
		HttpSession session=arg0.getSession();
		ServletContext sc=session.getServletContext();
		Integer count=(Integer)sc.getAttribute("count");
		if(count==null) {
			//第一个用户（ServletContext对象上面还没有绑定过 count数据）
			count=1;
		}else {
			//不是第一个用户，则累加
			count++;
		}
		//将最新人数绑定到ServletContext
		sc.setAttribute("count", count);
	}

	/*
	 * session对象销毁之后执行sessionDestroyed方法。
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed");
		//通过HttpSessionEvent对象得到Session对象，再得的ServletContext.
		Integer count=(Integer)arg0.getSession().getServletContext().getAttribute("count");
		count--;
		arg0.getSession().getServletContext().setAttribute("count", count);
	}
	

}
