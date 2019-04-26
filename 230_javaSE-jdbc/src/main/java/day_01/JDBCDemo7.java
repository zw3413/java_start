package day_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 完成登陆功能
 * 要求用户输入用户名和密码
 * 若userinfo表中有对应数据，则显示登陆成功
 * 否则显示登陆失败
 * @author soft01
 *
 */
public class JDBCDemo7 {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("input the username:");
			String username=scan.nextLine().trim();
			System.out.println("input the password:");
			String password=scan.nextLine().trim();
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			
			String sql="		SELECT username,password,nickname,account "+
								"			FROM userinfo_zhangw "
							+ "			WHERE username= '" +username+ "'"
							+ "				AND password= '"+password+"' ";
			ResultSet rs=state.executeQuery(sql);
			if(rs.next()) {
				System.out.println("登陆成功！");
			}else {
				System.out.println("登陆失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
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
