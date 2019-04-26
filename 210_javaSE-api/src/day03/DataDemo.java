package day03;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个时间点。
 * 由于Date存在设计缺陷，所以大部分操作时间的方法都被声明为过时的，不再建议使用。
 * Date的每一个实例内部维护着一个long值，该值表示的是自1970年1月1日00：00：00到该实例表示的日期之间所经过的毫秒
 * 
 * 
 * @author soft01
 *
 */
public class DataDemo {

	public static void main(String[] args) {
		
		
		/*
		 * 默认创建的Date表示当前的系统时间
		 * 
		 */
		
		Date date=new Date();
		System.out.println(date);
		//int year;
		//year=date.getYear();
		//System.out.println(year);
		//long time=date.getTime();
		//time=time/1000/60/60/24/365;
		//System.out.println(time);
		//long age=80*365;
		//System.out.println(age);

		long time=1000*60*60*24;
		date.setTime(time);
		System.out.println(date);
	}

}
