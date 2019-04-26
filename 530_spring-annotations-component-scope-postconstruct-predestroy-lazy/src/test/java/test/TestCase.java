package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotations.Apple;
import annotations.Leader;
import annotations.Manager;
import annotations.Restaurant;
import annotations.Student;

public class TestCase {
	@Test
	//测试 组件扫描
	public void test1() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Apple a1=ac.getBean("a1",Apple.class);
		System.out.println("a1:"+a1);
	}
	@Test
	//测试 作用域
	public void test2() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Apple a1=ac.getBean("a1",Apple.class);
		Apple a2=ac.getBean("a1",Apple.class);
		System.out.println("a1==a2:"+(a1==a2));
	}
	
	@Test
	//测试 组建生命周期
	public void test3() {
		String config="annotations.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
		Apple a1=ac.getBean("a1",Apple.class);
		System.out.println("a1:"+a1);
		ac.close();
	}
	@Test
	//测试 延迟加载
	public void test4() {
		String config="annotations.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
	}
	@Test
	//测试 构造器注入 @Autowired 和 @Qualifier
	public void test5() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Restaurant rest=ac.getBean("rest",Restaurant.class	);
		Manager mg=ac.getBean("mg",Manager.class);
		System.out.println("rest:"+rest);
		System.out.println("mg:"+mg);
	}
	@Test 
	//测试 @Resource
	public void test6() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Leader ld=ac.getBean("ld",Leader.class);
		System.out.println("ld:"+ld);
	}
	@Test
	//测试 @Value
	public void test7() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Student stu=ac.getBean("stu",Student.class);
		System.out.println("stu:"+stu);
	}
}