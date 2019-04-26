package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.UserDAO;
import entity.Employee;
import entity.User;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		//获得请求资源路径
		String uri=request.getRequestURI();
		System.out.println("uri:"+uri);
		//分析请求资源路径
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//依据分析结果做不同的处理
		if("/index".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);;
			
		}else if("/list".equals(action)) {
			System.out.println("处理员工列表请求");
			EmployeeDAO dao=null;
			try {
				dao=new EmployeeDAO();
			}catch(Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，稍后重试。");
			}
			try {
				List<Employee> list=dao.listAll();
				//转发给listEmp.jsp来输出表格
				//step1.将对象绑定到request对象上
				request.setAttribute("employees", list);
				//step2.获得一个转发器
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/listEmp.jsp");
				//step3.使用转发器转发
				rd.forward(request, response);
				
			}catch(Exception e) { 
				out.println("系统繁忙，请稍后再试。");
			}
		}else if("/toAdd".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/addEmp.jsp").forward(request, response);
		}else if("/add".equals(action)){
			System.out.println("处理添加员工请求");
			//读取员工信息
			String name=request.getParameter("name");
			double salary=Double.parseDouble(request.getParameter("salary"));
			int age=Integer.parseInt(request.getParameter("age"));
			
			//将员工信息插入到数据库
			EmployeeDAO dao=new EmployeeDAO();
			Employee e=new Employee();
			e.setEname(name);
			e.setSalary(salary);
			e.setAge(age);
			try {
				dao.save(e);
				//重定向到员工列表
				//重定向之前会清空response对象上存放的所有数据
				response.sendRedirect(request.getContextPath()+"list.do");
			}catch(RuntimeException e1) {
				e1.printStackTrace();
				out.println("系统繁忙，稍后重试。");
			}
		}else if("/load".equals(action)) {
			System.out.println("加载所要修改的记录。");
			String id=request.getParameter("id");
			EmployeeDAO dao=new EmployeeDAO();
			try {
				Employee e=dao.findById(Integer.parseInt(id));
				//获取所要修改的员工信息之后，将其绑定到request对象，转发至updateEmp.jsp处理
				request.setAttribute("employee", e);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/updateEmp.jsp");
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，请稍后重试。");
			}
		}else if("/update".equals(action)) {
			System.out.println("更新所要修改的记录。");
			//读取员工信息
			Employee e=new Employee();
			e.setId(Integer.parseInt(request.getParameter("id")));
			e.setEname(request.getParameter("name"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setAge(Integer.parseInt(request.getParameter("age")));
			//修改数据库中的员工信息
			EmployeeDAO dao=new EmployeeDAO();
			try {
				dao.update(e);
				response.sendRedirect("list.do");
			}catch(Exception e1) {
				e1.printStackTrace();
				out.println("系统繁忙，请稍后再试。");
			}
		}else if("/del".equals(action)) {
			System.out.println("删除记录");
			try {
				String id=request.getParameter("id");
				EmployeeDAO dao=new EmployeeDAO();
				boolean flag=dao.deleteById(id);
				if(flag) {
					//删除成功
					response.sendRedirect("list.do");
				}else {
					//删除失败
					response.sendRedirect("list.do");
				}
	
			}catch(Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，请稍后再试。");
			}
		}else if("/toRegist".equals(action)) {
			request.getRequestDispatcher("WEB-INF/regist.jsp").forward(request, response);
		}else if("/regist".equals(action)) {
			
			User user=new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("pwd"));
			user.setName(request.getParameter("name"));
			user.setGender(request.getParameter("sex"));
			UserDAO dao=new UserDAO();
			try{
				dao.save(user);
					//注册成功，转到 login.jsp页面，regisResult设置为 注册成功
				request.setAttribute("msg", "注册成功！");
				RequestDispatcher rd=request.getRequestDispatcher(	"/WEB-INF/login.jsp");
				rd.forward(request, response);
			}catch(Exception e) {
				//注册失败，转发回regist.jsp页面，设置registResult为 保存失败，请重试...
				e.printStackTrace();
				request.setAttribute("msg", "注册失败，请重试...");
				RequestDispatcher rd=request.getRequestDispatcher(	"/WEB-INF/regist.jsp");
				rd.forward(request, response);
			}
		
		}else if( "/toLogin".equals(action)) {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if("/login".equals(action)) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			UserDAO dao=new UserDAO();
			User user=dao.findByUsernameAndPassword(username,password);
			try {
				if(user!=null && password.equals(user.getPassword())&&username.equals(user.getUsername())) {
					//找到，登陆成功，转往操作页面，获取session
					session.setAttribute("user", user);
					request.setAttribute("msg", "登陆成功");
					RequestDispatcher rs=request.getRequestDispatcher("/WEB-INF/index.jsp");
					rs.forward(request, response);
				}else {
					//没有注册，建议用户前往注册,转回login.jsp页面，loginResult设置为“用户名或密码错误”
					String loginResult="登陆失败，请检查用户名和密码";
					request.setAttribute("msg", loginResult);
					RequestDispatcher rs=request.getRequestDispatcher("/WEB-INF/login.jsp");
					rs.forward(request, response);
				}
			}catch(Exception e) {
				//登陆出现异常，系统繁忙，请稍后重试。转回login.jsp页面，loginResult设置为 ”系统繁忙，请稍后重试“
				e.printStackTrace();
				String loginResult="系统繁忙，请稍后重试。";
				request.setAttribute("msg", loginResult);
				RequestDispatcher rs=request.getRequestDispatcher("/WEB-INF/login.jsp");
				rs.forward(request, response);
			}
		}else if("/logout".equals(action)) {
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/index.html");
		}
		out.close();
	}
		
}
