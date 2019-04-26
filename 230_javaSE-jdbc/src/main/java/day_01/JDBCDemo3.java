package day_01;
/**
 * 要求用户输入用户名 密码 昵称
 * 将该用户存入userinfo_zhangw 表
 * 账户余额默认为 5000；
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo3 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.88.0.20:1521:tarena","jsd1707","tarena");
			System.out.println("connected.");
			Statement state=conn.createStatement();
			String  sql="";
			/*sql="ALTER TABLE UserInfo_zhangw "
					+ " MODIFY( "
					+ "account NUMBER(10) DEFAULT 5000 "
					+ ")";
			state.executeUpdate(sql);*/
			//System.out.println("has altered the table of the field account default to 5000.");
			Scanner scan=new Scanner(System.in);
			String line="";
			System.out.println("please input the username, password, nickname:");
			/*
			 * 创建UserInfo表
			 * 字段：
			 * id NUMBER(6)				//用户ID
			 * username VARCHAR2(32)	//用户名
			 * password VARCHAR2(32)	//密码
			 * nickname VARCHAR2(32)	//昵称
			 * account NUMBER(10)		//账户余额
			 */
			while(!"exit".equals(line=scan.nextLine())) {
				String[] str= line.split(",");
				String username=str[0].trim();
				String password=str[1].trim();
				String nickname=str[2].trim();
				sql="INSERT INTO UserInfo_zhangw "
						+ "(username,password,nickname) "
						+ "VALUES "
						+ "('"+username+"','"+password+"','"+nickname+"')";
				System.out.println(sql);
				state.executeUpdate(sql);
				System.out.println("please input the username, password, nickname: (exit)");
			}
			System.out.println("end.");
			conn.close();
			scan.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
