package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取并输出当前目录下所有文件的名字
 * @author Xiloer
 *
 */
public class Test06 {
	public static void main(String[] args) {
		File dir = new File(".");
		File []subs = dir.listFiles(new FileFilter(){
			public boolean accept(File file) {
				return file.isFile();
			}
			
		});
		for(File sub : subs){
			System.out.println("文件:"+sub.getName());
		}
	}
}
