package day04;

import java.util.HashSet;
import java.util.Set;

/**
 * 创建一个集合c1，存放元素"one","two","three"
 * 再创建一个集合c2，存放元素"four","five","six"
 * 然后将c2元素全部存入c1集合
 * 然后在创建集合c3,存放元素"one,five"
 * 然后输出集合c1是否包含集合c3的所有元素
 * 然后将c1集合中的"two"删除后再输出c1集合
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Set<String> c1=new HashSet<String>();
		c1.add("one");
		c1.add("two");
		c1.add("three");
		
		Set<String> c2=new HashSet<String>();
		c2.add("four");
		c2.add("five");
		c2.add("six");
		
		c1.addAll(c2);
		
		Set<String> c3=new HashSet<String>();
		c3.add("one");
		c3.add("five");
		
		System.out.println("集合c1是否包含集合c3的所有元素"+c1.contains(c3));
		c1.remove("two");
		System.out.println("c1:"+c1);
		
		
	}
	
	
	
}




