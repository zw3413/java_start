package day05;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author Xiloer
 *
 */
public class Test03 {

	public static void main(String[] args) throws ParseException {
		Scanner scan=new Scanner(System.in);
		/*
				zs,25,male,2000,2000-01-01;lisi,23,female,2001,2005-03-01;ww,25,male,2199,2001-08-01
		*/
		System.out.println("要求用户输入若干员工信息，格式为：* name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....");
 		String input=scan.nextLine().trim();
 		String[] inputEmps=input.split(";");
 		
 		List<Emp> cEmp = new ArrayList<Emp>();
 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 		String[] sEmp=new String[5];
 		for(int i=0;i<inputEmps.length;i++){
 			sEmp=inputEmps[i].split(",");
	 		Emp e=new Emp();
	 		e.setName(sEmp[0]);
	 		e.setAge(Integer.parseInt(sEmp[1]));
	 		e.setGender(sEmp[2]);
	 		e.setSalary(Integer.parseInt(sEmp[3]));
	 		e.setHiredate(sdf.parse(sEmp[4]));
	 		cEmp.add(e);
 		}
 		Collections.sort(cEmp);
 		
 		for(Emp e1:cEmp){
			System.out.println(e1);
		}
 		
 		Collections.sort(cEmp,new Comparator<Emp>(){
			public int compare(Emp o1, Emp o2) {
				Date d1=o1.getHiredate();
				Date d2=o2.getHiredate();
				if(d1.before(d2)){
					return -1;
				}
				return 0;
			}
 		});
 		for(Emp e1:cEmp){
			System.out.println(e1);
		}
}
}