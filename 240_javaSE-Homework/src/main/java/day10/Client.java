package day10;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 将聊天室客户端今天写的内容独立完成一次，
 * 完成后，修改代码，使聊天室可以实现用户
 * 随意在控制台输入内容并发送给服务端。
 * 
 * 在构造方法中初始化Socket时，服务端的地址与端口通过读取当前包中的config.txt
 * 文件的两行内容得到，并依读取到的值初始化Socket。
 * @author Xiloer
 *
 */
public class Client {
	
	private Socket socket;
	
	public Client() throws Exception{
		System.out.println("start the connetion.");
		try {
			socket=new Socket("localhost",8088);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println("connected!");
	}
	
	public void start(){
		
		OutputStream os=null;
		try {
			os = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw=new PrintWriter(os);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Client client;
		try {
			client = new Client();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		client.start();
		
	}

}
