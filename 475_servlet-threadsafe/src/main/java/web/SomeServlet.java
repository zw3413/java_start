package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 解决servlet线程安全问题：
		 * 1. 加锁
		 * 2. 尽量在servlet中避免对属性的修改。
		 */
		synchronized(this) {
			try {
				count++;
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+":"+count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
