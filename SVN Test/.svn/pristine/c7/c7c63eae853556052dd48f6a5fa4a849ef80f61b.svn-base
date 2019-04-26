package day01;

import java.util.Scanner;

/**
 * 要求用户从控制台输入一个email地址，然后获取该email的用户名(@之前的内容)
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个email地址");
		String email = scanner.nextLine();
		if(email.indexOf("@")<1){
			System.out.println("缺少@或没有用户名");
		}else{
			String username = email.substring(0, email.indexOf("@"));
			System.out.println("用户名:"+username);
		}
	}
}
