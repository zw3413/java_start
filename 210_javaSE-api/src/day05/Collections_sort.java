package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 可以通过集合的工具类 java.util.Collections的静态方法sort()进行
 * 需要注意的是，只能对List排序，因为它有序。	
 * @author soft01
 *
 */
public class Collections_sort {

	public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<10;i++){
	list.add(new Random().nextInt(100));
	}
	System.out.println(list);	
	Collections.sort(list);
	System.out.println(list);	
		
	}
	public Collections_sort() {
		
	}
	@Override
	public boolean equals(Object obj) {
	
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}