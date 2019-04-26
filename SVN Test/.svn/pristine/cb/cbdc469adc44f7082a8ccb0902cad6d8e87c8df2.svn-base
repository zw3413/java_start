package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个生产日期:");
		String dateStr = scanner.nextLine();

		System.out.println("请输入一个保质期天数:");
		int days = Integer.parseInt(scanner.nextLine());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//将生产日期转换为Date
		Date date = sdf.parse(dateStr);
		
		//创建Calendar计算时间
		Calendar calendar = Calendar.getInstance();
		//表示生产日期
		calendar.setTime(date);
		//计算过期日
		calendar.add(Calendar.DAY_OF_YEAR, days);
		//计算过日期两周前
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		//设置为当周周三
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//转换为Date
		date = calendar.getTime();
		//输出促销日期
		System.out.println("促销日期:"+sdf.format(date));
		
	}
}





