package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 * @author Xiloer
 *
 *张三,25,男,5000,2006-3-18
 *李四,85,男,5010,2016-3-19
 *王五,27,女,5100,2007-5-18
 *
 */
public class Test03 {
	public static void main(String[] args) {
		
		String str=null;
		Scanner scan=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<Emp> list=new ArrayList<Emp>();
		System.out.println("Enter the number of how many persons you would like to input:");
		int number=0;
		try{
			number=scan.nextInt();
		}catch(InputMismatchException e){
			System.out.println("输入不合法，程序出现异常，请重新启动程序。");
		}
		scan.nextLine();
			for(int i=0;i<number;i++){
				System.out.println("please input the No."+(i+1)+" person.");
				str=scan.nextLine().trim();
				System.out.println(str);
				String[] info=str.split(",");
				Emp emp=null;
				try {
					emp = new Emp(info[0],Integer.parseInt(info[1]),info[2],Integer.parseInt(info[3]),sdf.parse(info[4]));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list.add(emp);
			}
			System.out.println(number+" persones have been input. Thanks.");	
			System.out.println(list);
		/*
		 * pending..
		 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
		 */

		String fileName=null;
		ObjectOutputStream oos=null;
		for(Emp e:list){
			fileName=e.getName()+".obj";			
			try {
				oos=new ObjectOutputStream(new FileOutputStream(fileName));
				oos.writeObject(e);
				System.out.println("Write Object:"+fileName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
		}
		try {
			if(oos!=null)
				oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	}}
