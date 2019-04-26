package day02;

import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
 * @author Xiloer
 *
 */
public class Test08 {
	public static void main(String[] args) {
		System.out.println("请输入员工信息:");
		Scanner scanner = new Scanner(System.in);
		String info = scanner.nextLine();
		//首先根据";"拆分出每个员工信息
		String[] infoArr = info.split(";");
		//根据拆分出的员工信息个数创建对应长度的数组
		Person[] personArr = new Person[infoArr.length];
		/*
		 * 遍历员工信息的数组，将每个员工信息解析为一个Person对象
		 * 并存入到personArr数组中
		 */
		for(int i=0;i<personArr.length;i++){
			String personInfo = infoArr[i];
			//按照","拆分一个员工的各项信息
			String data[] = personInfo.split(",");
			String name = data[0];
			int age = Integer.parseInt(data[1]);
			String gender = data[2];
			int salary = Integer.parseInt(data[3]);
			Person p = new Person(name, age, gender, salary);
			personArr[i]=p;
		}
		System.out.println("解析完毕");
		for(int i=0;i<personArr.length;i++){
			System.out.println(personArr[i]);
		}
		
	}
}
