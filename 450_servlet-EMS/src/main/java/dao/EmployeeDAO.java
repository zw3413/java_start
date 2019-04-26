package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {
		Connection conn;
		/*
		 * 查找所有员工
		 * ResultSet rs
		 * while
		 */
	public List<Employee> listAll(){
		List<Employee> list=new ArrayList<Employee>();
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT * FROM t_emp_zhangwei";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setAge(rs.getInt(4));
				list.add(e);
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
		return list;
	}
		
	public boolean save( Employee e) {
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO t_emp_zhangwei"
					+ "(id,ename,salary,age)"
					+ "		VALUES("
					+ "s_emp_zhangwei.NEXTVAL,?,?,?)";
				
			PreparedStatement state=conn.prepareStatement(sql,new String[] {"id"});
			state.setString(1,e.getEname());
			state.setDouble(2,e.getSalary());
			state.setInt(3,e.getAge());
			int flag=-1;
			flag=state.executeUpdate();
			if(flag>0) {
				ResultSet rs=state.getGeneratedKeys();
				rs.next();
				int id=rs.getInt(1);
				e.setId(id);
				return true;
			}
		}catch(SQLException e1) {
			/*
			 * 异常处理规则：
			 * step1:记日志(保留现场)
			 */
				e1.printStackTrace();
				
			 /* 
			  * step2:查看异常是否能够立即恢复。
			 * 如果不能够恢复（比如数据库服务停止，网络终端等，这样的异常我们可以称之为系统异常），提示用户稍后重试。
			 * 如果能够恢复，则立即恢复
			 */
			throw new RuntimeException(e1);
		}finally {
			try {
				DBUtil.closeConnection(conn);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteById(String id) throws SQLException {
		try {
			Connection conn=DBUtil.getConnection();
			String sql="DELETE FROM t_emp_zhangwei WHERE id= ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			return ps.execute();
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

	public Employee findById(int id) {
		Connection conn=null;
		Employee e=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT * FROM t_emp_zhangwei WHERE id =?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				e=new Employee();
				e.setId(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setAge(rs.getInt(4));
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return e;
	}

		public boolean update(Employee e) {
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="UPDATE t_emp_zhangwei SET ename=?, salary=?, age=? WHERE id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, e.getEname());
				ps.setDouble(2, e.getSalary());
				ps.setInt(3, e.getAge());
				ps.setInt(4, e.getId());
				int d=ps.executeUpdate();
				if(d>0) {
					//更新成功
					return true;
				}else {
					//更新失败
					return false;
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}finally {
				try {
					DBUtil.closeConnection(conn);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}

}
