package day062;
/**
 * String 提供了将字符串转换为字节的相关方法：
 * byte getBytes()
 * 将当前字符串按照系统默认字符集转换为一组字节
 * 
 * byte getBytes(String csn)
 * 将当前字符串按照指定的字符集转换为一组字节。字符集的名称大小写均可。
 * 常用的：gbk,utf-8
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_writeString {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		String str="我爱北京天安门";
	//	byte[] ch=str.getBytes();
	//	raf.write(ch);
		byte[] data=str.getBytes("gbk");
		raf.write(data);
		raf.close();
	}
}
