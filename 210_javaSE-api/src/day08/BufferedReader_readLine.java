package day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 缓冲字符输入流
 * 可以按行读取字符串
 * 
 * @author soft01
 *
 */
public class BufferedReader_readLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("src"+File.separator+"day08"+File.separator+"BufferedReader_readLine.java")));
		/**
		 * BufferedReader提供方法：
		 * String readLine()
		 * 连续读取若干字符，直到读取了换行符为止，
		 * 将之前的所有字符以一个字符串形式返回。
		 * 注意：返回的字符串中是不包含最后的换行符的
		 * 若返回值为null，则表示末尾。
		 */
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
		
	}
}
