package day061;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		/*
		 * 从raf.dat文件中读取一个字节
		 */
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		/*
		 * int read()
		 * 读取1个字节，并以int形式返回。
		 * 若返回值为-1，则表示读到了文件末尾
		 */
		int d=raf.read();
		System.out.println(d);
		raf.close();
		
	}
}
