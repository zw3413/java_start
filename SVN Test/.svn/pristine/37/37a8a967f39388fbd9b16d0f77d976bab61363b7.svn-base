package day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后输出每个员工的转正仪式日期。
 * 转正仪式日期为:入职3个月的当周周五
 * 
 * @author Xiloer
 *
 */
public class Test09 {
	public static void main(String[] args) throws ParseException {
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
		//输出员工信息
		for(Emp e : list){
			System.out.println(e);
		}
		//输出转正仪式日期
		for(Emp e : list){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(e.getHiredate());
			//入职3个月后的日期
			calendar.add(Calendar.MONTH, 3);
			//设置为当周的周五
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			System.out.println(e.getName()+"的转正仪式日期:"+sdf.format(calendar.getTime()));
		}
	}
}





