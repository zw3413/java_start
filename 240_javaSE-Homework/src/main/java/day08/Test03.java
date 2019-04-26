package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 使用异常捕获机制完成下述读取操作。
 * 使用缓冲流读取note.txt文件，并将每行字符串输出到控制台上
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		
		BufferedReader br=null;
		
		try{
			br=new BufferedReader(new InputStreamReader(new FileInputStream("note.txt"),"GBK"));
			
			String line="";
	
			while((line=br.readLine())!=null){
				System.out.println(line);
				
			}
			
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException");
		}catch(UnsupportedEncodingException e){
			System.out.println("UnsupportedEncodingException");
		}catch(IOException e){
			System.out.println("IOException");
		}finally{
			try {
				if(br!=null)
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Finished printing.");
		
		
		
		
		
		
	}
}
