package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Collections提供了一个重载的sort方法。可以单独指定一个比较器（comparator),该sort方法会根据该比较器定义的比较规则来对集合排序。
 * @author soft01
 *
 */
public class Collections_sort4 {
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		list.add("范老师");
		list.add("苍老师");
		list.add("小泽老师");
		System.out.println(list);
		
		/*
		 * 按照字符的多少排序
		 * 
		 * 第二种排序方法由于传入了额外的比较器，所以不再要求元素必须实现Comparable接口，
		 * 这样减少了对代码的侵入。
		 * 所以：当需要排序自定义类型元素，或者java提供的类的比较规则不满足排序要求时，
		 * 应当使用这种排序方式
		 * 
		 */
		
		
		
		Collections.sort(list,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int olen1=o1.length();
				int olen2=o2.length();
				return olen1-olen2;
			}});
		
		System.out.println(list);
	}
}
