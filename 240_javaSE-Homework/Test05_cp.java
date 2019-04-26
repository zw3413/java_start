package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 * @author Xiloer
 *
 */
public class Test05 {

	public static void main(String[] args) {
		
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		try {
			isr=new InputStreamReader(new FileInputStream("src/main/java/day07/Test05.java"),"utf-8");
			osw=new OutputStreamWriter(new FileOutputStream("Test05_cp.java"),"utf-8");
			
			char[] data=new char[100];
			int len=-1;
			
			try {
				while((len=isr.read(data))!=-1){
					osw.write(data,0,len);		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(isr!=null)
					isr.close();
				if(osw!=null)
					osw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
			
		System.out.println("copy finished.");
	}
}
