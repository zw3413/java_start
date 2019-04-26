package test;

import entity.User;
import org.junit.Test;

import dao.UserDAO;

public class TestCase {
	@Test
	public void test1() {
		UserDAO dao=new UserDAO();
		entity.User user=dao.findByUsername("zw3413");
		System.out.println(user);
	}
	@Test
	public void test2() {
		UserDAO dao=new UserDAO();
		User user=new User();
		user.setUsername("张三");
		user.setPassword("123");
		user.setName("三三");
		user.setGender("男");
		dao.save(user);
	}
}
