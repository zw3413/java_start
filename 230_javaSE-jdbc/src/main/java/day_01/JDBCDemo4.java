package day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
/**
 * 输入一个用户名，然后将该用户删除
 * @author soft01
 *
 */
public class JDBCDemo4 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.88.0.20:1521:tarena",
					"jsd1707","tarena");
			Statement state=conn.createStatement();
			System.out.println("connected.");
			String line="";
			String username="";
			String sql="";
			Scanner scan=new Scanner(System.in);
			while(!"exit".equals(line=scan.nextLine()))	{
				username=line.trim();
				sql="DELETE FROM UserInfo_zhangw WHERE username= '"+username+"'";
				state.executeUpdate(sql);
				System.out.println(username +" record has been deleted.");
			}
			conn.close();
			scan.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
