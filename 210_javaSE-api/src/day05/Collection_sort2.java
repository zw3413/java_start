package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对字符串的排序
 * @author soft01
 *
 */
public class Collection_sort2 {

	public static void main(String[] args) {
		/*
		 * 
		 * 字符串排序是按照字符的编码顺序排序的
		 */
		List<String> list=new ArrayList<String>();
		list.add("jack");
		list.add("rose");
		list.add("tom");
		list.add("jerry");
		list.add("mike");
		list.add("Jill");
		list.add("Marry");
		list.add("lady gaga");

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		list.clear();
		list.add("范老师");
		list.add("苍老师");
		list.add("小泽老师");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(3+4+"tedu"+3+4);
		
		int a=0,y=0;
		int i=a,j=y;
	}

}
