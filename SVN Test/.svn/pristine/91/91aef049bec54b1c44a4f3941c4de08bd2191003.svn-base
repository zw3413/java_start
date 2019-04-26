package day08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述IO操作
 * 编写程序，要求下面的类实现功能:
 * 添加新员工
 * 要求用户输入一个员工信息，格式如下:
 * jackson,25,男,5000,2008-12-22
 * 用户输入后需要做下述验证:
 * 要求用户名长度在1-20个字符之间且必须是英文
 * 年龄在0-100之间的整数
 * 性别只能是:"男"或"女"
 * 当发现用户输入有不符合规定时，提醒用户
 * 相关内容输入不符合要求，并要求重新输入。
 * 都输入正确后，将该员工添加到emp.txt文件
 * 的最后一行。
 * 
 * @author Xiloer
 *
 */
public class Test06 {
	public static void main(String[] args) {
		try{
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("请输入员工信息:");
			String info = scanner.nextLine();
			String[] infos = info.split(",");
			if(!checkName(infos[0])){
				System.out.println("名字只能是1-20位的英文");
				continue;
			}
			if(!checkGender(infos[2])){
				System.out.println("性别只能是:<男/女>");
				continue;
			}
			String name = infos[0];
			int age = Integer.parseInt(infos[1]);
			String gender = infos[2];
			int salary = Integer.parseInt(infos[3]);
			Date hiredate = parseDate(infos[4]);
			Emp e = new Emp(name, age, gender, salary, hiredate);
			saveEmp(e);
			System.out.println("保存完毕!");
			break;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void saveEmp(Emp e)throws IOException, URISyntaxException{
		PrintWriter pw = null;
		try{
			File file = new File("src/main/java/day08/emp.txt");
			System.out.println(file.getAbsolutePath());
			pw = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream(file,true)	
				)	
			);
			pw.println(e);
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
	}
	
	public static Date parseDate(String line) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(line);
	}
	
	public static boolean checkGender(String gender){
		String genderRegex = "[男女]";
		return gender.matches(genderRegex);
	
	}
	
	public static boolean checkName(String name){
		String nameRegex = "[a-zA-Z]{1,20}";
		return name.matches(nameRegex);
	}
}
