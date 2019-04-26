package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 前面学过的几个流：
 * 文件流
 * 缓冲流
 * 对象流
 * 
 * 现在要学习 字符流了
 */
/**
 * java根据流读写数据的单位划分为：字节流，字符流
 * 字节流以字节为单位读写数据。
 * 字符流以字符（unicode）为单位读写数据，但是底层本质上还是读写字节，
 * 只是字节的转换工作由字符流完成
 * 
 * 
 * Writer与Reader是所有字符流的父类，他们是一对抽象类，
 * 规定了所有字符流都要具备的读写字符方法。
 * 
 * 转换流：
 * OutputStreamWriter 与 InputStreanReader是字符流的一对常见实现类
 * 
 * 
 * 
 * @author soft01
 *
 */
public class OutputStreamWriter_write {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("osw.txt");
		/**
		 * OSW的构造方法支持第二个参数，可以指定字符集，这样通过该流写出的字符都会按照指定
		 * 的字符集转换。若不指定第二个参数则按照系统默认的字符集转换。
		 * 
		 */
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		osw.write("你好你好，");
		osw.write("还是你好啊，");
		osw.write("再来一句吧。");
		osw.close();
	}
}
