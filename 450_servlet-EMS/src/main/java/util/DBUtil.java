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
			//Class.forName("oracle.jdbc.dirver.OracleDriver");
			//Connection conn=DriverManager.getConnection("jdbc:oracle:thin@172.88.8.20:1521:tarena","jsd1707","tarena");
		/*
		 * DBUtil.class.getClassLoader():获得加载DBUtil的类加载器
		 * 
		 * getResourceAsStream是类加载器提供的方法，
		 * 会根据类路径去查找属性文件(.properties文件），
		 * 然后返回一个InputStream.
		 * 
		 */
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
