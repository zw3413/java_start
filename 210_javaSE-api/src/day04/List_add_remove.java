package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一对重载的add,remove方法
 * 也可以通过下标操作元素
 * 
 * @author soft01
 *
 */
public class List_add_remove {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		
		list.add(2,"2");
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		
		
		
		
		
		
	}
	
	
}
