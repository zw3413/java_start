package day08;

public class Exception_threw {
	public static void main(String[] args) {
		Person p=new Person();
		/*
		 * 当调用一个含有throws声明异常抛出的方法时，
		 * 编译器要求必须有处理该异常的手段，没有则编译不通过。
		 * 处理手段有两种：
		 * 1：使用try-catch捕获并处理该异常
		 * 2：在当前方法上继续使用throws将该异常抛出。
		 */
		try {
			p.setAge(5000);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p.getAge());
	}
}
