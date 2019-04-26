package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Student;
import ioc.A;
import ioc.Phone;
import value.Student2;
import value.Teacher;

public class TestCase {
	//测试set方法注入
	@Test
	public void test1() {
		
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		A a=ac.getBean("a1",A.class);
		a.service();
	}
	//测试构造器方法注入
	@Test
	public void test2() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Phone phone=ac.getBean("phone",Phone.class);
		System.out.println(phone.toString());
	}
	//测试按照id自动装配
	@Test
	public void test3() {
		String config="autowire.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Student stu=ac.getBean("stu",Student.class);
		System.out.println(stu.toString());
	}
	//测试注入基本类型的值
		@Test
		public void test4() {
			String config="value.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			Teacher teacher=ac.getBean("t2",Teacher.class);
			System.out.println(teacher.toString());
		}
		//读取properties文件
		@Test
		public void test5() {
			String config="value.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			Properties props=ac.getBean("config",Properties.class);
			System.out.println(props);
		}
		//测试spring表达式
		@Test
		public void test6() {
			String config="value.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			Student2 stu1=ac.getBean("stu1",Student2.class);
			System.out.println(stu1);
		}
}
