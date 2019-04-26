package day07;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Test04 t = new Test04();
		File dir = new File(".");
		List<Emp> list = t.loadEmps(dir);
		//排序集合
		Collections.sort(list,new Comparator<Emp>(){
			/**
			 * 从早到晚排序
			 */
			public int compare(Emp e1, Emp e2) {				
				return e2.getSalary()-e1.getSalary();
			}			
		});
		//输出员工信息
		for(Emp e : list){
			System.out.println(e);
		}
	}
	/**
	 * 从指定目录中读取所有.obj结尾的文件，并反序列化所有员工信息
	 * 然后以一个List集合返回
	 * @param dir
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public List<Emp> loadEmps(File dir) throws ClassNotFoundException, IOException{
		List<Emp> list = new ArrayList<Emp>();
		//获取所有.obj文件
		File[] emps = dir.listFiles(new FileFilter(){
			public boolean accept(File file) {
				return file.getName().endsWith(".obj");
			}
			
		});
		//将每个obj文件反序列化为Emp对象后存入List集合
		for(File empFile : emps){
			Emp emp = loadEmp(empFile);
			list.add(emp);
		}
		return list;
	}
	/**
	 * 从指定文件中反序列化Emp并返回
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Emp loadEmp(File file) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Emp e = (Emp)ois.readObject();
		ois.close();
		return e;
	}
}
