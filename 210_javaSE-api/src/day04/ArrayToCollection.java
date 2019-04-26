package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToCollection {

	public static void main(String[] args) {
	
		String[] array={"one","two","three","four","five"};
		List<String> list=Arrays.asList(array);
		System.out.println("list.size()="+list.size());
		System.out.println(list);
		//对该集合的操作就是对原数组的操作
		list.set(0, "1");
		System.out.println(list);
		for(String str:array){
			System.out.println(str);
		}

		/*
		 * 数组转换的集合是不能添加元素的！
		 */
		//list.add("six");
		
		List<String> list1=new ArrayList<String>(list);
		list1.add("six");
		System.out.println("list1:"+list1);
		
	}

}
