package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 电子表功能
 * 程序启动后，每秒输出当前系统时间到控制台。
 * 格式如：16：46：22
 * @author soft01
 */
public class Test {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		
		while(true){
			System.out.println(sdf.format(new Date()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
