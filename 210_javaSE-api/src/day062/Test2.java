package day062;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 
 * 简易记事本
 * 程序启动后，要求用户输入一个文件名
 * 然后对该文件进行写操作
 * 之后用户输入的每行字符串都写入该文件
 * 当用户输入了exit时，推出程序。
 * @author soft01
 *
 */
public class Test2 {

	public static void main(String[] args) throws IOException {
		System.out.println("input the filename:");
		Scanner scan=new Scanner(System.in);
		String fileName=scan.nextLine().trim();
		RandomAccessFile raf=new RandomAccessFile(fileName,"rw");
		String inputLine;
		while(!(inputLine=scan.nextLine().trim()).equals("exit")){
			byte[] buf=inputLine.getBytes("gbk");
			raf.write(buf);
			raf.write('\n');
		}
		System.out.println("Exit!");
		raf.close();
		scan.close();
	}
}
