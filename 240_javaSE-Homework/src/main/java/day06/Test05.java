package day06;

import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("input a filename:");
		String fileName=scan.nextLine().trim();
		File file=new File(fileName);
		deleteFileAndDirectory(file);
	}
	private static void deleteFileAndDirectory(File file) {
		if(file.isDirectory()){
			File[] subs=file.listFiles();
			for(File f:subs){
				deleteFileAndDirectory(f);
			}
		}
		System.out.println("delete:"+file.getPath());
		file.delete();
	}
}
