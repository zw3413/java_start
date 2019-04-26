package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//容器在启动的时候会自动加载此类，bean id为类名首字母小写
/*
 * http://ip:port/spring-appname/hello.do
 */
public class HelloController {
	
	@RequestMapping("/hello.do")//该注解可以添加到类前面或者方法前面，表示请求路径
	public String hello() {
		System.out.println("hello()");
		//返回视图名
		return "hello";
	}

}
