package day03;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 * @author Xiloer
 *
 */
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
public class Test03 {
	public static void main(String[] args) throws ParseException {
		System.out.println("输入某人生日，格式为\"yyyy-MM-dd\"");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine().trim();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay=sdf.parse(str);
		Calendar calendar=Calendar.getInstance();
		long past=calendar.getTimeInMillis()-birthDay.getTime();
		long pastWeeks=past/1000/60/60/24/7;
		System.out.println("到现在为止经历了多少周："+pastWeeks);
	}
}
