package day_03;

import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import day_01.DBUtil;

/**
 * 批操作
 * 皮操作可以将要执行大量的SQL语句缓存到本地，然后一次性的发给数据库，减少网络调用，提高执行效率。
 * @author soft01
 *
 */
public class JDBCDemo_batch {
	public static void main(String[] args) {

		try {
			Connection conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			for(int i=0;i<100;i++) {
				String sql="	INSERT INTO userinfo_zhangw "
						+ "		(id,username,password,nickname,account) "
						+ "		VALUES "
						+ "		(seq_userinfo_id_zhangw.NEXTVAL,'test_batch_statement','123123','test_batch_statement  "+i
						+" ',5000)";
//				state.executeUpdate(sql);
				state.addBatch(sql);
			}
			int[] d=state.executeBatch();
			for(int i=0;i<d.length;i++) {
				System.out.print(d[i]+" ");
			}
			System.out.println();
			
			conn.setAutoCommit(false);
			String sql="INSERT INTO userinfo_zhangw"
					+ "		(id,username,password,nickname,account)"
					+ "		VALUES"
					+ "		(seq_userinfo_id_zhangw.NEXTVAL,?,'123123',?,5000)";
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<100;i++) {
				ps.setString(1, "test03"+i);
				ps.setString(2, "test03"+i);
				ps.addBatch();
			}
			int[] d1=ps.executeBatch();
			conn.commit();
			for(int i=0;i<d1.length;i++) {
				System.out.print(d1[i]+" ");
			}
			System.out.println();
			
			System.out.println("执行完毕");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	private void connect() {
		try {
			Socket socket=new Socket("172.88.7.201",8088);
			System.out.println("连接成功");
			
		} catch (Exception e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
	}
}
