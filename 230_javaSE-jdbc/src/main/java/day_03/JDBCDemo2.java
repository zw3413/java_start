package day_03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day_01.DBUtil;

/**
 * 返回自动主键
 * @author soft01
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			
			String sql="INSERT INTO dept_zhangw "
					+ "		(deptno,dname,loc) "
					+ "		VALUES "
					+ "		(seq_dept_id_zhangw.NEXTVAL,?,?) ";
			PreparedStatement ps=conn.prepareStatement(sql,new String[] {"deptno","dname","loc"});
			
			ps.setString(1, "IT");
			ps.setString(2, "Beijing");
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) {
				int deptno=rs.getInt(1);
				int dname=rs.getInt(2);
				int loc=rs.getInt(3);
				System.out.println(deptno+" "+dname+" "+loc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					DBUtil.closeConnection(conn);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
