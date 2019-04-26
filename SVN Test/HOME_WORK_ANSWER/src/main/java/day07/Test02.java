package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("myfile.txt");
		BufferedInputStream src = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("myfile_cp2.txt");
		BufferedOutputStream desc = new BufferedOutputStream(fos);
		int d = -1;
		while((d = src.read())!=-1){
			desc.write(d);
		}
		src.close();
		desc.close();
	}
}
