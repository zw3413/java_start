package day04;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
/*
 * 遍历集合元素
 * 集合提供统一的便利元素的方式：迭代器模式
 * 
 * 集合提供了用于获取遍历当前集合元素的方法：
 * Iterator iterator()
 * 
 * java.util.Iterator
 * 迭代器的接口，规定了便利集合的方法，遵循的模式为：问，取，删的步骤
 * 其中删除元素不是必须操作
 * 
 * 不同的集合实现类都提供了一个可以遍历自身的迭代器实现类。
 * 我们无需记住他们的名字，当他们的Iterator看待即可
 * 
 */
public class Collection_iterator {

	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		System.out.println(c);
		//c.removeAll(c);
		
		Iterator iterator=c.iterator();
		while(iterator.hasNext()){
			String str=(String)iterator.next();
		
			if("#".equals(str)){
				/*
				 * 在使用迭代器遍历集合元素的过程中，不能通过集合的方法增删元素
				 * 否则会引发迭代器便利集合的异常
				 */
				iterator.remove();
			}else{
			System.out.println(str);
			}
		}
		
		
	}

}
