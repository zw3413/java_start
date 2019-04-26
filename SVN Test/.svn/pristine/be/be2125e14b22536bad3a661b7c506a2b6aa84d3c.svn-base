package day06;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 * @author Xiloer
 *
 */
public class Test11 {
	public static void main(String[] args) throws IOException, ParseException {
		Test11 t = new Test11();
		//当前目录
		File dir = new File(".");
		//将所有员工读取出来
		List<Emp> list = t.loadEmp(dir);
		//排序集合
		Collections.sort(list,new Comparator<Emp>(){
			public int compare(Emp e1, Emp e2) {
				return e1.getAge()-e2.getAge();
			}
			
		});
		for(Emp e : list){
			System.out.println(e);
		}
	}
	/**
	 * 从给定目录中读取所有.emp文件并解析为若干Emp对象，然后以
	 * 一个List集合形式返回
	 * @param dir
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public List<Emp> loadEmp(File dir) throws IOException, ParseException{
		List<Emp> list = new ArrayList<Emp>();
		File[] emps = dir.listFiles(new FileFilter(){
			public boolean accept(File file) {
				return file.getName().endsWith(".emp");
			}			
		});
		for(File file:emps){
			list.add(parseEmp(file));
		}
		return list;
	}
	/**
	 * 从指定文件中解析出Emp对象
	 * @param file
	 * @return
	 * @throws ParseException 
	 */
	public Emp parseEmp(File file)throws IOException, ParseException{
		RandomAccessFile raf = new RandomAccessFile(file,"r");
		//文件多大就创建多大的数组
		byte[] buf = new byte[(int)file.length()];
		//将文件数据全部读取出来并转换为字符串
		int len=raf.read(buf);
		String info = new String(buf,0,len);
		//解析字符串并转换为Emp对象
		String[] infos = info.split(",");
		String name = infos[0];
		int age = Integer.parseInt(infos[1]);
		String gender = infos[2];
		int salary = Integer.parseInt(infos[3]);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = sdf.parse(infos[4]);
		Emp emp = new Emp(name,age,gender,salary,hiredate);
		//打桩
		System.out.println("读取emp:"+emp);
		return emp;
	}
}
