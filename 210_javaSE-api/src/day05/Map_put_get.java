package day05;
/*
 * java.util.Map
 * Map查找表
 * 以key-value对的形式存放元素。所以看起来像是一个多行两列的表格。
 * 
 * Map要求Key不允许重复(equals比较为true).
 * 常用实现类：
 * java.util.HashMap
 * 散列表，使用散列算法实现的Map
 */
import java.util.HashMap;
import java.util.Map;
public class Map_put_get {

	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
	/*
	 * V put(K k, V v)
	 * 将给定的key-value对存入到Map中
	 * 若给定的key在Map中已经存在，由于Map要求
	 * key不允许重复，所以这时为替换value操作
	 * 返回值为这个key原来对应的value值。
	 * 若key在map中不存再，则返回值为null。
	 */
		map.put("语文", 95);
		map.put("数学", 87);
		map.put("英语", 93);
		map.put("生物", 90);
		map.put("化学", 91);
		System.out.println(map);
		
		Integer i=map.put("语文", 78);
		System.out.println(map);
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value，若给定的key在当前Map中不存再，则返回值为null
		 */
		Integer value=map.get("政治");
		System.out.println(value);
	}
}
