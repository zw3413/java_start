package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import day_01.DBUtil;

/**
 * 转账功能
 * 输入转出帐号的用户名，再输入转入账户的用户名
 * 最后输入要转账的金额完成转账操作
 * 
 * @author soft01
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("input the source username:") ;
		String usernameFrom=scan.nextLine().trim();
		System.out.println("input the destination username:");
		String usernameTo=scan.nextLine().trim();
		System.out.println("input the numer:");
		String number=scan.nextLine().trim();
		scan.close();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			/*
			 * JDBC默认时自动提交事务的，即：每当执行一条DML操作后都会提交事务
			 * 
			 * 若希望自行控制事务，需要将自动提交事务关闭
			 */
			conn.setAutoCommit(false);
			String sqlFrom="UPDATE userinfo_zhangw"
					+ "					SET account=account+? "
					+ "					WHERE username=? ";
			PreparedStatement psFrom=conn.prepareStatement(sqlFrom);
			psFrom.setString(1, number);
			psFrom.setString(2, usernameFrom);
			int d=psFrom.executeUpdate();
			if(d>0) {
				String sqlTo="UPDATE userinfo_zhangw"
						+ "				SET account=account-? "
						+ "				WHERE username=? ";
				PreparedStatement psTo=conn.prepareStatement(sqlTo);
				psTo.setString(1, number);
				psTo.setString(2,usernameTo);
				d=psTo.executeUpdate();
				if(d>0) {
					System.out.println("转账成功");
					//提交事务
					conn.commit();
				}else {
					System.out.println("转账失败");
					//回滚事务
					conn.rollback();
				}
			}
			
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
