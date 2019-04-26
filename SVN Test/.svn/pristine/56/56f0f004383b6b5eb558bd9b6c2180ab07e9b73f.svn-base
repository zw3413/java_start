package day08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 对myfile.txt文件进行复制操作，要求使用异常捕获
 * 机制对流的异常进行捕获和处理，finally中
 * 要将流关闭
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("myfile.txt");
			fos = new FileOutputStream("myfile_cp.txt");
			int len = -1;
			byte[] data = new byte[1024*10];
			while((len=fis.read(data))!=-1){
				fos.write(data,0,len);
			}
			System.out.println("复制完毕!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
