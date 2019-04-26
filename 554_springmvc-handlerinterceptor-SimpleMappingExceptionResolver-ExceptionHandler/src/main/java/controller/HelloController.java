package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		
		
		return "hello";
	}
	@RequestMapping("/demo/hello2.do")
	public String hello2() {
		System.out.println("hello2()");
		
		
		return "hello";
	}
	@RequestMapping("/hello1.do")
	public String hello1() {
		System.out.println("hello1()");
			
		return "hello";
	}
	@RequestMapping("/hello3.do")
	public String hello3() {
		System.out.println("hello3()");

		Integer.parseInt("123a");	
		
		return "hello";
	}
	@RequestMapping("/hello4.do")
	public String hello4() {
		System.out.println("hello4()");

		"abc".charAt(10);
		
		return "hello";
	}
	@RequestMapping("/hello5.do")
	public String hello5() {
		System.out.println("hello5()");

		String s=null;
		s.length();
		
		return "hello";
	}
	@ExceptionHandler
	/**
	 * 这是一个异常处理方法（用来处理其他方法所抛出的异常)
	 * e:其他方法所抛出的异常
	 */
	public String handle(Exception e,HttpServletRequest request) {
		System.out.println("handle()");
		if(e instanceof NumberFormatException) {
			request.setAttribute("msg","亲，请输入合法的数字");
			return "error3";
		}
		if(e instanceof StringIndexOutOfBoundsException) {
			request.setAttribute("msg", "亲，下标越界了");
			return "error3";
		}
		return "error";
	}
}
