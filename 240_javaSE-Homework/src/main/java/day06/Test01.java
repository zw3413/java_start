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
		File file=new File("myfile.txt");
		long lastModifiedTime=file.lastModified();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(lastModifiedTime));
	}
}
