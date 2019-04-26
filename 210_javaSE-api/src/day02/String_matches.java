package day02;

import java.util.Scanner;

/**
 * 字符串支持正则表达式的相关方法之一：
 * boolean matches(String regex)
 * 使用给定的正则表达式匹配当前字符串的格式是否满足该正则表达式要求，
 * 满足则返回true.
 * 
 * @author soft01
 *
 */

public class String_matches {

	public static void main(String[] args) {
		
		/**
		 * email 正则表达式
		 * /w+@[/w&&^_]+(\.[/w&&^_]+
		 */
		Scanner scan=new Scanner(System.in);
		String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		String regex1="\\w+@\\w+(\\.[a-zA-Z]+)+";
		System.out.println(regex1);
		System.out.println("请输入邮箱：");
		String email;
		email=scan.next();
		
		boolean tf=email.matches(regex1);
		if(tf){
			System.out.println("是邮箱地址");
		}else{
			System.out.println("邮箱格式不正确");
		}
	}

}
