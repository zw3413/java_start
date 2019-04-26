package day02;
/**
 * 实现文件重命名。
 * 要求用户输入一个文件名称，例如:abc.jpg
 * 然后对该名字进行重新命名，输出的格式为:系统时间毫秒值.jpg
 * 例如:1465266796279.jpg
 * @author Xiloer
 *
 */
import java.util.Scanner;
import java.util.Calendar;
public class Test05 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine().trim();
		Calendar calendar=Calendar.getInstance();
		long time=calendar.getTimeInMillis();
		if(str.indexOf('.')>0){
			StringBuilder sb=new StringBuilder(str.split("\\.")[1]);
			sb.insert(0, time+".");
			System.out.println(sb.toString());
		}
	}
}
