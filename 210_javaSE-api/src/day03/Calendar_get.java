package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * int get(int field)
 * 获取当前Calendar中指定时间分量所对应的值。
 * 参数为制定的时间分量，对应Calendar提供的相关常量值。
 * 
 * 
 * @author soft01
 *
 */
public class Calendar_get {

	public static void main(String[] args) {
		Calendar calendar= Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		int minute=calendar.get(Calendar.MINUTE);
		int second=calendar.get(Calendar.SECOND);
		
		System.out.println(year+"-"+month+"-"+day);
		System.out.println(hour+":"+minute+":"+second);
		
		
		int doy=calendar.get(Calendar.DAY_OF_YEAR);
		int days=calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(days-doy);
		
		
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH,8);
		calendar.set(Calendar.HOUR, 20);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date=calendar.getTime();
		System.out.println(date);
		
	}
}
