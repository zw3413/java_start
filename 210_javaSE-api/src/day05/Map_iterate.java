package day05;
import java.util.Collection;
/*
 * map的遍历
 * 遍历map有三种方式：
 * 1：遍历所有的key
 * 2：遍历所有的键值对(Entry)
 * 3：遍历所有的value（相对不常用）
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
public class Map_iterate {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("语文",99);
		map.put("数学",98);
		map.put("英语",97);
		map.put("物理",96);
		map.put("化学",95);
		System.out.println(map);
		
		/*遍历所有的key
		 * Set<k> keySet()
		 * 将当前Map中所有的Key存入一个Set集合后返回。
		 * 遍历该集合等同于遍历了Map中所有的Key。
		 */
		Set<String> keySet=map.keySet();
		for(String str:keySet){
			System.out.println(str);
		}
		/*
		 * 获取每一组键值对
		 * Set<Entry> entrySet()
		 * Map将每一组键值对以一个Entry的实例返回
		 * Entry是map的内部类，提供了两个常用的方法：getKey() getValue()
		 */
		Set<Entry<String, Integer>> s=map.entrySet();
		for(Entry<String, Integer> e:s){
			String key=e.getKey();
			int value=e.getValue();
			System.out.println(key+","+value);
		}
		
		/*
		 * 遍历所有的value
		 * 
		 * collection values()
		 * 将当前Map中所有value存入一个集合后返回
		 */
		Collection<Integer> values=map.values();
		for(Integer value:values){
			System.out.println(value);
		}
		System.out.println(map);
		map.remove("数学");
		System.out.println(map);
		
	}
}
