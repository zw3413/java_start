package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 聊天室服务端
 * @author soft01
 */
public class Server {
	/**
	 * 运行再服务端的java.net.ServerSocket
	 * 主要有两个作用：
	 * 1.向系统申请对外的服务端口，客户端Socket就是通过这个端口与服务端程序建立连接的。
	 * 2.监听该服务端口，一旦一个客户端Socket通过该端口尝试建立连接，
	 * 	 Serverocket就会感知并实例化一个Socket与该客户端进行通讯。
	 */
	private ServerSocket server;
	/*
	 * 存放所有客户端输出流，用于广播消息给所有客户端
	 */
	private List<PrintWriter> allOut;
	public Server() throws Exception{
		try{
			/*
			 *实例化ServerSocket的同时向系统申请服务端口，若当前系统其他应用程序正在使用这个端口，
			 *那么这里实例化会抛出地址被占用的异常：Address Already I Use. 
			 */
			System.out.println("正在启动客户端...");
			server=new ServerSocket(8088);
			System.out.println("客户端启动完毕！");
		}catch(Exception e){
			throw e;
		}
	}
	/**
	 * 服务端开始工作的方法
	 */
	public void start(){
		try{
			/*
			 * ServerSocket提供方法：
			 * Socket accept()
			 * 该方法是一个阻塞方法，用于监听服务端口，直到有一个客户端连接上为止，
			 * 这里会返回一个Socket，通过这个Socket就可已与该客户端进行通讯了。
			 */
			allOut=new ArrayList<PrintWriter>();
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket=server.accept();
				System.out.println("一个客户端连接了！");
			//一个客户端连接后启动一个线程处理该客户端
				ClientHandler handler=new ClientHandler(socket);
				Thread t=new Thread(handler);
				t.start();
			}
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try{
			Server server=new Server();
			server.start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("服务端运行失败！");
		}
	}
/**
 * 该线程负责通过给定的Socket与指定客户端进行通讯
 * @author soft01
 *
 */
	private class ClientHandler implements Runnable{
		private Socket socket;
		private String host;
		public ClientHandler(Socket socket){
			this.socket=socket;
			//通过该Socket获取远端计算机地址信息
			InetAddress address=socket.getInetAddress();
			//获取客户端IP地址的字符串格式内容
			host=address.getHostAddress();
		}
		
		public void run() {
			BufferedReader br=null;
			PrintWriter pw=null;
			try{
				br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"gbk"));
				//通过socket获取输出流用于将消息发送给客户端
				pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"gbk"),true);
				//将该客户端的输出流放入共享集合
				synchronized(allOut){
					allOut.add(pw);
					
				}
				System.out.println(allOut);
			}catch(Exception e){
				e.printStackTrace();
			}
				/*
			 *当使用缓冲流读取一行来自客户端发送过来的字符串过程中，br.readLine()方法会一直阻塞，
			 *直到客户端发送了一行字符串，若客户端断开连接，那么客户端的系统不同，这里的反应也不同。
			 *当windows的客户端断开时，br.readLine()方法会抛出异常。
			 *当Linux的客户端断开时，br.readLine()方法会返回null。 
			 */
			String line="";
			String message="";
			try {
				while((message=br.readLine())!=null){
					line=host+"说："+message;
					System.out.println("客户端说："+line);
					//pw.println(line);
					//遍历所有集合，将消息发给所有客户端
					synchronized(allOut){
						for(PrintWriter p:allOut){
							p.println(line);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//处理客户端断开连接之后的操作
				synchronized(allOut){
					//1：先将该客户端的输出流从共享集合删除
					allOut.remove(pw);
				}
				//2:将对应该客户端的Socket关闭以释放资源
				try{
					socket.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
