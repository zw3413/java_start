package com.tedu.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import com.tedu.common.HttpContext;

/**
 * 表示一个HTTP的响应
 */
public class HttpResponse {
	private String head;
	private OutputStream out;
	/*
	 * 记录所有HTTP状态行中的状态代码与状态描述
	 */
	//状态码
	private int status;
	//响应头 ContentType
	private String contentType;
	//响应头 ContentLength	
	private long contentLength=0;
	//响应实体-文件
	private File entity;
	
	public HttpResponse(OutputStream out){
		head=this.getClass().getName()+" "+Thread.currentThread().getId()+" ";
		System.out.println(head+"初始化response对象。");
		this.out=out;
	}
	public File getEntity() {
		return entity;
	}
	public void setEntity(File entity) {
		this.entity = entity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public long getContentlength() {
		return contentLength;
	}
	public void setContentlength(long contentlength) {
		this.contentLength = contentlength;
	}
	
	public void flush() throws Exception {
		/*
			 * 响应页面要向用户发送的内容：
			 * HTTP/1.1 200 OKCRLF
			 * Content-Type:text/htmlCRLF
			 * Content-Length:273CRLF
			 * CRLF
			 * 101010010101110100101(index.html数据)
			 */
			//1发送状态行
			responseStatusLine();
			//2发送响应头
			responseHeader();
			//单独发送CRLF表示响应头信息发送完毕
			responseEntity();
			//3发送响应正文
	}
	/*
	 * 向客户端发送一行字符串，以CRLF结尾（CRLF自动追加）
	 */
	private void println(String line) throws Exception{
		try{
			out.write(line.getBytes("ISO8859-1"));
			out.write(HttpContext.CR);// CR
			out.write(HttpContext.LF);//LF
		}catch(Exception e){
			throw e;
		}
	}
	//状态行
	private void responseStatusLine() {
		try{
			String line="HTTP/1.1 "+status+" "+HttpContext.statusMap.get(status);
			println(line);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//响应头
	private void responseHeader() {
		try{
			String line="Content-Type:"+contentType;
			println(line);
			line="Content-Length:"+contentLength;
			println(line);
			println("");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//响应正文
	private void responseEntity() throws Exception{
		/*
		 * 将entity文件中所有字节发送给客户端
		 */
		BufferedInputStream bis=null;
		try{
			bis=new BufferedInputStream(new FileInputStream(entity));
			BufferedOutputStream bos=new BufferedOutputStream(out);
			int d=-1;
			while((d=bis.read())!=-1){
				bos.write(d);
			}
			bos.flush();
		}catch(Exception e){
			throw e;
		}finally{
			if(bis!=null){
				try{
					bis.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void responseFile(int status,File file) throws Exception{
		/*
		 * 响应页面要向用户发送的内容：
		 * HTTP/1.1 200 OKCRLF
		 * Content-Type:text/htmlCRLF
		 * Content-Length:273CRLF
		 * CRLF
		 * 101010010101110100101(index.html数据)
		 */
		System.out.println("ClientHandler "+Thread.currentThread().getId()+": "+"根据status，file信息，设置response对象。");
		//响应 状态行
		//1.设置状态行信息
		setStatus(status);
		//2.设置响应头信息
		//分析该文件后缀，根据后缀获取对应的ContentType
		setContentType(getContentTypeByFile(file));
		setContentlength((int)file.length());
		//3.设置响应正文
		setEntity(file);
		//4.响应客户端
		try {
			System.out.println("ClientHandler "+Thread.currentThread().getId()+": "+"输出response对象。");
			flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 根据给定的文件分析器名字后缀以获取对应的contentType
	 * @param file
	 * @return
	 */
	public String getContentTypeByFile(File file){
		String name=file.getName();
		System.out.println("filename:"+name);
		String ext=name.substring(name.lastIndexOf(".")+1);
		System.out.println("ext:"+ext);
		String contentType=HttpContext.contentTypeMapping.get(ext);
		System.out.println("contentType:"+contentType);
		return contentType;
	}
}
	
	
	

