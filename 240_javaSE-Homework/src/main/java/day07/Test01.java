package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 * @author Xiloer
 */
public class Test01 {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try{
			fos=new FileOutputStream("myfile_cp.txt");
			fis=new FileInputStream("myfile.txt");
			
			byte[] data=new byte[100];
			int len=-1;
			while((len=fis.read(data))!=-1){
				fos.write(data,0,len);
			}
			System.out.println("复制完毕");
		}catch(FileNotFoundException e){
		//	e.printStackTrace();
			System.out.println("FileNotFoundException from FileInputStream/FileOutputStream");
			
		}catch(IOException e){
		//	e.printStackTrace();
			System.out.println("IOException from read()and write()");
		}catch(Exception e){
			System.out.println("Exception");
		}finally{
			try{
				if(fos!=null)
					fos.close();
				if(fis!=null)
					fis.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception from close()");
			}
		}
	}	
}
