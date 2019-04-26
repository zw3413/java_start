package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tedu.db.DBUtil;

import entities.UserInfo;

/**
 * DAO 数据访问对象
 * DAO 是一个层次，该层里的所有类都是和数据库打交道的，作用是将数据操作的功能从业务逻辑层中分离出来，
 * 使得业务逻辑层更专注的处理业务操作，而对于数据的维护操作分离到DAO中。
 * 并且DAO 与业务逻辑层之间用JAVA中的对象来传递数据，这也使得有了DAO可以让业务逻辑层对数据的操作完全面向对象化。
 * @author soft01
 *
 */
public class UserInfoDAO {
	/**
	 * 保存给定的UserInfo对象所表示的用户信息
	 * 
	 */
	public boolean save(UserInfo userinfo)  {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO userinfo_zhangw "
					+ "		(id,username,password,nickname,account) "
					+ "		VALUES "
					+ "		(seq_userinfo_id_zhangw.NEXTVAL,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql,new String[] {"id"});
			ps.setString(1, userinfo.getUsername());
			ps.setString(2, userinfo.getPassword());
			ps.setString(3, userinfo.getNickname());
			ps.setInt(4, userinfo.getAccount());
			int flag=ps.executeUpdate();
			if(flag>0) {
				ResultSet rs=ps.getGeneratedKeys();
				rs.next();
				int id=rs.getInt(1);
				userinfo.setId(id);
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public UserInfo findByUsername(String username) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT id,username,password,nickname,account "
					+ "		FROM userinfo_zhangw "
					+ "		WHERE username= ? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				UserInfo userinfo=new UserInfo(
						rs.getString("username"),rs.getString("password"),
						rs.getString("nickname"),rs.getInt("account"));
				userinfo.setId(rs.getInt("id"));
				return userinfo;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public UserInfo findByUsernameAndPassword(String username,String password) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT id,username,password,nickname,account FROM userinfo_zhangw"
					+ "		WHERE username= ? "
					+ "		AND password= ? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				UserInfo userinfo=new UserInfo(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("nickname"),
						rs.getInt("account"));
				userinfo.setId(rs.getInt("id"));
				return userinfo;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
					DBUtil.closeConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean update(UserInfo userinfo) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="	UPDATE userinfo_zhangw "
					+ "		SET password=?,nickname=?,account=? "
					+ "		WHERE username= ? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userinfo.getPassword());
			ps.setString(2, userinfo.getNickname());
			ps.setInt(3, userinfo.getAccount());
			ps.setString(4, userinfo.getUsername());
			int d=ps.executeUpdate();
			if(d>0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}

}
