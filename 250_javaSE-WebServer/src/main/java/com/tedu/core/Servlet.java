package com.tedu.core;

import java.io.File;

import com.tedu.common.HttpContext;
import com.tedu.http.HttpRequest;
import com.tedu.http.HttpResponse;

public abstract class Servlet {
	
	protected abstract void service(HttpRequest request,HttpResponse response) throws Exception;
	
	protected void forward(File file,HttpResponse response) throws Exception{
		
		System.out.println("ClientHandler "+Thread.currentThread().getId()+": "+"根据status，file信息，设置response对象。");
		response.setStatus(HttpContext.STATUS_CODE_OK);
		response.setContentType(response.getContentTypeByFile(file));
		response.setContentlength((int)file.length());
		response.setEntity(file);
		System.out.println("ClientHandler "+Thread.currentThread().getId()+": "+"输出response对象。");
		response.flush();

	}
}
