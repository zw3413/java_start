package day01;

/**
 * 随机生成一个5位的英文字母验证码(大小写混搭)
 * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
 * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
 * @author Xiloer
 *
 */
import java.util.Random;
import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
		String str=random(5);
		System.out.println("the random string is \""+str+"\" Please input the string:");
		
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine().trim().toUpperCase();
		
		String randString=str.toUpperCase();
		
		if(randString.equals(input)){
			System.out.println("一致");
		}else{
			System.out.println("不一致");
		}
	}
	static String random(int number){
		StringBuilder str=new StringBuilder();
		Random rand=new Random();
		for(int i=0;i<number;i++){
			if(rand.nextInt(2)==1){
				str.append((char)('a'+rand.nextInt(27)));
			}else{
				str.append((char)('A'+rand.nextInt(27)));
			}
		}
		return str.toString();
	}
	
}
