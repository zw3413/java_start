package transfer_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TransferServer {
	private ServerSocket server=null;
	private static boolean rf = true;
	private List<Socket> socketList=null;
	
	public TransferServer() throws Exception{
		socketList=new ArrayList<Socket>();
		int i=0;
		boolean flag=false;
		while((flag=!this.initServerSocket())&&i<5){
			System.out.println("try to create the server, time: "+i);
			i++;
		}
		if(!flag){
			System.out.println("Create Server successfully.");
			return;
		}
		System.out.println("Create Server failed after 5 time try.");
	}
	
	private boolean initServerSocket() throws Exception{
		try{
			 server =new ServerSocket(8088);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw e;
			}catch(Exception e1){
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		TransferServer transfer=null;
		try{
			transfer=new TransferServer();
		}catch(Exception e){
			System.out.println("exit.");
			rf=false;
			try{
				transfer.server.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rf==true){
			System.out.println("start the listening...");
			transfer.start();
		}
	}
	private void start() {
		
		Socket socket=new Socket();
		while(rf){
			try{
				socket=server.accept();
				System.out.println("server.start():"+socket);
				String clientAdd=socket.getInetAddress().toString();
				System.out.println(clientAdd+ " has connected.");
				socketList.add(socket);
				new Thread(new ClientHandler(socket)).start();;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("1 client tried to connect the server, but failed.");
			}
		}
	}
	private class ClientHandler implements Runnable{
		private Socket socket=null;
		private InputStream in=null;
		private OutputStream out=null;
		
		public ClientHandler(Socket socket) throws Exception{
			this.socket=socket;
			try{
				in=socket.getInputStream();
				out=socket.getOutputStream();
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
		}
		public void run() {
			/*
			BufferedReader br=null;
			PrintWriter pw=null;
			
				br=new BufferedReader(new InputStreamReader(in,"utf-8"));
				pw=new PrintWriter(new OutputStreamWriter(out,"utf-8"),true);
				String line="";
				while((line= br.readLine())!=null){
					System.out.println(line);
					pw.println(line);
				}
				*/
			try{
				int d=-1;
				while((d=in.read())!=-1) {
					out.write(d);
					System.out.println(d);
				}
			}catch(Exception e){
				
			}finally{
				if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}}
			}
		}
	}
}