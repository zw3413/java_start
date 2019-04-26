package day04;
/**
 * 泛型是编译器认可
 * 泛型的实际类型是Object，在使用的时候编译器会进行检查或自动造型。
 * 当对泛型变量赋值时，编译器检查是否符合类型要求
 * 获取泛型时，编译器会补充自动造型的代码
 * @author soft01
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		Point<Integer> p1=new Point<Integer>(1,2);
		System.out.println(p1);
		p1.setX(2);
		System.out.println(p1);
		int x1=p1.getX();
		System.out.println("x1:"+x1);
		
		Point p2=p1;
		System.out.println(p2);
		p2.setX("二");
		System.out.println(p2);
	
		
		//int x2=p2.getX();
		//System.out.println("x2:"+x2);
	}
	
}
