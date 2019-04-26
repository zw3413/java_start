package day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) throws IOException {
		
		Scanner scan=new Scanner(System.in);
		String path=scan.nextLine().trim();
		File f=new File(path);
		
		if(f.exists()){
			System.out.println("The "+path+" is already exist, creating copy..." );
			creatCopyPath(path);
		}else{
			System.out.println("The "+path+" is not exist, creating new...");
			f.mkdirs();
			System.out.println("Creat new complete.");
		}	
	}
	private static void creatCopyPath(String path) throws IOException {
		
		String start="copy_";
		File p=new File(start+path);
		while(p.exists()){
			start+=start;
			p=new File(start+path);
		}
		p.mkdirs();
		System.out.println("Creat copy complete.");
	}
}
