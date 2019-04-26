package com.tedu.service;

import java.io.File;

import com.tedu.core.Servlet;
import com.tedu.dao.UserInfoDAO;
import com.tedu.http.HttpRequest;
import com.tedu.http.HttpResponse;

import entities.UserInfo;

public class UpdateServlet extends Servlet{

	public void service(HttpRequest request,HttpResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		int account=Integer.parseInt(request.getParameter("account"));
		
		UserInfo userinfo=new UserInfo();
		userinfo.setPassword(password);
		userinfo.setNickname(nickname);
		userinfo.setAccount(account);
		userinfo.setUsername(username);
		System.out.println(userinfo);
		try {
			UserInfoDAO dao=new UserInfoDAO();
			if(dao.findByUsername(username)==null) {
				//用户不存在
				System.out.println(username+" 没有找到此用户名");
				forward(new File("webapp/update_fail1.html"),response);
			}else {
				if(dao.update(userinfo)) {
					//更新成功
					System.out.println("更新成功");
					forward(new File("webapp/update_ok.html"),response);
				}else {
					//其他错误
					System.out.println("更新失败，其他问题");
					forward(new File("webapp/update_fail2.html"),response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
