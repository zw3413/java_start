package day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 * @author Xiloer
 *
 */
public class Test06 {

	public static void main(String[] args) {
		System.out.println("Input the file name please:");
		Scanner scan =new Scanner(System.in);
		String fileName=scan.nextLine();
		File file=new File(fileName);
		
		PrintWriter pw=null;
		
		try {
			pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String input="";
		while(!"exit".equals(input=scan.nextLine())){
			pw.println(input);
		}
		
		pw.close();
		System.out.println("exit the program.");
		
	}
}
