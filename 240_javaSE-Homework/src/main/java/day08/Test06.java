package day08;


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
	
	final static String regexName="[a-zA-Z]{1,20}";
	final static String regexAge="[0-9]{1,3}";
	final static String regexGender="男|女";
	
	public static void main(String[] args) {
		System.out.println("jackson,25,男,5000,2008-12-22");
		System.out.println("按照以上格式输入一个员工信息：");
		Scanner scan=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Emp emp=null;
		String input="";
		PrintWriter pw=null;
		try{
			 pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("emp.txt")));
		}catch(Exception e){
			e.printStackTrace();
		}
		while(!"exit".equals(input=scan.nextLine().trim())){
			String[] str=input.split(",");
			String name=str[0].trim();
			if(!verifyName(name)){
				System.out.println("name is invalid. input again please.");
				continue;
			}
			if(!verifyAge(str[1])){
				System.out.println("age is invalid, input again please.");
				continue;
			}			
			int age=Integer.parseInt(str[1].trim());
			String gender=str[2].trim();
			if(!verifyGender(gender)){
				System.out.println("gendar is invalid, input again please.");
				continue;
			}	
			int salary=Integer.parseInt(str[3].trim());
			Date hiredate=new Date();
			try {
				hiredate = sdf.parse(str[4].trim());
			} catch (ParseException e) {
			}
			emp=new Emp(name,age,gender,salary,hiredate);
			pw.println(emp);
	//		pw.flush();
			
			System.out.println("the "+emp+" has been writed into the emp.txt successfully.");
			System.out.println("please input the next emp information:");
		}	
		pw.close();

	}
	private static boolean verifyAge(String string) {
		return string.matches(regexAge);
	}
	private static boolean verifyGender(String gender) {
		return gender.matches(regexGender);
	}
	private static boolean verifyName(String name) {
		return name.matches(regexName);
	}
}


