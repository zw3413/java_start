package day061;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 专门用来读写文件
 * RAF读写文件是基于文件指针进行的，即：RAF总是在文件指针指向的文件位置进行读写字节。
 * 并且读写指针会自动移到下一个字节位置。
 * @author soft01
 */
public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
		/*
		 * 向raf.dat文件中写入字节
		 * 
		 * 创建RAF时需要指定操作权限。
		 * 权限常用的有：
		 * r:只读模式，对文件数据仅读取
		 * rw:读写模式
		 * 若RAF操作的文件不存在，那么RAF是rw模式时可以自动将该文件创建出来，但是若为r模式，会抛出文件不存在异常
		 */
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		/*
		 * void write(int d)
		 * 向文件中写入1个字节，写的是给定的int值
		 * 对应的2进制的低八位
		 */	
	
			raf.write(511);
		
		
		System.out.println("写出完毕");
		raf.close();
	}
	
}
