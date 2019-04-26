package day03;
/**
 * 将当前系统时间以"yyyy-MM-dd HH:mm:ss"格式输出
 * @author Xiloer
 *
 */
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Test02 {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr=sdf.format(date);
		System.out.println(dateStr);		
	}
	
	
}
