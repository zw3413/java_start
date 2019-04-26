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
		System.out.println("input the filename.");
		Scanner scan=new Scanner(System.in);
		String inputFileName=scan.nextLine().trim();
		System.out.println("the inputed filename is:"+inputFileName);
		
		Test07 t=new Test07();
		//t.copy1(inputFileName);
	t.copy2(inputFileName);
		
	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 * @throws IOException 
	 */
	public void copy1(String name) throws IOException{
		String newFileName=generateNewFileName(name);
		RandomAccessFile src=new RandomAccessFile(name,"r");
		RandomAccessFile desc=new RandomAccessFile(newFileName,"rw");
		
		int d=-1;
		
		while((d=src.read())!=-1){
			desc.write(d);
		}
		src.close();
		desc.close();
		System.out.println("single byte copy finished.");
	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 * @throws IOException 
	 */
	public void copy2(String name) throws IOException{
		String newFileName=generateNewFileName(name);
		RandomAccessFile src=new RandomAccessFile(name,"r");
		RandomAccessFile desc=new RandomAccessFile(newFileName,"rw");
		
		byte[] data=new byte[10*1024];
		int len=-1;
		
		while((len=src.read(data))!=-1){
			desc.write(data,0,len);
		}
		src.close();
		desc.close();
		System.out.println("single byte copy finished.");
	}
	public static String generateNewFileName(String name){
		String[] tool=name.split("\\.");
		System.out.println("start to process and generate new filename from "+ name);
		if(tool.length<2){
			System.out.println("error!");
		}
		tool[0]+="_copy";
		System.out.println("the filename is "+tool[0]);
		System.out.println("the after is "+tool[1]);
		return tool[0]+"."+tool[1];
	}
}
