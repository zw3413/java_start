package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串按照指定的日期格式解析为Date
 * @author soft01
 *
 */

public class SimpleDateFormat_parse {

	public static void main(String[] args) throws ParseException {
		
		String str="2008-08-08 20:00:00";
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d=s.parse(str);
		System.out.println(d);

	}

}
