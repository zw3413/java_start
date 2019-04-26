package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 * 
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) throws ParseException {
		String regex = "\\d{15}(\\d{2}[0-9xX])?";
		Scanner scanner = new Scanner(System.in);
		//身份证号的字符串
		String id = "";
		while(true){
			System.out.println("请输入身份证号:");
			id = scanner.nextLine();
			if(!id.matches(regex)){
				System.out.println("请输入正确的身份证号.");
			}else{
				break; 
			}
		}
		//截取生日的部分
		String birthStr = id.substring(6, 14);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date birth = sdf.parse(birthStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birth);
		calendar.add(Calendar.YEAR, 20);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//将计算后的日期按格式输出
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("日期为:"+sdf1.format(calendar.getTime()));
	}
}




