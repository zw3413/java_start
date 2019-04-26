package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) throws ParseException {
		System.out.println("请输入生日:");
		Scanner scanner = new Scanner(System.in);
		String birthStr = scanner.nextLine();
		//将输入的字符串转换为Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = sdf.parse(birthStr);
		//当前系统时间
		Date now = new Date();
		//计算相差的时间
		long time = now.getTime()-birth.getTime();
		//换算为周
		time/=1000*60*60*24*7;
		System.out.println("经过了"+time+"周");
	}
}


