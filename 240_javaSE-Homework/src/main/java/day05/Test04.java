package day05;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
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
	public static void main(String[] args)  {
		Map<String,Integer> scores= new HashMap<String,Integer>();
		
		Scanner scan=new Scanner(System.in);
		System.out.println(" 在控制台输入该学生成绩，格式:\n 科目:成绩;科目:成绩;...");
		String inputStr=scan.nextLine().trim();
		String[] strs=inputStr.split(";");
		
		for(int i=0;i<strs.length;i++){
			String[] strss=strs[i].split(":");
			scores.put(strss[0], Integer.parseInt(strss[1]));
		}
		System.out.println(scores);
		
		Set<Entry<String,Integer>> s=scores.entrySet();
		for(Entry<String,Integer> e:s){
			if("物理".equals(e.getKey())){
				System.out.println(e.getKey()+"成绩为："+e.getValue());
			}
		}
		scores.put("化学", 96);
		System.out.println(scores);
		scores.remove("英语");
		System.out.println(scores);
		
		/**
		 * 然后遍历该Map分别按照遍历key，Entry，value
		 *的形式输出该Map信息。
		 */
		
		Set<String> s1=scores.keySet();
		for(String str:s1){
			System.out.println(str);
		}
		System.out.println("Iterator:");
		Iterator<String>it=s1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Set<Entry<String,Integer>> s2=scores.entrySet();
		for(Entry<String,Integer> e:s2){
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		Collection<Integer> c=scores.values();
		for(Integer i:c){
			System.out.println(i);
		}
	}	
}
