package day06;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 * @author Xiloer
 *
 */
public class Test11 {
	public static void main(String[] args) {
		//ois
		ObjectInputStream ois=null;
		File dir=null;
		File[] subs=null;
		
			dir=new File(".");
			subs=dir.listFiles(new FileFilter(){
				public boolean accept(File pathname) {
					return pathname.toString().endsWith(".emp");
				}
			});
			//if(subs==null || subs.length<1)
					System.out.println("subs.length="+subs.length);
			List<Emp> cEmp=new ArrayList<Emp>();
			for(File sub:subs){
				try{
					ois=new ObjectInputStream(new FileInputStream(sub));
					cEmp.add((Emp)ois.readObject());
				}catch(FileNotFoundException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}catch(NullPointerException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
						if(ois!=null)
							ois.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		
		Collections.sort(cEmp,new Comparator<Emp>(){
			public int compare(Emp o1, Emp o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		for(Emp e:cEmp){
			System.out.println(e);
		}
	}
}
