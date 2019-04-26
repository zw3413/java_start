package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * 集合当中的泛型应用
 * 泛型用来规定集合中的元素类型
 * 
 * @author soft01
 *
 */

public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection<String> c =new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
	//	c.add(1);
	
		Iterator<String> it=c.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
		}
		
		for(String str1:c){
			System.out.println(str1);
		}
		
		
	}
}
