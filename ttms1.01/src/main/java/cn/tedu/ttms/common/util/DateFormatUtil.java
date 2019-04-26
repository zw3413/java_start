package cn.tedu.ttms.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
//	private static SimpleDateFormat sdf=new SimpleDateFormat();
//	//静态同步方法默认使用的对象锁为类名.class
//	public static synchronized String format(Date date) {
//		return sdf.format(date);
//	}
//	public static synchronized Date parse(String str) throws ParseException {
//		return sdf.parse(str);
//	}


	//使用 ThreadLocal 类，实现线程单例，达到性能与线程安全的兼顾。
	//全局多例，会有每个线程都频繁创建销毁此对象的资源浪费问题，
	//全局单例，会有线程安全问题
	//线程单例，解决了线程安全问题，并且避免了对象频繁创建销毁的问题。
	private static ThreadLocal<SimpleDateFormat> td=new ThreadLocal<SimpleDateFormat>();
	private static SimpleDateFormat getInstance() {
		SimpleDateFormat sdf=td.get();//从ThreadLocal获取sdf
		if(sdf==null) {//如果没有
			sdf=new SimpleDateFormat("yyyy-MM-dd");//创建一个新的
			td.set(sdf);//绑定到ThreadLocal put(key,value)
		}
		return sdf;
	}
	public static String format(Date date) {
		return getInstance().format(date);
	}
	public static Date parse(String str) throws ParseException {
		return getInstance().parse(str);
	}

	//测试线程安全（线程单例）
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				SimpleDateFormat sdf1=getInstance();
				SimpleDateFormat sdf2=getInstance();
				System.out.println(sdf1==sdf2);
			}
		}.start();
	}
}
