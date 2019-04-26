package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static {
		try {
		Properties prop=new Properties();
		prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
			
			ds=new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	public static Connection getConnection() throws SQLException{
		
		Connection conn=ds.getConnection();
		return conn;
		
	}
	public static void closeConnection(Connection conn) throws Exception{
		if(conn!=null) {
			try {
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	}
}
