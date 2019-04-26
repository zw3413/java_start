package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类
 * 日历类用于操作时间
 * 常见实现类GregorianCalendar 即 阳历
 * 
 * Calendar 提供了静态方法：getInstance用于获取一个当前系统所在地区适用的实现类，大部分地区返回的都是阳历历法实现类
 * 
 * 
 * void setTime()
 * 使用给定的Date来设置当前Calendar表示的日期。
 * @author soft01
 *
 */

public class Calendar_getInstance {

	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar);
		Date date=calendar.getTime();
		System.out.println(date);

	}
}
