package day10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 将聊天室服务端今天写的内容独立完成一次，
 * 完成后，修改代码，使得服务端可以一直读取
 * 客户端发送过来的每一条消息并输出到控制台。
 * 
 * 初始化服务端时，读取当前包中server-config.txt文件的第一行，用该端口进行
 * ServerSocket的初始化。
 * @author Xiloer
 *
 */
public class Server {
	private ServerSocket server;
	
	public Server() throws Exception{
		try {
			//读取配置文件
			Map<String,String> config = loadConfig();
			int port = Integer.parseInt(config.get("serverPort"));
			server = new ServerSocket(port);
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 加载server-config.txt文件，读取每一行字符串，然后按照"="拆分，将等号左面的
	 * 内容作为key，等号右面的内容作为value存入Map然后返回。
	 * @return
	 * @throws Exception
	 */
	private Map<String,String> loadConfig() throws Exception{
		BufferedReader br = null;
		try {
			Map<String,String> map = new HashMap<String,String>();
			br = new BufferedReader(
				new InputStreamReader(
					Client.class.getClassLoader().getResourceAsStream("day10/server-config.txt")	
				)	
			);
			String line = null;
			while((line = br.readLine())!=null){
				String []info = line.split("=");
				map.put(info[0], info[1]);
			}
			return map;
		} catch (Exception e) {
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
	public void start(){
		try {
			System.out.println("等待客户端连接...");
			Socket socket = server.accept(); 
			System.out.println("一个客户端连接了...");
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println("客户端说:"+line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
