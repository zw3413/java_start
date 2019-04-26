package day08;

import java.io.FileOutputStream;
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
		PrintWriter pw = null;
		try {
			Scanner scanner = new Scanner(System.in);
			pw = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream("note.txt"),"GBK"
				)	
			);
			System.out.println("请输入内容,若输入exit则程序退出:");
			String line = null;
			while(true){
				line = scanner.nextLine();
				if("exit".equals(line)){
					break;
				}
				pw.println(line);
			}
			System.out.println("再见!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			pw.close();			
		}
	}
}
