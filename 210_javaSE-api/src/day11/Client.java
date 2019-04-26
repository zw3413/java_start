package day11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
/**
 * 聊天室客户端
 * java.net.Socket套接字
 * 封装了TCP通讯协议。使用它可以基于TCP与远端计算机上的服务端应用程序连接并进行通讯。
 * @author soft01
 */
public class Client extends JFrame {
	private Socket socket;
	private ServerSocket server;
	private JButton b1,b2,b3;
	private PrintWriter pw;

	/** 
	 * 构造方法，用来初始化客户端
	 */
	public Client() throws Exception{
		/*
		 * 将来针对异常可能要记录日志，所以需要感知错误。但是若异常不应当在这里被处理时，可以继续再catch中将其抛出。
		 */
		try{
			/*
			 * 实例化Socket就是与服务端建立连接的过程。
			 * 这里需要传入两个参数来指定服务端地址信息
			 * 参数1：服务端计算机的IP地址
			 * 参数2：运行在服务端计算机上的服务端应用程序打开的服务端口
			 */
			System.out.println("正在连对方接服务端。。。");
			socket=new Socket("172.88.7.105",8088);
			//socket=new Socket("172.88.7.114",8088);
			System.out.println("与对方服务端建立链接！");	
			pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
		}catch(Exception e){
			throw e;
		}finally{
		}
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try{
			/*
			 * Socket提供方法：
			 * OutputStream getOutputStream()
			 * 通过Socket获取的输出流写出的字节
			 * 都会通过网络发送给远端计算机。
			 * 这里就等于发送给服务器了。
			 */
			
			Scanner scan=new Scanner(System.in);
			String line="";
			new Thread(new ServerHandler(socket)).start();
			while(socket.isConnected()){
				line=scan.nextLine();
				pw.println(line);	
			}				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client=null;
		
		try{
			client=new Client();
			client.gui();
			client.start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("客户端运行失败");
		}
	}
	private void gui() {
		//	ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
		  //ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
		 // ImageIcon rightButtonIcon = createImageIcon("images/left.gif");
			System.out.println("start to paint the gui.");
			JPanel panel=new JPanel();
			panel.setLayout(null);
			this.setBounds(0,0,630,500);
				
		    b1 = new JButton("Disable middle button");
		    b1.setVerticalTextPosition(AbstractButton.CENTER);
		    b1.setBounds(0,400,200,50);
		    b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
		    b1.setMnemonic(KeyEvent.VK_D);
		    b1.setActionCommand("disable");
		    panel.add(b1);
		   
		    b2 = new JButton("Middle button");
		    b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		    b2.setLocation(210, 400);
		    b2.setSize(200,50);
		    b2.setHorizontalTextPosition(AbstractButton.CENTER);
		    b2.setMnemonic(KeyEvent.VK_M);
		    panel.add(b2);
		    
		    b3 = new JButton("Enable middle button");
	
		    b3.setLocation(420, 400);
		    b3.setSize(200,50);
		    b3.setMnemonic(KeyEvent.VK_E);
		    b3.setActionCommand("enable");
		    b3.setEnabled(false);
		    panel.add(b3);

		    this.setContentPane(panel);
		    this.setAlwaysOnTop(true);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setVisible(true);
		    
		    //Listen for actions on buttons 1 and 3.
		    ActionListener l=new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if ("disable".equals(e.getActionCommand())) {
				        b2.setEnabled(false);
				        b1.setEnabled(false);
				        b3.setEnabled(true);
				    } else {
				        b2.setEnabled(true);
				        b1.setEnabled(true);
				        b3.setEnabled(false);
				    }
				}
		    };
		    b1.addActionListener(l);
		    b3.addActionListener(l);

		    b1.setToolTipText("Click this button to disable "
		                      + "the middle button.");
		    b2.setToolTipText("This middle button does nothing "
		                      + "when you click it.");
		    b3.setToolTipText("Click this button to enable the "
		                      + "middle button.");
	}
	/*
	 * 该线程负责读取服务端发送过来的所有消息并输出的控制台。
	 */
	private class ServerHandler implements Runnable{
		private Socket socket;
		private BufferedReader br=null;
		public ServerHandler(Socket socket){
			this.socket=socket;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		public void run() {
			String message="";
			try {
				while(true){
					message = br.readLine();
					System.out.println(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}