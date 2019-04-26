package com.tedu.service;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tedu.core.Servlet;
import com.tedu.dao.UserInfoDAO;
import com.tedu.db.DBUtil;
import com.tedu.http.HttpRequest;
import com.tedu.http.HttpResponse;

import entities.UserInfo;

/**
 * 用来完成用户注册功能
 * @author soft01
 */
public class RegServlet extends Servlet{	

	private String head;
	private static final String PATH="webapp/userinfo.txt";
	
	public void service(HttpRequest request, HttpResponse response) throws Exception {
		head=this.getClass().getName()+" "+Thread.currentThread().getId()+" ";
		System.out.println(head+"开始注册...");
		/*
		 * 将用户的注册信息按行写入到
		 * userinfo.txt文件中。
		 * 每行为一条用户的信息，格式：
		 * username,password,nickname
		 * 例如：
		 * fanchuanqi,123456,fanfan
		 * liucangsong,223224,cangcang
		 */
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		
		UserInfo userinfo=new UserInfo(username,password,nickname,5000);
		UserInfoDAO dao=new UserInfoDAO();
		
		UserInfo ui=dao.findByUsername(username);
		if(ui!=null) {
			System.out.println("用户名已经存在");
			//注册失败，用户名已经存在
			forward(new File("webapp/reg_fail2.html"),response);
			
		}else {
			//用户名不存在，开始注册
			if(dao.save(userinfo)) {
				//注册成功
				forward(new File("webapp/reg_ok.html"),response);
			}else {
				//注册失败，数据库操作失败。
				forward(new File("webapp/reg_fail1.html"),response);
			}
		}
		
		
		
		
	}
}
