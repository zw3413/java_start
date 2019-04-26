package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 记事本功能
 * 
 * @author soft01
 *
 */
public class Note {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		System.out.println("输入文件名字：");
		Scanner scan=new Scanner(System.in);
		String fileName=scan.nextLine().trim();		
		
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName),"utf-8"),true);
		/**
		 * PrintWriter在流链接中的构造方法：
		 * PrintWriter(OutputStream out)
		 * PrintWriter(Writer out)
		 * 使用上述构造方法是，有意个对应的重载构造方法要求传入第二个参数，该参数为boolean值
		 * 若该值为true，则pw具有自动行刷新功能，
		 * 即：每当使用pw.println()写出内容后都会自动进行flush操作。
		 * 
		 * PrintWriter(OutputStream out,boolean autoflush)
		 * PrintWriter(Writer out,boolean autoflush)
		 */
		String str;
		while(!"exit".equals(str=scan.nextLine().trim())){
			pw.println(str);
		}
		System.out.println("结束。");
		pw.close();
	}
	
	
}
