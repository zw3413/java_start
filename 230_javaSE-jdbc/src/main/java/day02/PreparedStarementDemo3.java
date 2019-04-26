package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import day_01.DBUtil;

/**
 * 对指定的用户修改密码
 * 输入对应的用户名，然后以及要修改的密码，将其修改
 * @author soft01
 *
 */
public class PreparedStarementDemo3 {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("input the username:");
			String username=scan.nextLine().trim();
			System.out.println("input the new password:");
			String password=scan.nextLine().trim();
			conn=DBUtil.getConnection();
			
			String sql="UPDATE userinfo_zhangw"
					+ "			SET password=? "
					+ "			WHERE username=? ";
					
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2, username);
			int d=ps.executeUpdate();
			if(d>0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}
			ps.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
}