package day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 * 
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 * 
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) throws ParseException {
		//获取所有员工信息
		List<Emp> list = getEmp();
		//排序集合
		Collections.sort(list);
		for(Emp e : list){
			System.out.println(e);
		}

		//按照入职时间排序
		System.out.println("按照入职时间从晚到早排序:");
		Comparator<Emp> com = new Comparator<Emp>(){
			public int compare(Emp e1, Emp e2) {
				System.out.println(e1.getHiredate().getTime()-e2.getHiredate().getTime());
				long time = e2.getHiredate().getTime()-e1.getHiredate().getTime();
				return time>0?1:-1;
			}			
		};
		Collections.sort(list,com);
		for(Emp e : list){
			System.out.println(e);
		}
	}
	/**
	 * 该方法的作用是获取所有用户输入的员工信息并解析为若干Emp实例存入
	 * 一个集合，然后将该集合返回
	 * @return
	 * @throws ParseException
	 */
	public static List<Emp> getEmp() throws ParseException{
		List<Emp> list = new ArrayList<Emp>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入员工信息:");
		String info = scanner.nextLine();
		String[] empArr = info.split(";");
		for(String data:empArr){
			String[] empInfo = data.split(",");
			String name = empInfo[0];
			int age = Integer.parseInt(empInfo[1]);
			String gender = empInfo[2];
			int salary = Integer.parseInt(empInfo[3]);
			Date hiredate = sdf.parse(empInfo[4]);
			Emp e = new Emp(name, age, gender, salary, hiredate);
			list.add(e);
		}
		return list;
	}
}
