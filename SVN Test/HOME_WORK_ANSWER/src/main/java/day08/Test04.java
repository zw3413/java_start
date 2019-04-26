package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述读取操作
 * 读取emp.txt文件，并将每个员工信息读取出来，以一个Emp实例保存，然后将
 * 这些Emp实例存入到一个Map集合中。其中key为字符串，是该员工名字，而value
 * 是该Emp实例。
 * 存入后，要求用户输入一个员工的名字,如:张三
 * 若该员工存在则输出该员工所有信息(Emp的toString方法返回的字符串)
 * 输入的员工名若是英文，不要求区分大小写。
 * 若输入的员工名字不存在，则显示"查无此人"
 * 
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			Map<String,Emp> map = new HashMap<String,Emp>();
			br = new BufferedReader(
				new InputStreamReader(
					Test04.class.getClassLoader().getResourceAsStream("day08/emp.txt")
				)	
			);
			String line = null;
			//读取文件每一行并解析为一个Emp对象存入Map集合
			while((line = br.readLine())!=null){
				Emp emp = parseEmp(line);
				map.put(emp.getName().toLowerCase(), emp);
			}
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入员工姓名:");
			String name = scanner.nextLine().toLowerCase();
			if(map.containsKey(name)){
				Emp e = map.get(name);
				System.out.println(e);
			}else{
				System.out.println("查无此人");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 将一行字符串解析为一个Emp对象
	 * @param info
	 * @return
	 * @throws ParseException 
	 */
	public static Emp parseEmp(String info) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] infos = info.split(",");
		String name = infos[0];
		int age = Integer.parseInt(infos[1]);
		String gender = infos[2];
		int salary = Integer.parseInt(infos[3]);
		Date hiredate = sdf.parse(infos[4]);
		Emp emp = new Emp(name, age, gender, salary, hiredate);
		return emp;
	}
}
