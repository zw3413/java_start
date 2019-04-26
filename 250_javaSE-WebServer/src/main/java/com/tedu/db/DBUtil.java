package com.tedu.db;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库连接的管理类
 * @author soft01
 *
 */

public class DBUtil {
	
	private static BasicDataSource ds;
	
	static {
		try {
			
			Properties prop=new Properties();
			prop.load(new FileInputStream("config.properties"));
			String driverclass=prop.getProperty("driverclass");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int maxactive=Integer.parseInt(prop.getProperty("maxactive"));
			int maxwait=Integer.parseInt(prop.getProperty("maxwait"));
			//连接池
			ds=new BasicDataSource();
			//Class.forname(...)
			ds.setDriverClassName(driverclass);
			//Driver.getConnection(...)
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			//设置最大连接数
			ds.setMaxActive(maxactive);
			//设置最大等待时间
			ds.setMaxWait(maxwait);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取一个数据库连接
	 * @return
	 */
	public static Connection getConnection() throws Exception {
		try {
			/*
			 * 向连接池获取连接
			 * 若连接池中没有可用连接时，该方法会阻塞当前线程，阻塞时间由连接池设置的maxWait决定。
			 * 当阻塞过程中连接池有了可用连接时会立即将连接返回。
			 * 若超时仍然没有可用连接时，该方法会抛出异常。
			 */
			return ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 关闭一个连接
	 * @param args
	 */
	public static void closeConnection(Connection conn) throws Exception {
		try {
			if(conn!=null) {
				conn.setAutoCommit(true);
				/*
				 * 连接池的连接对于close方法的处理是将连接的在连接池中的状态设置为空闲，而非真的将其关闭。
				 */
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
