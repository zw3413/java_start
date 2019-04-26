package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {
	

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("new session created.");
		HttpSession session=arg0.getSession();
		ServletContext context=session.getServletContext();
		Integer count=(Integer) context.getAttribute("count");
		if(count==null) {
			count=1;
		}else {
			count++;
		}
		context.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

		HttpSession session=arg0.getSession();
		
		Integer count=(Integer) session.getAttribute("count");
		if(count!=null) {
			count--;
		}else {
			count=0;
		}
		session.setAttribute("count", count);
		
		
	}

	
	
}
