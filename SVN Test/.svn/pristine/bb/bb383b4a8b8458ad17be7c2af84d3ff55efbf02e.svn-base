package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) throws ParseException, IOException {
		Test03 t = new Test03();
		int sum = t.getInputSum();
		System.out.println("您要输入"+sum+"个员工信息。");
		for(int i=1;i<=sum;i++){
			System.out.println("请输入第"+i+"个员工信息:");
			Emp emp = t.getEmp();
			t.saveEmp(emp);		
		}
		System.out.println("操作完毕!");
	}
	/**
	 * 要求用户输入要输入的人数并返回该值
	 * @return
	 */
	public int getInputSum(){
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		while(true){
			System.out.println("请输入要输入的员工人数(至少5个):");
			sum = Integer.parseInt(scanner.nextLine());
			if(sum>=5){
				return sum;
			}
		}
	}
	/**
	 * 获取用户输入的一个员工信息
	 * @return
	 * @throws ParseException 
	 */
	public Emp getEmp() throws ParseException{
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] infos = line.split(",");
		String name = infos[0];
		int age = Integer.parseInt(infos[1]);
		String gender = infos[2];
		int salary = Integer.parseInt(infos[3]);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = sdf.parse(infos[4]);
		Emp emp = new Emp(name,age,gender,salary,hiredate);
		return emp;
	}
	/**
	 * 将给定的Emp对象序列化到指定文件,文件名格式<name>.obj
	 * @param emp
	 * @throws IOException 
	 */
	public void saveEmp(Emp emp) throws IOException{
		FileOutputStream fos = new FileOutputStream(emp.getName()+".obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(emp);
		//打桩
		System.out.println("序列化<"+emp.getName()+">完毕");
		oos.close();
	}
}
