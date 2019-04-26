package com.transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JFileChooser;

public class Transfer {
	
	public static final int COMMAND_FILE=1;
	public static final int COMMAND_MESSAGE = 2 ;
	
	public static final int RESPONSE_OK=1;
	public static final int RESPONSE_NOT_OK=0;

	private Socket socket; // to save the socket of client.
	
	//configuration of the socket, ip/port..
	private String serverAddress="localhost";
	private int serverPort=8088;
	private int connectingTimeout=100;
	
	protected File file=null; // the file will be transfer
	//path for saving the files received.
	private File saveFile;
	
	//get the InputStream and OutputStream from the socket
	private InputStream socketIn=null;
	private OutputStream socketOut=null;
	private InputStream fileIn=null;
	private OutputStream fileOut=null;
	
	private int command;//use to save the type of transferring, including the command, file, and massage.
	private boolean response=false; // to save the response status.
	private GUI gui;
	
	
	
	public void setGui(GUI gui){
		this.gui=gui;
	}
	public Transfer(){
	//	Connection conn=new Connection();
	//	this.socket=InitServer.getSocket();
	}
	public void setFile(File file){
		this.file=file;
	}
	protected boolean connectServer(){
		socket=new Socket();
		try{
			socketIn=socket.getInputStream();//inputStream from the socket.
			socketOut=socket.getOutputStream();//outpuStream to the socket.
			return true;// connected successfully.
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void initRece() {
		while(true) {
			if(socket==null){
				throw new RuntimeException("连接失败");
			}
			int type=readType();
			switch(type) {
			case Transfer.COMMAND_FILE:
				if(setReceiving()) {
					receiveFile();
				}
				break;
			case Transfer.COMMAND_MESSAGE:
				receiveMessage();//这里需要创建一个事件，让GUI来响应
				break;
			default:
				System.out.println("接收类型未知");
			}
		}
	}
	private void receiveMessage() {
		//receive the message pending..
		System.out.println("receive the message pending..");
	}
	private int readType() {
		int type=-1;
		try {
			type = socketIn.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(type==-1)
			throw new RuntimeException("didn't read the type");
		return type;
	}
	private void receiveFile() {
		try{
			fileOut=new FileOutputStream(saveFile);
			int d=-1;
			while((d=socketIn.read())!=-1){
				fileOut.write(d);
			}
			System.out.println("write the file complete.");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean setReceiving() {
		JFileChooser save=new JFileChooser();
		int returnVal=save.showSaveDialog(null);
		if(returnVal==JFileChooser.APPROVE_OPTION){
			this.saveFile=save.getSelectedFile();
			System.out.println(saveFile);
			return true;
		}
		return false;
	}

	protected void initSendFile() {
		sendType(Transfer.COMMAND_FILE);
		sendFile();	
	}
	private void sendFile() {
		send(file);		
	}
	private void sendType(int commandFile) {
		send(commandFile);

	}
	private void send(int c) {
		try {
			socketOut.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private	void send(File file){
		try{
			fileIn=new FileInputStream(file);
			int d=-1;
			while((d=fileIn.read())!=-1){
				socketOut.write(d);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	

}