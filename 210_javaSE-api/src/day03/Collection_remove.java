package day03;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

public class Collection_remove {

	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(1,2));
		System.out.println(c);
		Point p=new Point(1,2);
		
		c.remove(p);
		System.out.println(c);

	}

}
