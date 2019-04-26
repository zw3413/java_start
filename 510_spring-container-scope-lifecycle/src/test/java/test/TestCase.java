package test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.MessageBean;
import basic.ScopeBean;
import exercise.ExampleBean;

public class TestCase {
		@Test
		//测试作用域 scope = singleton/prototype
		public void test1() {
			String config="basic.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			ScopeBean sb1=ac.getBean("sb1",ScopeBean.class);
			ScopeBean sb2=ac.getBean("sb1",ScopeBean.class);
			System.out.println(sb1==sb2);
		}
		@Test
		//测试 初始化和销毁方法 
		public void test2() {
			String config="basic.xml";
			/*
			 * ApplicationContext接口没有提供close方法（关闭容器的方法）
			 */
			ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(config);
			MessageBean mb1=ac.getBean("mb1",MessageBean.class);
			mb1.send();
			//关闭容器
			ac.close();
		}
		
		@Test
		public void test3() {
			String config="basic.xml";
			ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(config);
		}
		
		@Test
		public void testExample() {
			String config="example.xml";
			ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(config);
			ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
			ac.close();
		}
}
