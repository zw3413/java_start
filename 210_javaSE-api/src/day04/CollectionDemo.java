package day04;
/**
 * 
 * 集合只存放引用类型的元素
 * 并且集合存放的是元素的引用（地址）
 * 
 * @author soft01
 *
 */
import day02.Point;
import java.util.Collection;
import java.util.ArrayList;
public class CollectionDemo {

	public static void main(String[] args) {
		
		Collection c=new ArrayList();
		Point p=new Point(1,2);
		c.add(p);
		c.add(p);
		System.out.println(p);
		System.out.println(c);
		
		p.setX(2);
		System.out.println(p);
		System.out.println(c);
		
		
		
		
		
		
		
	}

}
