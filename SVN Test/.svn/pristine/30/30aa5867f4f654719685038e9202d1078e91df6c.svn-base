package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 * @author Xiloer
 *
 */
public class Test08 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
		raf.writeInt(Integer.MAX_VALUE);
		raf.writeLong(Long.MAX_VALUE);
		raf.seek(0);
		int i = raf.readInt();
		long l = raf.readLong();
		System.out.println("int:"+i);
		System.out.println("long:"+l);
		raf.close();
	}
}
