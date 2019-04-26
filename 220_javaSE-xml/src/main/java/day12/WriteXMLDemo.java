package day12;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class WriteXMLDemo {
	public static void main(String[] args) {
		/*
		 * 生成XML文档的大致步骤：
		 * 1.创建一个Document对象表示一个空白文档
		 * 2.向Document中添加根元素
		 * 3.按照XML文档的结构逐级添加子元素
		 * 4.创建XmlWriter对象
		 * 5.将Document写出
		 * 6.关闭XmlWriter
		 */
		List<Emp> list=new ArrayList<Emp>();
		list.add(new Emp(1,"张三",22,"男",3000));
		list.add(new Emp(2,"李四",23,"女",4000));
		list.add(new Emp(3,"王五",24,"男",5000));
		list.add(new Emp(4,"赵六",25,"女",6000));
		list.add(new Emp(5,"钱七",26,"男",7000));

		try{
			Document doc=DocumentHelper.createDocument();
			/*
			 * 2
			 * Document提供了添加根源素的方法
			 * Element addElement(String name)
			 * 添加指定名字的根元素，并将其以Element的实例形式返回以便对根元素继续操作。
			 * 需要注意，该方法只能调用一次。
			 */
			Element root=doc.addElement("list");
			//将集合中的每个员工以<emp>标签形式添加到根元素
			for(Emp emp:list){
				/*
				 * Element提供了向其添加相关信息的方法
				 * 1：Element addElement(String name)
				 * 	向当前标签中添加给定名字的子标签
				 * 
				 * 2：Element addText(String text)
				 * 	向当前标签中添加文本信息
				 * 
				 * 3：Element addAttribute(String name,String value)
				 * 向当前标签中添加指定名字以及对应值的属性
				 */
				//向根源素中添加<emp>
				Element empEle=root.addElement("emp");
				empEle.addElement("name").addText(emp.getName());
				empEle.addElement("age").addText(String.valueOf(emp.getAge()));
				empEle.addElement("gender").addText(emp.getGender());
				empEle.addElement("salary").addText(String.valueOf(emp.getSalary()));
				empEle.addAttribute("id", emp.getId()+"");
			}

			FileOutputStream fos=new FileOutputStream("myEmp.xml");
			XMLWriter writer=new XMLWriter(fos,OutputFormat.createPrettyPrint());
			writer.write(doc);
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
