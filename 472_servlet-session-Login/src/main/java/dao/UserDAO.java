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
			String sql="INSERT INTO t_user_zhangwei "
					+ "		VALUES( "
					+ "		t_user_seq_zhangwei.nextval,?,?,?,? )";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getGender());
			ps.execute();
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
	
	public User findByUsername(String username) {
		
		User user=null	;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT * FROM t_user_zhangwei WHERE username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
			}
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
		return user;
	}
}
