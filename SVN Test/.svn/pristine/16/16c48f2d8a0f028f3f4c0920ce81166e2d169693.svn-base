package day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
		try {
			//读取配置文件
			Map<String,String> config = loadConfig();
			String host = config.get("serverHost");
			int port = Integer.parseInt(config.get("serverPort"));
			socket = new Socket(host,port);
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 加载config.txt文件，读取每一行字符串，然后按照"="拆分，将等号左面的
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
					Client.class.getClassLoader().getResourceAsStream("day10/config.txt")	
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
			Scanner scanner = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
			
			String line = null;
			while(true){
				line = scanner.nextLine();
				pw.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
