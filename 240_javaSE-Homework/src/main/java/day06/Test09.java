package day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 * @author Xiloer
 *
 */
public class Test09 {
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		RandomAccessFile raf=new RandomAccessFile("note.txt","rw");
		
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine().trim();
		while(!("exit".equals(input))){
			raf.write(input.getBytes("utf-8"),0,input.length());
			raf.write('\n');
			input=scan.nextLine().trim();
		}
		raf.close();
	}
}
