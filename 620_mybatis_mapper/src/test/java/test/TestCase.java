package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {

	private SqlSession session;
	@Before
	public void init() {
		String config="SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream(config));
		session=ssf.openSession();
	}
	@Test
	public void test1() {
		/*
		 * getMapper方法会返回符合Mapper映射器（接口)要求的对象
		 */
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Employee e=new Employee();
		e.setAge(27);
		e.setEname("苍松");
		e.setSalary(20000);
		dao.save(e);
		//仍然需要提交任务
		session.commit();
		session.close();
	}
	@Test
	public void test2() {
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		System.out.println("dao:"+dao.getClass().getName());
		List<Employee> list=dao.findAll();
		for(Employee e: list) {
			System.out.println(e);
		}
		session.close();
	}
	@Test
	public void test3() {
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Employee e=dao.findById(83);
		System.out.println(e);
		session.clearCache();
	}
	@Test
	public void test4() {
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Employee e=dao.findById(83);
		e.setAge(e.getAge()-10);
		dao.update(e);
		session.commit();
		session.close();
	}
	@Test 
	public void test5() {
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		dao.delete(36);
		session.commit();
		session.close();
	}
	
}
