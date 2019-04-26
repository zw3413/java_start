package day062;

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 使用RAF读写基本类型数据，以及了解RAF指针操作。
 * @author soft01
 */
public class RandomAccessFile_rw_type {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		int imax=Integer.MAX_VALUE;
		/*
		 * 01111111 11111111 11111111 11111111
		 */
		long pos=raf.getFilePointer();
		System.out.println("pos: "+pos);
		raf.write(imax>>>24);
		System.out.println("pos: "+raf.getFilePointer());
		raf.write(imax>>>16);
		System.out.println("pos: "+raf.getFilePointer());
		raf.write(imax>>>8);
		System.out.println("pos: "+raf.getFilePointer());
		raf.write(imax>>>0);
		System.out.println("pos: "+raf.getFilePointer());
		
		raf.writeInt(imax);
		raf.writeLong(123l);
		raf.writeDouble(123.123);
		System.out.println("pos: "+raf.getFilePointer());
		System.out.println("write complete");
		/*
		 * EOFException  End Of File Exception.
		 * 
		 * void seek(long pos)
		 * 将指针移动到指定位置
		 */
		//将指针移动到文件最开始（第一个字节的位置）
		raf.seek(0);
		int d=raf.readInt();
		System.out.println(d);

		int i=raf.readInt();
		System.out.println(i);
		long l=raf.readLong();
		System.out.println(l);
		double dou=raf.readDouble();
		System.out.println(dou);
		
		
		raf.close();
	}
}
