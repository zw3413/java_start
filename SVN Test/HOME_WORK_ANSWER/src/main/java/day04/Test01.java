package day04;

import java.util.ArrayList;
import java.util.Collection;

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
		Collection<String> c1 = new ArrayList<String>();
		c1.add("one");
		c1.add("two");
		c1.add("three");
		System.out.println("c1:"+c1);
		Collection<String> c2 = new ArrayList<String>();
		c2.add("four");
		c2.add("five");
		c2.add("six");
		System.out.println("c2:"+c2);
		//c2元素存入c1
		c1.addAll(c2);
		System.out.println("已将c2元素全部存入c1");
		System.out.println("c1:"+c1);
		
		Collection<String> c3 = new ArrayList<String>();
		c3.add("one");
		c3.add("five");
		System.out.println("c1是否包含c3所有元素:"+c1.containsAll(c3));
		
		//删除c1中的two
		c1.remove("two");
		System.out.println("删除了c1集合中的元素two");
		System.out.println(c1);
	}
}




