package day061;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高每次实际读写的数据量，减少读写次数
 * 来达到读写效率的提高
 * @author soft01
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src=new RandomAccessFile("typer.zip","r");
		RandomAccessFile desc=new RandomAccessFile("typer_cp2.zip","rw");
		
		byte[] buf=new byte[10*1024];
		int len=-1;
		
		/*
		 * void write(byte[] date)
		 * 将给定的字节数组中所有字节一次性写出
		 * 
		 * void write(byte[] data,int offset,int len)
		 * 将给定字节数组从下标offset处开始的连续len个字节一次性写出
		 * 
		 */
		
		long start=System.currentTimeMillis();
		while((len=src.read(buf))!=-1){
			desc.write(buf,0,len);
		}
		long end=System.currentTimeMillis();
		
		src.close();
		desc.close();
		
		System.out.println("复制完毕，耗时:"+(end-start)+"ms");
	}
}
