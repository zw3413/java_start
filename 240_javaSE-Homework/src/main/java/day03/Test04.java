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
		String format="yyyy-MM-dd";
		System.out.println("输入生产日期："+ format);
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine().trim();
		System.out.println("输入的生产日期为"+ str);
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Date productionDate=sdf.parse(str);
		
		System.out.println("输入保质期天数：");
		int expireDays=scan.nextInt();
		System.out.println("输入的保质期天数为："+expireDays);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(productionDate);
		calendar.add(Calendar.DAY_OF_YEAR, expireDays);
		System.out.println("过期时间为"+ calendar.getTime());
		
		calendar.add(Calendar.WEEK_OF_YEAR, -2);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String saleDateStr= sdf.format(calendar.getTime());
		Date saleDate=sdf.parse(saleDateStr);
		
		
		if(saleDate.before(productionDate)){
			System.out.println("保质期太短，请重新设置保质期：");
			return;
		}
		
		System.out.println("促销日期为："+sdf.format(saleDate));
		scan.close();
		
	}
	
	
	
}
