package day12;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，id从1开始，自动为每个员工分配。之后按照emp.xml的格式将
 * 这些员工写入到emplist.xml文档中
 * 该文件800字节，每80个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为int,长度为4个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为字符串，长度为30个字节，编码为:UTF-8  内容格式:yyyy-MM-dd(由于长度30，后面可能会存在空白，注意去除)
 * 格式可参考当前包中emp.jpg图
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		try{
			List<Emp> list = getEmp();
			Test02.writeXml(list,"emplist.xml");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 读取所有员工信息
	 * @return
	 * @throws Exception 
	 */
	public static List<Emp> getEmp() throws Exception{
		List<Emp> list = new ArrayList<Emp>();
		RandomAccessFile raf = null;
		try {
			File file = new File(Test03.class.getClassLoader().getResource("day12/emp.dat").toURI());
			raf = new RandomAccessFile(file,"r");	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//解析10个员工信息
			for(int i=1;i<=10;i++){
				//读取员工名字
				String name = readString(raf, 32).trim();
				int age = raf.readInt();
				String gender = readString(raf,10).trim();
				int salary = raf.readInt();
				String hiredate = readString(raf,30).trim();
				Emp e = new Emp(i,name,age,gender,salary,sdf.parse(hiredate));
				list.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
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
