package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个List集合并添加元素0-9
 * 然后获取子集[3,4,5,6]
 * 然后将子集元素扩大10倍
 * 然后输出原集合。
 * 之后删除集合中的[7,8,9]
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println("list:"+list);
		//获取子集
		List<Integer> subList = list.subList(3, 7);
		for(int i=0;i<subList.size();i++){
			subList.set(i, subList.get(i)*10);
		}
		System.out.println("list:"+list);
		//删除7-9
		list.subList(7, 10).clear();
		System.out.println("list:"+list);
	}
}
