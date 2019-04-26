package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import day_01.DBUtil;

/**
 * 批量执行语义相同SQL时，PS可以重用执行计划，减小数据库开销
 * @author soft01
 *
 */
public class PreparedStatementDemo2 {
	/**
	 * 
	 * 批量向userinfo表中插入1000条数据
	 * 批量操作影响数据库执行效率主要三个方面：
	 * 1.网络传输
	 * 2.执行计划的生成
	 * 3.事务管理
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO userinfo_zhangw "
					+ "			(id,username,password,nickname,account) "
					+ "			VALUES "
					+ "			(seq_userinfo_id_zhangw.NEXTVAL,?,'123456',?,?) ";
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println("execute the sql");
			for(int i=0;i<1000;i++) {
				ps.setString(1, "test"+i);
				ps.setString(2, "test"+i);
				ps.setInt(3, 5000);
				ps.executeUpdate();
			}
			System.out.println("插入完毕");
			
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
		
	}
}
