package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * 对象输入流
 * 用于将一组字节（通过对象输出流写出对象而转换的一组字节）读取并转换为对应的对象。
 * 
 * 对象输出流将对象写出是转换为一组字节的过程称为：对象序列化
 * 对象输入流将这组字节读取并还原回对象的过程成为：对象反序列化
 * 
 * @author soft01
 *
 */
public class ObjectInputStream_readObject {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		FileInputStream fis=new FileInputStream("person.obj");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Person p1=(Person)ois.readObject();
		System.out.println(p1.toString());
		ois.close();
	}
}
