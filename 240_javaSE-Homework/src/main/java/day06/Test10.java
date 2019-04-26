package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。
 * @author Xiloer
 */
public class Test10 {
	public static void main(String[] args) throws NumberFormatException, ParseException {
		Scanner scan=new Scanner(System.in); //declare the scanner
		String input="";
		PrintWriter pw=null;
		System.out.println("Input the info of EMP:"+"name,age,gender,salary,hiredate");
		while(!"exit".equals(input=scan.nextLine().trim())){
			String[] str=input.split(",");
			Emp emp=new Emp(str[0],Integer.parseInt(str[1]),str[2],Integer.parseInt(str[3]),new SimpleDateFormat("yyyy-MM-dd").parse(str[4]));
			System.out.println(emp);
			String fileName=emp.getName()+".emp";
			try{
				pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName),"utf-8"),true);
				pw.println(emp);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(pw!=null)
						pw.close();
				}catch(NullPointerException e){
					e.printStackTrace();
				}
			}
			System.out.println("Input the info of EMP:"+"name,age,gender,salary,hiredate");
		}
	}
}
