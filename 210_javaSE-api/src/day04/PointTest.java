package day04;

public class PointTest {

	public static void main(String[] args) {
		
		Point<Integer> p1=new Point<Integer>(1,2);
		System.out.println(p1);
		p1.setX(2);
		System.out.println(p1);
		int x1=p1.getX();
		System.out.println("x1:"+x1);
		
		Point<Double> p2=new Point<Double>(1.0,2.0);
		System.out.println(p2);
		p2.setX(2.0);
		System.out.println(p2);
		Double x2=p2.getX();
		System.out.println("x2:"+x2);
		
		/*Point<Double> p3=new Point<Double>(1.0,1);
		System.out.println(p3);
		
		Point p4=new Point(1.0,"二");
		System.out.println(p4);
		*/
		Point<String> p3=new Point<String>("一","二");
		System.out.println(p3);
		p3.setX("二");
		System.out.println(p3);
		String x3=p3.getX();
		System.out.println("x3:"+x3);
		
		
	}

}
