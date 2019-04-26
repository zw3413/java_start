package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import day_01.DBUtil;

/**
 * 预编译SQL语句
 * 
 * Statement适合执行静态SQL语句。即：SQL语句中没有拼接动态数据
 * PreparedStatement适合执行动态SQL。
 * 
 * 数据库收到SQL语句时，会理解该SQL语句并生成一个对应的执行计划（生成执行计划开销很大）
 * 但是若重复发送同样SQL语句时，数据库会重用生成的执行计划。但是只要SQL语句中有动态数据，哪怕语句一致，数据不同，
 * 也不会重用执行计划，每次都会生成新的执行计划。为此，当含有动态数据但是语义相同的SQL要被执行时应当使用预编译SQL。
 * 
 * @author soft01
 *
 */
public class PreparedStarementDemo {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("input the username:");
			String username=scan.nextLine().trim();
			System.out.println("input the password:");
			String password=scan.nextLine().trim();
			conn=DBUtil.getConnection();
			String sql="SELECT id,username,password,nickname,account "
							+ "	FROM userinfo_zhangw " +
								"	WHERE username= ? "
								+ "AND password=?";
			/*
			 * preparedStatement在创建的时候就需要将预编译的SQL语句传入，并发送给数据库先生成对应的执行计划
			 */
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			/*
			 * 哪怕密码中包含SQL敏感字符（SQL注入攻击），也只会将其当作密码看待，而不会再改变SQL语义。
			 */
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登陆失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
			
			
			
			
		}
}
