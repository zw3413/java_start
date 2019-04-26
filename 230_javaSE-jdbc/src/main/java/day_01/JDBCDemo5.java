package day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 指定DQL语句
 * @author soft01
 *
 */
public class JDBCDemo5 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@172.88.0.20:1521:tarena",
					"jsd1707",
					"tarena");
			Statement state=conn.createStatement();
			System.out.println("connected.");
			/**
			 * SELECT id,username,password,nickname,account FROM UserInfo_zhangw
			 */
			String sql="SELECT id,username,password,nickname,account "
					+"FROM UserInfo_zhangw ";
			
			//ResultSet executeQuery(String sql)
			//专门用来执行DQL语句的，返回值为查询的结果集，用ResultSet实例返回。
			ResultSet rs=state.executeQuery(sql);
			/*
			 * 创建UserInfo表
			 * 字段：
			 * id NUMBER(6)				//用户ID
			 * username VARCHAR2(32)	//用户名
			 * password VARCHAR2(32)	//密码
			 * nickname VARCHAR2(32)	//昵称
			 * account NUMBER(10)		//账户余额
			 */
			while(rs.next()) {
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String nickname=rs.getString("nickname");
				int account=rs.getInt("account");
				System.out.println(id+","+username+","+password+","+nickname+","+account);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
