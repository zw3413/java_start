package day12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析前需要修改pom.xml文档，加载dom4j的jar包。
 * 将emp.xml文件中的员工信息解析出来并以Emp实例保存到一个集合中然后
 * 按照工资从高到低的顺序输出每个员工信息
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(Test01.class.getClassLoader().getResourceAsStream("day12/emp.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			List<Emp> emps = new ArrayList<Emp>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(Element empEle : list){
				int id = Integer.parseInt(empEle.attribute("id").getValue());
				String name = empEle.elementText("name");
				int age = Integer.parseInt(empEle.elementText("age"));
				String gender = empEle.elementText("gender");
				int salary = Integer.parseInt(empEle.elementText("salary"));
				Date hiredate = sdf.parse(empEle.elementText("hiredate"));
				Emp e = new Emp(id, name, age, gender, salary, hiredate);
				emps.add(e);
			}
			System.out.println(emps);
			//按照工资倒序排列
			Collections.sort(emps,new Comparator<Emp>(){
				public int compare(Emp o1, Emp o2) {
					return o2.getSalary()-o1.getSalary();
				}
			});
			System.out.println(emps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
