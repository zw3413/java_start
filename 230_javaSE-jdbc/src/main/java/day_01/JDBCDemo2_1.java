package day_01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCDemo2_1 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@172.88.0.20:1521:tarena","jsd1707","tarena");
			Statement state=conn.createStatement();
			String sql="CREATE SEQUENCE seq_userinfo_id_zhangw1";
			state.executeUpdate(sql);
		//	String dropSequence="DROP SEQUENCE seq_userinfo_id_zhangw1";
		//	state.executeUpdate(dropSequence);
			conn.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
