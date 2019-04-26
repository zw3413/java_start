package day07;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 * @author Xiloer
 *
 */
public class Test04 {

	public static void main(String[] args) {
	
		File file=new File(".");
		List<Emp> list=new ArrayList<Emp>();
		
		File[] subs=file.listFiles(new FileFilter(){

			public boolean accept(File pathname) {
				return pathname.toString().endsWith(".obj");
			}
			
		});
		for(File sub:subs){
			System.out.println(sub);
		}
		ObjectInputStream ois=null;
		for(File sub:subs){
			try {
				ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(sub)));
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			}catch(Exception e){
				
			}
			try {
				Object obj;
				if((obj=ois.readObject()) instanceof Emp){
					list.add((Emp)obj);
					System.out.println("found the Emp object:"+ (Emp)obj);
				}
			} catch (ClassNotFoundException e) {
	
			} catch (IOException e) {
		
			} finally{
				try{
					if(ois!=null)
						ois.close();
				}catch(Exception e){
					
				}
			}
		}
		System.out.println(list);
	}
}
