package day07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("typer.zip");
		FileOutputStream fos=new FileOutputStream("typer_cp.zip");
		byte[] buf=new byte[10*1024];
		int len=-1;
		long start=System.currentTimeMillis();		
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		long end=System.currentTimeMillis();	
		fos.close();
		fis.close();
		System.out.println("copy complete. with the time comsuming:"+(end-start)+"ms");
	}
}
