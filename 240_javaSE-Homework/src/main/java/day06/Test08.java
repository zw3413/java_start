package day06;

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
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		String strIntMax="intMax:"+Integer.toString(Integer.MAX_VALUE)+";";
		String strLongMax="longMax:"+Long.toString(Long.MAX_VALUE)+";";
		int len=-1;
		byte[] data=strIntMax.getBytes("utf-8");
		len=strIntMax.length();
		raf.write(data,0,len);
		data=strLongMax.getBytes("utf-8");
		len=strLongMax.length();
		raf.write(data,0,len);
	
		byte[] buf=new byte[100];
		raf.seek(0);
		len=-1;
		len=raf.read(buf);
		System.out.println(len);
		String readStr=new String(buf,0,len,"utf-8");
		System.out.println(readStr);
		String[] str=readStr.split(";");
		System.out.println(str[0]);
		System.out.println(str[1]);
	
		raf.close();	
	}
}
