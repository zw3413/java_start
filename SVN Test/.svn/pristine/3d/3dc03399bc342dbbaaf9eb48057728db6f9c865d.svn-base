package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *创建一个Map，保存某个学生的成绩:
 *在控制台输入该学生成绩，格式:
 *科目:成绩;科目:成绩;...
 *例如:  
 *语文:99;数学:98;英语:97;物理:96;化学:95
 *然后输出物理的成绩。
 *然后将化学的成绩设置为96
 *然后删除英语这一项。
 *然后遍历该Map分别按照遍历key，Entry，value
 *的形式输出该Map信息。
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		//获取物理的成绩
		Integer num = map.get("物理");
		System.out.println("物理:"+num);
		
		//设置化学成绩
		map.put("化学",96);
		
		//删除英语
		map.remove("英语");
		
		//遍历key
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		//遍历Entry
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			System.out.println(e.getKey()+":"+e.getValue());
		}
		
		//遍历values
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
		}
	}
}
