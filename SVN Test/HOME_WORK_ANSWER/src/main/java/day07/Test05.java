package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"src"+File.separator+
				"main"+File.separator+
				"java"+File.separator+
				"day07"+File.separator+
				"Test05.java");
		InputStreamReader isr = new InputStreamReader(fis);
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("Test05.java"));
		
		int d = -1;
		while((d = isr.read())!=-1){
			osw.write(d);
		}
		System.out.println("复制完毕");
		isr.close();
		osw.close();
	}
}
