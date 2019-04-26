package day08;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/**
 * 使用异常捕获机制完成下述读取操作，并在finally中有关闭RandomAccessFile操作。
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后按照员工入职从晚到早的顺序依次输出员工信息。
 * 
 * 该文件560字节，每56个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为short,长度为2个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为long，长度为8个字节
 * 格式可参考当前包中emp.jpg图
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
		//使用类加载器加载当前包中的emp.dat文件
		File file = new File(Test05.class.getClassLoader().getResource("day08/emp.dat").toURI());
		RandomAccessFile raf = new RandomAccessFile(file,"r");
		List<Emp> list = new ArrayList<Emp>();
		//解析10个员工信息
		for(int i=0;i<10;i++){
			//读取员工名字
			String name = readString(raf, 32).trim();
			short age = raf.readShort();
			String gender = readString(raf,10).trim();
			int salary = raf.readInt();
			long hiredate = raf.readLong();
			Emp e = new Emp(name,age,gender,salary,new Date(hiredate));
			list.add(e);
		}
		System.out.println("解析完毕!");
		//排序集合
		Collections.sort(list,new Comparator<Emp>(){
			public int compare(Emp e1, Emp e2) {				
				return e2.getHiredate().getTime()-e1.getHiredate().getTime()>0?1:-1;
			}
			
		});
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
