package day_01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
/**
 * 创建序列 seq_userinfo_id_zhangw
 * 从1开始，步进为1
 * @author soft01
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@172.88.0.20:1521:tarena",
"jsd1707","tarena");
			Statement state=conn.createStatement();
			String sql="CREATE SEQUENCE seq_userinfo_id_zhangw "
					+"START WITH 1 "
					+"INCREMENT BY 1";
			state.executeUpdate(sql);
			System.out.println("view of seq_userinfo_id_zhangw has been created.");
	//		String dropSequence="DROP SEQUENCE seq_userinfo_id_zhangw";
		//	state.executeUpdate(dropSequence);
			
			conn.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
