package day02;

import java.util.Scanner;

/**
 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
 * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
 * 需要使用正则表达式进行判断。
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		//整数的正则表达式
		String intReg = "\\d+";
		//小数的正则表达式
		String douReg = "\\d+\\.\\d+";
		
		System.out.println("请输入一个数字:");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		//判断是否为整数
		if(line.matches(intReg)){
			int num = Integer.parseInt(line);
			System.out.println("整数:"+num+"*10="+(num*10));
		//判断是否为小数	
		}else if(line.matches(douReg)){
			double num = Double.parseDouble(line);
			System.out.println("小数:"+num+"*5="+(num*5));
		}else{
			System.out.println("不是数字");
		}
	}
}





