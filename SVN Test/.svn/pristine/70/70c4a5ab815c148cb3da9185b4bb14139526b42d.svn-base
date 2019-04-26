package day12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:1,张三,25,男,5000,2006-3-18
 * 每当输入一个员工后，要检查新输入的员工的id是否已经存在，即：不能在本次输入的
 * 这些员工信息中出现相同id的员工。
 * 然后按照emp.xml的格式，将这些员工写入到myemp.xml文档中。
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		try {
			Collection<Emp> emps = getEmp(5);
			writeXml(emps,"myemp.xml");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static void writeXml(Collection<Emp> emps,String fileName){
		XMLWriter writer = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("list");
			for(Emp emp : emps){
				Element empEle = root.addElement("emp");
				empEle.addAttribute("id", String.valueOf(emp.getId()));
				empEle.addElement("name").addText(emp.getName());
				empEle.addElement("age").addText(String.valueOf(emp.getAge()));
				empEle.addElement("gender").addText(emp.getGender());
				empEle.addElement("salary").addText(String.valueOf(emp.getSalary()));
				empEle.addElement("hiredate").addText(sdf.format(emp.getHiredate()));
			}
			writer = new XMLWriter(new FileOutputStream(fileName),OutputFormat.createPrettyPrint());
			writer.write(doc);
			System.out.println("写出完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(writer != null){
				 try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 该方法用来获取用户输入的若干员工信息，并存入到一个集合后返回
	 * @param num 要输入的员工数量
	 * @return
	 * @throws ParseException 
	 */
	public static Collection<Emp> getEmp(int num) throws ParseException{
		Map<Integer,Emp> emps = new LinkedHashMap<Integer,Emp>();
		if(num<1){
			System.out.println("人数至少为1！");
			return null;
		}
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int i = 1;
		while(true){
			System.out.println("请输入第"+i+"个员工信息:");
			String line = scanner.nextLine();
			String data[] = line.split(",");
			if(data.length!=6){
				System.out.println("员工信息有误！");
				continue;
			}
			
			int id = Integer.parseInt(data[0]);
			if(emps.containsKey(id)){
				System.out.println("id:"+id+"已经存在！");
				continue;
			}
			String name = data[1];
			int age = Integer.parseInt(data[2]);
			String gender = data[3];
			int salary = Integer.parseInt(data[4]);
			Date hiredate = sdf.parse(data[5]);
			Emp emp = new Emp(id, name, age, gender, salary, hiredate);
			emps.put(id, emp);
			if(++i>num){
				break;
			}
		}
		return emps.values();
	} 
	
}
