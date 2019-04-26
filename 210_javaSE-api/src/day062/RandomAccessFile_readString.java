package day062;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符串
 * 
 * @author soft01
 *
 */
public class RandomAccessFile_readString {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		byte[] data=new byte[100];
		int len=raf.read(data);
		
		String str=new String(data,0,len,"gbk");
		System.out.println(str);

	}
}
