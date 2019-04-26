package day03;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 * 
 * 查看自己的生日是那年的第几天？
 * @author soft01
 *
 */
public class Test2 {

	public static void main(String[] args) throws ParseException {
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1988);
		calendar.set(Calendar.MONTH,07);
		calendar.set(Calendar.DAY_OF_MONTH, 07);
		Date date=calendar.getTime();
		System.out.println(date);
		int doy=calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(doy);
		String[] data={"日","一","二","三","四","五","六"};
		int dow=calendar.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println(data[dow]);
		
		
		
		Scanner scan=new Scanner(System.in);
		String format="yyyy-MM-dd";
		System.out.println(format);
		String str="1988-08-07";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Date date1=sdf.parse(str);
		System.out.println(date1);
		
		
	}

}
