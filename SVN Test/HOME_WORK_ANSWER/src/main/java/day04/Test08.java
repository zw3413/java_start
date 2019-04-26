package day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 通过控制台输入3个日期(yyyy-MM-dd格式)，然后转换为Date对象后存入
 * 集合，然后对该集合排序后输出所有日期。
 * @author Xiloer
 *
 */
public class Test08 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> list = new ArrayList<Date>();
		for(int i=1;i<=3;i++){
			System.out.println("请输入第"+i+"个日期:");
			String line = scanner.nextLine();
			Date date = sdf.parse(line);
			list.add(date);
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
