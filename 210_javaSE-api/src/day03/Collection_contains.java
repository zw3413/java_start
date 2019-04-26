package day03;

import java.util.Collection;

import day02.Point;

import java.util.ArrayList;
/*
 * boolean contains(E e)
 * 判断当前集合是否包含给定元素
 */

public class Collection_contains {

	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		System.out.println(c);
		Point p=new Point(1,2);
		boolean b=false;
		b=c.contains(p);
		System.out.println(b);
		System.out.println(p);
		
	}

}
