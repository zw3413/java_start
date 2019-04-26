package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import entity.User;
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();//有的话返回，没有的话创建。
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/login".equals(action)) {
			/*
			 * 先比较验证码对不对
			 * 如果验证码，不正确，则返回到登陆页面，并提示用户，
			 * 否则，比较用户名和密码。
			 */
			//用户提交的验证码.
			String number1=request.getParameter("number");
			//session对象绑定的验证码.
			String number2=(String) session.getAttribute("number");
			//比较两个验证码
			if(!number1.equals(number2)) {
				request.setAttribute("number_error", "验证码错误");
				//转发到登陆页面
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
				
			
			
			String username=request.getParameter("username");
			System.out.println(username);
			String password=request.getParameter("pwd");
			UserDAO dao=new UserDAO();
			User user=dao.findByUsername(username);
			if(user!=null) {
				//查找到相应的用户
				if(user.getPassword().equals(password)) {
					//登陆成功,将登陆用户信息绑定到session对象上 
					
					session.setAttribute("user", user);
					response.sendRedirect("index.jsp");
				}else {
					//密码错误,登陆失败，转发到登陆页面，并且提示失败原因
					request.setAttribute("login_failed", "用户名或密码错误。");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}
			}else {
				//没有相应用户
				request.setAttribute("login_failed", "用户名不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}else if("/regist".equals(action)) {
			String username=request.getParameter("username");
			String password=request.getParameter("pwd");
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			User user=new User();
			user.setName(name);
			user.setUsername(username);
			user.setGender(gender);
			user.setPassword(password);
			UserDAO dao=new UserDAO();
			//查询是否已有相同用户名
			try {
				if(dao.findByUsername(user.getUsername())!=null) {
					//已经有相同用户名，返回注册页面，并提示：此用户名已被注册。
					request.setAttribute("username_exisited", "此用户名已注册");
					request.getRequestDispatcher("regist.jsp").forward(request, response);
				}else {
					//用户名还未注册，可以正常注册
					try{
						dao.save(user);
						//保存成功，跳转到登陆页面,并提示注册成功。
						response.sendRedirect("login.jspd");
					}catch(Exception e) {
						e.printStackTrace();
						//保存失败，跳转回注册页面，并且提示，系统繁忙请稍后重试
						request.setAttribute("regist_failed", "系统繁忙，请稍后重试");
						request.getRequestDispatcher("regist.jsp").forward(request, response);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
