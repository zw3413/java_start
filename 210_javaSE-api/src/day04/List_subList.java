package day04;

import java.util.ArrayList;
import java.util.List;

public class List_subList {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		
		List<Integer> subList=list.subList(3, 8);
		System.out.println(subList);
		
		for(int i=0;i<subList.size();i++){
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);
		/*
		 * 对子集的元素操作就是对原集合对应元素的操作
		 * 
		 * 
		 */
		System.out.println(list);
		
		list.subList(2, 9).clear();
		System.out.println(list);
		
	}
}
