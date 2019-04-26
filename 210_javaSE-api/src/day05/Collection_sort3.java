package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * 
 * @author soft01
 *
 */
public class Collection_sort3 {
	public static void main(String[] args) {
		
		List<Point> list=new ArrayList<Point>();
		list.add(new Point(5,6));
		list.add(new Point(3,2));
		list.add(new Point(1,7));
		list.add(new Point(8,2));
		list.add(new Point(9,4));
		System.out.println(list);
		
		/*
		 * sort方法要求集合元素必须实现
		 * comparable接口。否则无法对该集合排序。
		 */
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list,new Comparator<Point>(){
			@Override
			public int compare(Point o1, Point o2) {
				int od1=o1.getX()*o1.getX()+o1.getY()*o1.getY();
				int od2=o2.getX()*o2.getX()+o2.getY()*o2.getY();
				return od1-od2;
			}
		});
		System.out.println(list);
		
		
		
	}
	
	
	
}
