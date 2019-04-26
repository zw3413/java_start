package day02;

import java.util.Scanner;

/**
 * 实现文件重命名。
 * 要求用户输入一个文件名称，例如:abc.jpg
 * 然后对该名字进行重新命名，输出的格式为:系统时间毫秒值.jpg
 * 例如:1465266796279.jpg
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) {
		System.out.println("请输入一个文件名");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		//方式一:按照"."拆分
//		String[] arr = fileName.split("\\.");
//		fileName = System.currentTimeMillis()+"."+arr[1];
//		System.out.println(fileName);
		
		//方式二:或者将文件名做替换
		fileName = fileName.replaceAll("\\w+\\.", System.currentTimeMillis()+".");
		System.out.println(fileName);
		
		//还有其他方式，请自行思考
	}
}
