package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	public static void main(String[] args) {
		String config="applicationContext.xml";
		/*
		 * ApplicationContext接口(声明了容器的一些方法)
		 * ClassPathXmlApplicationContext类（实现了上述接口的方法，会依据类路径去查找配置文件，然后启动容器）
		 */
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		/*
		 * getBean方法第一个参数是bean的id,或者是bean的name
		 * 
		 */
		Apple a1=ac.getBean("a1",Apple.class);
		System.out.println("a1"+a1);
		
		Date date1=ac.getBean("date1",Date.class);
		System.out.println("date1"+date1);
		
		Calendar cal1=ac.getBean("cal1",Calendar.class);
		System.out.println("cal1"+cal1);
		
		Date time1=ac.getBean("time1",Date.class);
		System.out.println("time1"+time1);
	}
}
