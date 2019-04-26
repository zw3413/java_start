package day06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 * @author Xiloer
 *
 */
public class Test12 {
	public static void main(String[] args) {
		/*
		 * read all the files,and save info in files into the map <String name, Emp emp>.
		 */
		File file=new File(".");
		File[] subs=file.listFiles(new FileFilter(){
			public boolean accept(File pathname){
				return pathname.getName().endsWith(".emp");
			}
		});
	
		BufferedReader br=null;
		String[] str;
		Emp emp=null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String,Emp> map=new HashMap<String,Emp>();
		
		for(File sub:subs){
			try{
			br=new BufferedReader(new InputStreamReader(new FileInputStream(sub),"utf-8"));
			str=br.readLine().split(",");
			System.out.println("----Readed information as below:----");
			for(int i=0;i<str.length;i++){
				String[] sp=null;
				sp=str[i].split("：");
				str[i]=sp[1].trim();
				System.out.println(str[i]);
			}
			str[4]=str[4].substring(0,str[4].length()-1);
			
			emp=new Emp(str[0],Integer.parseInt(str[1]),str[2],Integer.parseInt(str[3]),sdf.parse(str[4]));
			map.put(emp.getName(),emp);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		try{
			if(br!=null)
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Reading completed. found "+map.size()+" objects .");
		System.out.println("-------------------------------------");
	
		/*
		 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
		 * 即:输入名字"张三"
		 * 若该员工存在，则输出如下格式:
		 * 张三,25,5000,2006-02-14
		 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
		 * 若该员工不存在，则输出:"查无此人"
		 */
		System.out.println("Input a name to query the 20 years please:");
		Scanner scan=new Scanner(System.in);
		String name=scan.nextLine();
		Set<Entry<String,Emp>> set=map.entrySet();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		
		for(Entry<String,Emp> entry:set){
			if(name.equals(entry.getKey())){
				calendar.setTime(entry.getValue().getHiredate());
				calendar.add(Calendar.YEAR, 20);
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				System.out.println(entry.getValue().getName()+","+entry.getValue().getAge()+","+entry.getValue().getSalary()+","+sdf1.format(calendar.getTime()));
				return;
			}
		}
		System.out.println("Didn't find this people.");
	}
}
