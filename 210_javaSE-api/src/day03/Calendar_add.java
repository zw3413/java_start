package day03;

import java.util.Calendar;

/**
 * 
 * void add()
 * 查看3年零2个月的前25天以后那周的周五是哪天
 * 
 * 
 * @author soft01
 *
 */
public class Calendar_add {

	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, -25);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		System.out.println(calendar.getTime());
	}

}
