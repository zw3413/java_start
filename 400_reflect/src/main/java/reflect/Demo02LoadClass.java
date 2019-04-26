package reflect;

import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Scanner;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;

public class Demo02LoadClass {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner scan=new Scanner(System.in);
		System.out.println("输入要加载的类名：");
		String className=scan.nextLine();
		Class cls=Class.forName(className);
		System.out.println(cls+"类加载成功。");
		/*
		Enumeration<Driver> enm=DriverManager.getDrivers();
		
		System.out.println("当前系统可用的 JDBC 驱动有：");
		if(enm.hasMoreElements()) {
			System.out.println(enm.nextElement());
		}
		*/
		//动态获取一个类的属性信息
		Constructor[] constructors=cls.getDeclaredConstructors();
		System.out.println("此类中包含的构造器：");
		for(Constructor constructor:constructors) {
			System.out.println(constructor);
		}
		Field[] fields=cls.getDeclaredFields();
		System.out.println("此类中包含的属性：");
		for(Field field:fields) {
			System.out.println(field);
		}
		Method[] methods=cls.getDeclaredMethods();
		System.out.println("此类中包含的方法：");
		for(Method method:methods) {
			System.out.println(method);
		}
	
	}

}
