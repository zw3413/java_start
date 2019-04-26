package day02;
/**
 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
 * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
 * 需要使用正则表达式进行判断。
 * @author Xiloer
 *
 */
import java.util.Scanner;
public class Test01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine().trim();
	
		switch(recognize(str)){
			case 0:
				System.out.println(Integer.parseInt(str)*10);
				break;
			case 1:
				System.out.println(Double.parseDouble(str)*5);
				break;
			case -1:
				System.out.println("不是数字");
				break;
		}
	}
	public static int recognize(String str){
		String regexInt="\\d+";
		String regexDecimal="\\d+\\.\\d+";
		
		if(str.matches(regexInt)){
			return 0;
		}
		if(str.matches(regexDecimal)){
			return 1;
		}
		return -1;
	}
	
}
