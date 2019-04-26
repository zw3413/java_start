package day07;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流的缓冲区问题 
 * @author soft01
 */
public class BufferedOutputStream_flush {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("bos.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="我爱北京天安门，天安门上太阳升。";
		byte[] buf=str.getBytes("utf-8");
		bos.write(buf);
		bos.flush();
		System.out.println("write complete.");

	}
}
