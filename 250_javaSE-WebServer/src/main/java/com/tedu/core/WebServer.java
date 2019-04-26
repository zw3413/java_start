package com.tedu.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Web服务器
 * @author soft01
 *
 */
public class WebServer {
	
	private ServerSocket server;
	private ExecutorService threadPool;
	public WebServer() throws IOException{
		threadPool=Executors.newFixedThreadPool(10);
			System.out.println(this.getClass().getName()+":"+"开始启动服务器...");
			try{
				server=new ServerSocket(8088);
			}catch(IOException e){
				e.printStackTrace();
				throw e;
			}
			System.out.println(this.getClass().getName()+":"+"服务器启动成功。");
	}
	/*
	 * 主程序：
	 * 监听客户端连接，接收连接的客户端请求
	 */
	public void start(){
		try{
			//监听客户端连接
			System.out.println(this.getClass().getName()+":"+"等待客户端连接...");
			while(true){
				Socket socket=server.accept();
				System.out.println(this.getClass().getName()+":"+"一个客户端已连接,启动线程。");
				System.out.println(this.getClass().getName()+":"+"等待下一个客户端连接...");
				/*
				 * 使用线程池来统一管理Runnable。
				 */
				threadPool.execute(new ClientHandler(socket));
		//		new Thread(new ClientHandler(socket)).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 根据输入流读取一行字符串
	 * 根据HTTP协议读取请求中的一行内容，(以CRLF结尾的一行字符串)
	 */
	public static void main(String[] args) {
		try{
			WebServer server=new WebServer();
			server.start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("服务器启动失败。");
		}
	}
}
