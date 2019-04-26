package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine().trim();
		File file=new File(str);
		if(file.exists()){
			System.out.println("the file is already exist. Copying it...");
			copyFile(file);
		}else{
			System.out.println("the file is not exist. Creating it...");
			file.createNewFile();
			System.out.println("Creating complete!");
		}
	}
	
	public static void copyFile(File file) throws IOException{
		RandomAccessFile raf=new RandomAccessFile(file.getName(),"r");
		String starts="copy_";
		File fc=new File(starts+file.getName());
		if(fc.exists()){
			starts+=starts;
		}
		RandomAccessFile rafc=new RandomAccessFile(starts+file.getName(),"rw");
		byte[] buf=new byte[1024*10];
		int len=-1;
		while((len=raf.read(buf))!=-1){
		rafc.write(buf,0,len);
		}
		System.out.println("Copy complete!");
		raf.close();
		rafc.close();
	}
}
