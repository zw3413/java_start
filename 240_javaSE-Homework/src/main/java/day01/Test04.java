package day01;
/**
 * 要求用户从控制台输入一个email地址，然后获取该email的用户名(@之前的内容)
 * @author Xiloer
 *
 */
import java.util.Scanner;
public class Test04 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Input a email address:");
		String str=scan.nextLine().trim();
		String regex="\\w+@\\w+(\\.\\w+)+";
		if(str.matches(regex)){
			System.out.println("the email address is valid.");
		}else{
			System.out.println("the email address is invalid");
		}
		String[] str1=str.split("@");
		String name=str1[0];
		System.out.println(name);
		
	}
}
