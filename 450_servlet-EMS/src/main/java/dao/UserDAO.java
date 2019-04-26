package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DBUtil;

public class UserDAO {

	public void save(User user) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO t_user_zhangwei"
					+ "		VALUES("
					+ "		t_user_seq_zhangwei.nextval,"
					+ "		?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getGender());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public User findByUsernameAndPassword(String username, String password) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT * FROM t_user_zhangwei WHERE username=? AND password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				//查到了对应信息，返回true
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				return user;
			}else {
				//没有查到对应信息，返回false
				return null;
			}
		}catch(Exception e) {
			//发生异常，抛出
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
}
