package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后输出该集合中每个员工信息。
 * 该文件800字节，每80个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为int,长度为4个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为字符串，格式"yyyy-MM-dd"，长度为30个字节，编码为:UTF-8
 * 格式可参考当前包中emp.jpg图
 * 提示:
 * 使用RandomAccessFile读取字符串时，例如name,可以先读取32个字节，再按照UTF-8
 * 转换为字符串，读取age时可以直接使用readInt方法。依次类推。
 * @author Xiloer
 *
 */
public class Test13 {
	public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
		//使用类加载器加载当前包中的emp.dat文件
		File file = new File(Test13.class.getClassLoader().getResource("day06/emp.dat").toURI());
		RandomAccessFile raf = new RandomAccessFile(file,"r");
		List<Emp> list = new ArrayList<Emp>();
		//用于将读取的入职时间解析为Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//解析10个员工信息
		for(int i=0;i<10;i++){
			//读取员工名字
			String name = readString(raf, 32).trim();
			int age = raf.readInt();
			String gender = readString(raf,10).trim();
			int salary = raf.readInt();
			String hiredate = readString(raf, 30).trim();
			Emp e = new Emp(name,age,gender,salary,sdf.parse(hiredate));
			list.add(e);
		}
		System.out.println("解析完毕!");
		for(Emp e : list){
			System.out.println(e);
		}
	}
	/**
	 * 从当前RandomAccessFile当前位置读取指定长度的字节并以UTF-8编码
	 * 转换为字符串后返回
	 * @param raf
	 * @param len
	 * @return
	 * @throws IOException 
	 */
	public static String readString(RandomAccessFile raf,int len) throws IOException{
		byte[] data = new byte[len];
		raf.read(data);
		return new String(data,"UTF-8");
	}
}
