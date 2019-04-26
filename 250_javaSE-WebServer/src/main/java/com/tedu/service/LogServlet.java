package com.tedu.service;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tedu.core.Servlet;
import com.tedu.dao.UserInfoDAO;
import com.tedu.db.DBUtil;
import com.tedu.http.HttpRequest;
import com.tedu.http.HttpResponse;

import entities.UserInfo;

public class LogServlet extends Servlet{

	private String head=this.getClass().getName()+" "+Thread.currentThread().getId()+" ";

	public void service(HttpRequest request,HttpResponse response){
	
		try {
			System.out.println(head+ "开始执行登录");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			UserInfoDAO dao=new UserInfoDAO();
			UserInfo userinfo=dao.findByUsernameAndPassword(username, password);
			if(userinfo!=null) {
				//登陆成功
					forward(new File("webapp/login_ok.html"),response);
			}else {
				//登陆失败
				forward(new File("webapp/login_fail1.html"),response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
