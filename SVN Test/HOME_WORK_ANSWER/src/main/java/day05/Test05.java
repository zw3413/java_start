package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 有下列字符串:
 * 销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice
 * 分析上述字符串然后统计每个职位总共多少人?
 * 使用Map保存统计的结果，其中key:职位,value为该职位人数
 * 然后分别输出各职位的名称(keySet),各职位人数(entrySet)
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) {
		/*
		 * 按照";"拆分字符串得到每一个员工信息
		 * 再按照:拆分出每个员工的职位与姓名
		 * 然后用员工职位作为key存入Map，若该职位作为key已经存在，则对value+1
		 * 否则放入Map时value从1开始
		 */
		String str = "销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice";
		String[] emps = str.split(";");
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String emp : emps){
			String []info = emp.split(":");
			if(map.containsKey(info[0])){
				//该职位已经统计过
				map.put(info[0], map.get(info[0])+1);
			}else{
				map.put(info[0], 1);
			}
		}
		
		//遍历所有职位
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("job:"+key);
		}
		
		//遍历人数
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			System.out.println(e.getKey()+":"+e.getValue());
		}
	}
}
