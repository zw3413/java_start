package day12;

import java.io.FileInputStream;
import java.util.List;


import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;

/**
 * 使用XPATH检索XML文档数据
 * @author soft01
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try{
			SAXReader reader=new SAXReader();
			FileInputStream fis=new FileInputStream("myEmp.xml");
			Document doc=reader.read(fis);;
			
			String xpath1="/*";
			String xpath2="/*/*";
			String xpath3="/list/emp/name";
			String xpath4="/list/emp/age";
			String xpath="/list/emp[salary>4000 and gender='女']/name";
			List<Element> list=doc.selectNodes(xpath);
			
			for(Element ele:list){
				System.out.println(ele.getText());
			}
			
		}catch(Exception e){
			
		}
	}
}
