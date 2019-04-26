package day06;

import java.io.File;

/**
 * 获取并输出当前目录下的所有文件和目录的名字
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		File dir=new File(".");
		File[] subDir=dir.listFiles();
		for(File f: subDir){
			System.out.println(f.getName());
		}
	}
}
