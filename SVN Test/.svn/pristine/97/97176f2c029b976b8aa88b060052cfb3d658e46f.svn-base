package day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 * @author Xiloer
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个要复制的文件名:");
		String name = scanner.nextLine();
		Test07 t = new Test07();
//		t.copy1(name);
		t.copy2(name);
	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 * @throws IOException 
	 */
	public void copy1(String name) throws IOException{
		RandomAccessFile src = new RandomAccessFile(name,"r");
		String names[] = name.split("\\.");
		RandomAccessFile desc = new RandomAccessFile(names[0]+"_copy."+names[1],"rw");
		int d = -1;
		while((d = src.read())!=-1){
			desc.write(d);
		}
		System.out.println("复制完毕!");
		src.close();
		desc.close();
	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 * @throws IOException 
	 */
	public void copy2(String name) throws IOException{
		RandomAccessFile src = new RandomAccessFile(name,"r");
		String names[] = name.split("\\.");
		RandomAccessFile desc = new RandomAccessFile(names[0]+"_copy."+names[1],"rw");
		int len = -1;
		byte[] buf = new byte[1024*10];
		while((len = src.read(buf))!=-1){
			desc.write(buf,0,len);
		}
		System.out.println("复制完毕!");
		src.close();
		desc.close();
	}
}
