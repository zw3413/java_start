package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//设置浏览器的编码格式，以使用相同编码格式来解码。只针对post请求有效。
		//需要写到所有getParameter()方法之前，才能生效。
		request.setCharacterEncoding("utf-8");
		
		//读取身高体重
		String height=request.getParameter("height");
		String weight=request.getParameter("weight");
		String[] interest=request.getParameterValues("interest");
		String name=request.getParameter("name");
		System.out.println("height:"+height+"weight:"+weight);
		for(String s:interest) {
			
			System.out.println("interest:"+s);
		}
		System.out.println("name："+name);
		//计算BMI指数
		double bmi=Double.parseDouble(weight)/
				Double.parseDouble(height)/
				Double.parseDouble(height);
		System.out.println(bmi);
		//依据BMI指数，来判断用户身体的状况
		String status="正常";
		if(bmi<19) {
			status="过轻";	
		}else if(bmi>25) {
			status="过重";
		}
		System.out.println(status);
		//返回结果给浏览器
		/*
		 * 作用1：设置返回给浏览器的数据的MIME类型
		 * （告诉浏览器，服务器返回的数据类型和编码）
		 * 作用2：设置out.println方法在输出时，
		 * 使用哪种字符集来编码。
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		/*
		 * 输出会默认以ISO-8859-1字符集来编码
		 */
		out.println(status);
		out.println(name);
		out.close();
	}
}
