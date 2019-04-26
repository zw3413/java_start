package day02;

import java.util.Scanner;

/**
 * 输入一个IP地址，然后将4段数字分别输出
 * 
 * IP的正则表达式参考
 * ((2([0-4][0-9]|5[0-5])|[01]?[0-9]{1,2})\\.){3}(2([0-4][0-9]|5[0-5])|[01]?[0-9]{1,2})
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		System.out.println("请输入一个IP地址");
		Scanner scanner = new Scanner(System.in);
		String ip = scanner.nextLine();
		//可以验证IP地址的格式是否合法
		
		String[] arr = ip.split("\\.");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
