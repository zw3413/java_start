package day03;
/**
 * 使用Date输出当前系统时间，以及3天后这一刻的时间
 * @author Xiloer
 *
 */
import java.util.Date;
import java.util.Calendar;
public class Test01 {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("当前系统时间："+date);
	
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 3);
		date=calendar.getTime();
		System.out.println("三天后这一刻的时间："+date);
	
	}
}
