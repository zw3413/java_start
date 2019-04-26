package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner scan=new Scanner(System.in);
		System.out.println("输入类名:");
		String clsName=scan.nextLine();
		//动态加载类
		Class cls=Class.forName(clsName);
		//动态创建对象Instance实例(对象)
		//cls对应类必须有无参构造器，newInstance()自动调用无参构造器创建对象，如果没有无参构造器，则抛出异常。
		Object obj=cls.newInstance();
		//动态查找全部的方法
		Method[] methods=cls.getDeclaredMethods();
		//String regex="{test}1{\\.}?";
		for(Method method:methods) {
			String name=method.getName();
			if(name.startsWith("test")) {
				//动态调用一个方法：
				try {
					//Access 访问（读写，调用）
					//Accessible可访问
					method.setAccessible(true);
					System.out.println(method);
				method.invoke(obj);
				}catch(IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
