package com.transfer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * search the LAN,to find a server,
 * if no server found, then create a server.
 * @author soft01
 *
 */
public class InitServer {
	private static String here="";
	private static int portNum=8088;
	//private static Socket socket;
	private static String serverIp="";
	static {
		here= "InitServer "+ Thread.currentThread().getId()+" ";
		allServer=new ArrayList<String>();
		
	/*
		if(b) {
			try {
				socket=new Socket(serverIp,8088);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(here+"连接失败");
			}
		}else {
			creatServer();
			
		}
		*/
	}
	
//	public static Socket getSocket() {
//		return socket;
//	}



	private static void creatServer() {
		// TODO Auto-generated method stub
		
	}


	private static Collection<String> allServer;
	private synchronized  static void allServerInsert(String str) {
		allServer.add(str);
	}
	private static String tryIp="";
	private static String[] str;
	private static String localIp;
	
	private static void searchServer() {
		localIp=getLocalIp();
		str=localIp.split("\\.");
		InitServer is=new InitServer();
		for(int i=0 ;i<256;i++) {
			Searcher s= is.new Searcher(i);
			Thread t=new Thread(s);
			t.setDaemon(true);
			t.start();
		}
	}
	private class Searcher implements Runnable{
		int i;
		String tryIp="";
		public Searcher(int i) {
			this.i=i;
		}
		public void run() {
			for(int j=0;j<256;j++) {
				Socket socket=new Socket();
				try {
					tryIp= str[0]+"."+str[1]+"."+ i +"."+j;
					socket.connect( new InetSocketAddress(tryIp,portNum),30);
					if(socket.isConnected()) {
						allServerInsert(tryIp+" "+portNum);
					}
				}catch(Exception e) {
					System.out.println("Thread "+i+" time:"+j+" "+"tryIp:"+tryIp+"  not ok");
						try {
							if(socket!=null)
								socket.close();
							continue;
						} catch (IOException e1) {
							e1.printStackTrace();
							continue;
						}
				}
				System.out.println("Thread "+i+" time:"+j+" "+"tryIp:"+tryIp+"  ok");		
				if(socket!=null)
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}

public static void main(String[] args) {
	searchServer();
	
	while(Thread.activeCount()>1) {
		Thread.yield();
	}
	
	System.out.println(allServer.size());
	for(String str:allServer) {
		System.out.println(str);
	}
}


	private static String getLocalIp() {
		String localIp="";
		try {
			localIp=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return localIp.trim();
	}
		
}
