package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流
 * BufferedInputStream:缓冲字节输入流
 * BUfferedOuputStream:缓冲字节输出流
 * 
 * 缓冲流是一对高级流，功能是加快读写效率
 * 
 * @author soft01
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("typer.zip");
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("typer_cp5.zip");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int d;
		
		long start=System.currentTimeMillis();
		/**
		 * 缓冲流内部维护了一个字节数组
		 * 所以实际上缓冲流还是靠提高读写的数据量，减少实际的读写次数提高读写效率。
		 * bis.read()方法再第一次读取时，实际上读取了一组字节，并将第一个字节返回。
		 * 当再次调用该方法读取一个字节的时候，会将第二个字节直接返回。直到所有的字节都返回过后才会再次实际读取一组字节回来。
		 * 
		 */
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		long end=System.currentTimeMillis();
		
		fis.close();
		fos.close();
		System.out.println("complete, time:"+(end-start)+"ms");
	}
}
