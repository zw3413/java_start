package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象流
 * 对象流是一对高级流，可以方便我们读写java中的任何对象。（对象与字节的转换工作由对象流完成。
 * 
 * java.io.ObjectOutputStream
 * 对象流输出，用于写出对象
 * 
 * @author soft01
 *
 */
public class ObjectOutputStream_writeObject {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("person.obj");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		Person p=new Person();
		List<String> l=new ArrayList<String>();
		
		l.add("讲课幽默，");
		l.add("有责任心");
		l.add("长得帅");
		
		p.setAge(18);
		p.setGender("男");
		p.setName("王老师");
		p.setOtherInfo(l);
		
		System.out.println(p);
		
		oos.writeObject(p);
		oos.close();
	}
}
