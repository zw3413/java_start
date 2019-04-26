package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.EmployeeDAO;
import dao.UserDAO;
import entity.Employee;
import entity.User;
import util.DBUtil;

public class TestCase {
	@Test
	public void test1() {
		try {
		System.out.println(DBUtil.getConnection());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		EmployeeDAO dao=new EmployeeDAO();
		Employee e=new Employee();
		e.setEname("小月");
		e.setSalary(2000);
		e.setAge(20);
		dao.save(e);
	}
	@Test
	public void test3() {
		System.out.println("start.");
		EmployeeDAO dao=new EmployeeDAO();
		Employee e=new Employee();
		List<Employee> list=dao.listAll();
		System.out.println(list.size());
		for( Employee e1:list) {
			System.out.println(e1);
		}
	}
	
	@Test
	public void test5() {
		EmployeeDAO dao=new EmployeeDAO();
		Employee e=dao.findById(26);
		System.out.println(e);
	}
	@Test
	public void test6() {
		UserDAO dao=new UserDAO();
		User user=new User();
		user.setUsername("David");
		user.setPassword("abc123");
		user.setName("d");
		user.setGender("M");
		dao.save(user);
	}
	@Test
	public void test7() {
		UserDAO dao=new UserDAO();
		if(dao.findByUsernameAndPassword("小红", "123456")!=null) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
}

