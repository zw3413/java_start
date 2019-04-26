package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try{
			bis=new BufferedInputStream(new FileInputStream("myfile.txt"));
			bos=new BufferedOutputStream(new FileOutputStream("myfile_cp2.txt"));
			int d=-1;
			while((d=bis.read())!=-1){
				bos.write(d);
			}
			System.out.println("复制完毕啊");

		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException");
		}catch(IOException e){
			System.out.println("IOException");
		}finally{
				try{
				if(bis!=null)
					bis.close();
				if(bos!=null)
					bos.close();
				}catch(Exception e){
					System.out.println("Exception");
				}
		}
	}
}
