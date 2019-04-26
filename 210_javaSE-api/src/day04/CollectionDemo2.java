package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c1=new ArrayList();
		c1.add("java");
		c1.add("c");
		c1.add(".net");
		System.out.println("c1:"+c1);
		
		Collection c2=new HashSet();
		c2.add("android");
		c2.add("java");
		c2.add("ios");
		c2.add("java");

		System.out.println("c2:"+c2);
		
		c1.addAll(c2);
		System.out.println("c1.addAll(c2)"+c1);
		c2.addAll(c1);
		System.out.println("c2.addAll(c1)"+c2);
		
		Collection c3=new ArrayList();
		c3.add("c");
		c3.add("ios");
		System.out.println("c3:"+c3);
		/*
		 * boolean containsAll(Collection c)
		 * 判断当前集合是否包含给定集合中的所有元素
		 */
		boolean containsAll=c2.containsAll(c3);
		System.out.println("c2包含c3所有元素："+containsAll);
	}
}
