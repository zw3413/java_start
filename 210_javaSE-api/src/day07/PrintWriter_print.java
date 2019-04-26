package day07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符流
 * 缓冲字符流内置缓冲区，可以提高读写字符效率，
 * 并且缓冲字符流的特点是可以按行读写字符串。
 * java.io.BufferedWriter
 * java.io.BufferedReader
 * 
 * 
 * java.io.PrintWriter 是常用的缓冲字符输出流
 * 并且还提供了自动行刷新功能。由于创建PrintWriter时其内部总是嵌套BufferedWriter，
 * 所以实际的缓冲操作是由BufferedWriter实现。
 * 
 * @author soft01
 *
 */
public class PrintWriter_print {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw=new PrintWriter("pw.txt","utf-8");
		pw.println("夜空中最亮的星，");
		pw.println("能否听清,");
		pw.println("那仰望的人，心底的孤独和叹息.");
		pw.close();
		System.out.println("write complete.");
	}
}
