package day06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2016-03-23 14:22:16
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		File file = new File("myfile.txt");
		String name = file.getName();
		System.out.println("名字:"+name);
		
		long length = file.length();
		System.out.println("大小:"+length+"字节");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lastModified = file.lastModified();
		System.out.println("最后修改时间:"+sdf.format(new Date(lastModified)));
	}
}
