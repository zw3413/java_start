package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 使用异常捕获完成下述操作
 * 将控制台输入的每一行字符串使用缓冲字符输出流PrintWriter
 * 按行以GBK编码写入到文件note.txt中
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		PrintWriter pw=null;
		Scanner scan=new Scanner(System.in);
		System.out.println("please input your content:");
		String str="";
		try{
			pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("note.txt"),"utf-8"));
			
			while(!"exit".equals(str=scan.nextLine())){
				pw.println(str);
			}
		
		
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException");
		}catch(IOException e){
			System.out.println("IOException");
		}catch(Exception e){
			System.out.println("Exception");
		}finally{
			try{
				pw.close();
			}catch(Exception e){
				System.out.println("Exception at close()");
			}
		}
		System.out.println("finished input");
		
	}
}
