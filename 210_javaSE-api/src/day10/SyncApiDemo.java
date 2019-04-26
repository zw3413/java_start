package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 使用集合工具类java.util.Collections的相关静态方法可以将现有的集合或Map转换为线程安全的
 * @author soft01
 *
 */
public class SyncApiDemo {
	public static void main(String[] args) {
		/*
		 * ArrayList和LinkedList都不是线程安全的
		 */
		List<String> list=new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		list=Collections.synchronizedList(list);
		System.out.println(list);
		/*
		 * HashSet不是线程安全的
		 */
		Set<String> set=new HashSet<String>(list);
		System.out.println(set);
		set=Collections.synchronizedSet(set);
		System.out.println(set);
		/*
		 * HashMap不是线程安全的
		 */
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("语文",98);
		map.put("数学",99);
		map.put("英语",89);
		map.put(null, 88);
		map.put(null, 22);
		System.out.println(map);
		int i=map.get(null);
		System.out.println(i);
/*		map=Collections.synchronizedMap(map);
		System.out.println(map);
		/*
		 * 哪怕是线程安全的集合也不与迭代器遍历该集合互斥，所以在开发的时候要自行维护互斥关系
		 * 通过
		 * List Collections.synchronizedList(List L)
		 * Set Collections.synchronizedSet(HashSet s)
		 * Map Collections.synchronizedMap(Map m)
		 * 可以将非线程安全的List和Set和Map转换为线程安全的，但是Iterator依然独立线程，他们同时操作会产生异常，需要避免。
		 */
	}
}
