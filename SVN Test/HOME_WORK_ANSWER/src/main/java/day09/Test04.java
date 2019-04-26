package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建一个线程，每秒输出一次当前系统时间:yyyy-MM-dd HH:mm:ss
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				while(true){
					System.out.println(sdf.format(new Date()));
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();
	}
}
