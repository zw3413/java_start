package com.tedu.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServletMapping {
	
	public static Map<String,String> servletMapping;
	public static void initServletMapping() throws DocumentException{
		servletMapping=new HashMap<String,String>();
		File file=new File("./config/web.xml");
		SAXReader reader=new SAXReader();
		Document doc=reader.read(file);
		Element root=doc.getRootElement();
		List<Element> servletList=root.elements("servlet");
		List<Element> servletMappingList=root.elements("servlet-mapping");
		for(Element e1:servletList) {
			for(Element e2:servletMappingList) {
				if(e1.elementText("servlet-name").equals(e2.elementText("servlet-name"))){
					servletMapping.put(e2.elementText("url-pattern"),e1.elementText("servlet-class") );
				}
			}
		}
	}
	public static String get(String uri) {
		return servletMapping.get(uri);
	}
}
