package day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 * 每页显示5条，显示emp表中第二页的员工信息
 * 要求员工信息按照工资的降序排列后查看第二页信息
 * @author soft01
 */
public class JDBCDemo6 {
	public static void main(String[] args) {
		try {
		/*	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@172.88.0.20:1521:tarena",
					"jsd1707",
					"tarena");*/
			Connection conn= DBUtil.getConnection();
			System.out.println("connected.");
			Statement state=conn.createStatement();
			int page=2;
			int pagesize=5;
			
			int start=(page-1)*pagesize+1 ;
			int end=page*pagesize;
			String sql=  "	SELECT rn,empno,ename,job,mgr,hiredate,sal,comm,deptno "
						+ " FROM( "
						+ "	  	SELECT rownum rn, empno,ename,job,mgr,hiredate,sal,comm,deptno "
						+ "		FROM( "
						+ "			SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno "
						+ "			FROM emp_zhangw "
						+ "			ORDER BY sal DESC) "
						+ "		WHERE rownum<= "+ end+ ")"
						+ " WHERE rn>="+start ;
		
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				int rn=rs.getInt("rn");
				int empno=rs.getInt("empno");
				String 	ename=rs.getString("ename");
				String job=rs.getString("job");
				int mgr=rs.getInt("mgr");
				Date hiredate=rs.getDate("hiredate");
				int sal=rs.getInt("sal");
				int comm=rs.getInt("comm");
				int deptno=rs.getInt("deptno");
				System.out.println(rn+","+empno+","+ename+","+
				job+","+mgr+","+hiredate+","+sal+","+comm+","+deptno);
			}
			/*conn.close();8
			 */
			DBUtil.closeConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
