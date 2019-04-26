package day09;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 创建一个线程，每秒输出一次当前系统时间:yyyy-MM-dd HH:mm:ss
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Thread t=new Thread(){
			public void run(){
				
				while(true){
					Calendar c=Calendar.getInstance();
					System.out.println(sdf.format(c.getTime()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		t.start();
	}
}
