package day08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("./src/main/java/day08/emp.dat","r");
		List<Emp> collection=new ArrayList<Emp>();
		for(int i=0;i<10;i++){
			String name=readString(raf,32).trim();
			short age=raf.readShort();
			String gender=readString(raf,10).trim();
			int salary=raf.readInt();
			Long date=raf.readLong();
			Date hiredate=new Date(date);
			Emp emp=new Emp(name,(int)age,gender,salary,hiredate);
			collection.add(emp);
		}
		Collections.sort(collection,new Comparator<Emp>(){
			public int compare(Emp o1, Emp o2) {
				return (int)(o1.getHiredate().getTime()-o2.getHiredate().getTime());
			}
		});
		for(Emp e:collection){
			System.out.println(e);
		}
	}

	private static String readString(RandomAccessFile raf,int len) throws IOException{
		byte[] data=new byte[len];
		raf.read(data);
		return new String(data,"utf-8")+"\n";
	}
}
