package day06;

import java.io.File;

/**
 * 获取并输出当前目录下所有文件的名字
 * @author Xiloer
 *
 */
public class Test06 {
	public static void main(String[] args) {
		File f=new File(".");
		File[] subs=f.listFiles();
		for(File sub:subs){
			System.out.println(sub.getName());
		}
	}
}
