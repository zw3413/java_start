package day04;


import day02.Point;
public class Demo {

	public static void main(String[] args) {
		Point p=new Point(1,2);
		System.out.println(p);
		test(p);
		System.out.println(p);
	
	}
	static void test(Point p1){
		/*
		 * p1由于与p指向同一个对象，所以将其x值可以改变为2，main方法中的p看到的也是该后的效果
		 * 
		 * 
		 */
		p1.setX(2);
		/*
		 * p1重新指向一个新创建的对象，但是并不影响main方法中的p对原来的引用
		 * 
		 */
	}

}
