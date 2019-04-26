package day03;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * 程序启动后，要求用户输入自己的生日
 * 格式：yyyy-MM-dd
 * 然后经过程序计算，输出到今天为止，一共活了多少天
 * 
 * @author soft01
 *
 */
public class Test {

	public static void main(String[] args) throws ParseException {
		Scanner scan=new Scanner(System.in);
		String dateFormat="yyyy-MM-dd";
		System.out.println("Input your birthday with the format of "+dateFormat);
		String str=scan.nextLine().trim();
		SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
		Date d=sdf.parse(str);
		Date now=new Date();
		long age=now.getTime()-d.getTime();
		System.out.println("your age is: \n" +age+ " in million second");
		System.out.println(age/1000/60/60/24+" in day");
		System.out.println(age/1000/60/60/24/365+ " in years");
		
		long year,day,month;
		year=age/1000/60/60/24/365;
		month=age%(1000*60*60*24)/1000/60/60/24/30;
		day=age%(1000*60*60*24*30)/1000/60/60/24;
		System.out.println(year+"年"+month+"月"+day+"天");	
	}

}
