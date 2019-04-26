package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Car;
import ioc.Manager;
import ioc.Restaurant;

public class TestCase {
	@Test
	public void test1() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Restaurant r1=ac.getBean("r1",Restaurant.class);
		r1.service();
	}
	@Test
	public void test2() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager manager=ac.getBean("manager",Manager.class);
		manager.action();
	}
	@Test
	public void test3() {
		String config="autowire.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Car car=ac.getBean("car",Car.class);
		System.out.println(car);
	}
	
}
