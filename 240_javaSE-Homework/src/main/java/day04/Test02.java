package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import java.util.Iterator;

/**
 * 创建一个集合，存放元素"1","$","2","$","3","$","4"
 *   使用迭代器遍历集合，并在过程中删除所有的"$"，
 *   最后再将删除元素后的集合使用新循环遍历，并输出每一个元素。
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Collection<String> set=new ArrayList<String>();
		set.add("1");
		set.add("$");
		set.add("2");
		set.add("$");
		set.add("3");
		set.add("$");
		set.add("4");
	
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
			if("$"==str){
				it.remove();
			}
		}
		
		Iterator<String> it1=set.iterator();
		while(it1.hasNext()){
			String str1=it1.next();
			System.out.println(str1);
		}
	
	}
}
