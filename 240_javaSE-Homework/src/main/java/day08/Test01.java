package day08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
	BufferedInputStream bis=null;
	BufferedOutputStream bos=null;
		
	try{
		bis=new BufferedInputStream(new FileInputStream("myfile.txt"));
		bos=new BufferedOutputStream(new FileOutputStream("myfile_cp.txt"));
		
		int d=-1;
		
		while((d=bis.read())!=-1){
			bos.write(d);
		}
	}catch(FileNotFoundException e){
		System.out.println("FileNotFoundException");
	}catch(IOException e){
		System.out.println("IOException");
	}catch(Exception e){
		System.out.println("Exception");
	}finally{
		try{
			if(bis!=null) bis.close();
			if(bos!=null) bos.close();
		}catch(Exception e){
			System.out.println("Exception when close.");
		}
	}
	System.out.println("copy finished");
	}
}
