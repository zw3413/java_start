package com.tedu.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * HTTP协议相关信息定义
 * @author soft01
 */
public class HttpContext {
	public static final int CR=13;
	public static final int LF=10;
	/*
	 * 状态代码定义
	 */
	//状态码-接受成功
	public static final int STATUS_CODE_OK=200;
	//状态描述-接受成功
	public static final String STATUS_REASON_OK="OK";
	//状态码-资源未发现
	public static final int STATUS_CODE_NOTFOUND=404;
	//状态描述-资源未发现
	public static final String STATUS_REASON_NOTFOUND="Not Found";
	//状态码-服务器发生未知错误
	public static final int STATUS_CODE_ERROR=500;
	//状态描述-服务器发生未知错误
	public static final String STATUS_REASON_ERROR="Internal Server Error";
	/*
	 * 状态码-状态描述 对应的Map
	 */
	public static final Map<Integer,String> statusMap= new HashMap<Integer,String>();
	/*
	 * Content-Type映射Map
	 * Key:资源类型（资源文件的后缀名）
	 * value:对应资源在HTTP协议中规定的ContentType
	 * 
	 * 例如：index.html
	 * 那么这个文件再Map中对应key应当是html
	 * value对应的应当是text/html
	 */
	public static final Map<String,String> contentTypeMapping=new HashMap<String,String>();
	
	static{
		/*
		 * 根据配置文件初始化相关信息
		 * /config/web.xml
		 */
		//1初始化ContentType映射
		initContentTypeMapping();		
		//2初始化状态码-状态描述
		initStatusMap();
	}
	/**
	 * 
	 */
	private static void initStatusMap(){
		statusMap.put(STATUS_CODE_OK, STATUS_REASON_OK);
		statusMap.put(STATUS_CODE_NOTFOUND, STATUS_REASON_NOTFOUND);
		statusMap.put(STATUS_CODE_ERROR, STATUS_REASON_ERROR);
	}
	/**
	 * 将web.xml配置文件中的<type-mappings>中的每一个<type-mapping>进行解析，
	 * 将其中属性ext的值作为key，将type属性的值作为value存入到contentTypeMapping这个map中。
	 */
	private static void initContentTypeMapping(){
		try {
			SAXReader reader=new SAXReader();
			Document doc=reader.read("config"+File.separator+"web.xml");
			Element root=doc.getRootElement();
			Element mappingsEle=root.element("type-mappings");
			List<Element> mappingList= mappingsEle.elements();
			for(Element ele:mappingList){
				String ext=ele.attribute("ext").getValue();
				String type=ele.attributeValue("type");
				contentTypeMapping.put(ext, type);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	
	}
}
