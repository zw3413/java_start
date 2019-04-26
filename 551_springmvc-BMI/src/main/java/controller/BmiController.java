package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class BmiController {

	@RequestMapping("/toSuccess.do")
	public String toSuccess() {
		System.out.println("toSuccess()");
		return "login_success";
	}
	@RequestMapping("/tobmi.do")
	public String toBmi() {
		return "tobmi";
	}
	
	@RequestMapping("/bmi.do")
	public String bmi(Body body,ModelMap mm) {
		Double height=body.getHeight();
		Double weight=body.getWeight();
		Double bmi=weight/height/height;
		String status="正常";
		if(bmi<19) {
			status="过轻";
		}
		if(bmi>25) {
			status="过重";
		}
		mm.addAttribute("status",status);
		mm.addAttribute("bmi",bmi);
		return "bmi";
	}
	
	@RequestMapping("/tologin.do")
	public String toLogin() {
		System.out.println("toLogin()");
	
		return "login";
	}
	
	@RequestMapping("/login.do")
	/*
	 * DispatcherServlet在调用Controller的方法之前，
	 * 会利用java反射机制分析方法的结构（比如获得方法名，参数类型等等）。
	 * 这儿，发现需要有一个request对象，则DispatcherServlet会将request作为参数传进来.
	 */
	public String login(HttpServletRequest request) {
		System.out.println("login()");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		ModelAndView m=new ModelAndView();
		return "login_success";
	}
	@RequestMapping("/login2.do")
	/*
	 * DispatcherServlet利用java反射分析方法的结构。
	 * 会将对应的请求参数值赋给相应的形参
	 * @RequestParam用来设置请求参数名与形参的对应关系
	 */
	public String login2(String username,@RequestParam("password") String pwd) {
		System.out.println("login2()");
		System.out.println(username);
		System.out.println(pwd);
		return "login_success";
	}
	@RequestMapping("/login3.do")
	/*
	 *DispatcherServlet 根据request参数以及形参打包成bean 传给形参
	 *这是最常用的方法，可以避免形参过多造成的混乱
	 */
	public String login3(User user) {
		System.out.println("login3()");
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		return "login_success";
	}
	@RequestMapping("/login4.do")
	/*
	 */
	public String login4(User user,HttpServletRequest request) {
		System.out.println("login4()");
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		request.setAttribute("username", user.getUsername());
		request.setAttribute("password", user.getPassword());
		//DispatcherServlet默认会 转发 到某个jsp.
		return "login_success";
	}
	@RequestMapping("/login5.do")
	/*
	 */
	public ModelAndView login5(User user) {
		System.out.println("login5()");
		String username=user.getUsername();
		String password=user.getPassword();
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		Map<String,Object> data=new HashMap<String,Object>();
		/*
		 * DispatcherServlet会以key作为绑定名，将数据绑定到request对象上。
		 */
		data.put("username", username);
		data.put("password", password);
		ModelAndView mav=new ModelAndView("login_success",data);
		
		return mav;
	}
	
	@RequestMapping("/login6.do")
	/*
	 * DispatcherServlet 会以addAttribute的绑定名（“username”）作为绑定名，绑定到request对象上
	 */
	
	public String login6(User user, ModelMap mm) {
		System.out.println("login6()");
		String username=user.getUsername();
		System.out.println(username);
		
		mm.addAttribute("username",username);
		
		return "login_success";
	}
	
	@RequestMapping("/login7.do")
	/*
	 * 使用session对象向页面传递参数
	 */
	public String login7(User user,HttpSession session) {
		System.out.println("login7()");
		String username=user.getUsername();
		
		session.setAttribute("username", username);
		
		return "login_success";
	}
	@RequestMapping("/login8.do")
	/*
	 * 返回值为String 时，使用redirect语法来重定向。
	 */
	public String login8() {
		System.out.println("login8()");
		return "redirect:toSuccess.do";
	}
	@RequestMapping("/login9.do")
	public ModelAndView login9() {
		System.out.println("login9()");
		RedirectView rv=new RedirectView("toSuccess.do");
		ModelAndView mav=new ModelAndView(rv);
		return mav;
	}
	
}
