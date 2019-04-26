package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Employee;

public class TestCase {
	private EmpDAO dao;
	
	@Before
	public void init() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		dao=ac.getBean("empDAO",EmpDAO.class);
	}
	
	@Test
	public void test1() {
		Employee e=new Employee();
		e.setAge(22);
		e.setEname("Giving King");
		e.setSalary(20000);
		dao.save(e);
	}
	@Test
	public void test2() {
		List<Employee> list=dao.findAll();
		for(Employee e:list) {
			System.out.println(e);
		}
	}
}
