package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * PrintWriter在流链接中的应用
 * @author soft01
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		FileOutputStream fos=new FileOutputStream("pw2.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		PrintWriter pw=new PrintWriter(osw);
		pw.println("你还要我怎样，我怎样。");
		pw.println("你突然来的短信就够我悲伤。");
		pw.close();
		System.out.println("Write complete.");
	}
}
