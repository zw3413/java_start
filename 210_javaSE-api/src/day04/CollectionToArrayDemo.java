package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection中提供了将当前集合转换为一个数组的方法：toArray
 * @author soft01
 */
public class CollectionToArrayDemo {
	
	public void main(String[] args) {
	
		Collection<String> c=new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		
//		Object[] array=c.toArray();
		
		String[] array=c.toArray(new String[c.size()]);
		System.out.println(array.length);
		for(String str:c){
			System.out.println(str);
			
		}
	}
}
