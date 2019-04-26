package day03;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * java.text.SimpleDateFormat
 * 可以将Date与String之间按照指定的日期格式互相转换。
 * 
 * @author soft01
 */


public class SimpleDateFormat_format {

	public static void main(String[] args) {

		Date now=new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh-mm-ss E a");
		System.out.println(sdf.format(now));
		
		
	}

}
