package com.transfer;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class GUI extends JFrame{
	
	private JPanel panel=null;
	private JLabel lChoose=null;
	private JLabel lConnect=null;
	private Transfer transfer=null;
	private JEditorPane eMessage=null;
	private JButton bMessage=null;
	
	public GUI(Transfer transfer){
		this.transfer=transfer;
		setBounds(0,0,500,500);
		setBackground(new Color(1,1,1));
		setJMenuBar(menuBar());
		setContentPane(setPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	private JMenuBar menuBar() {
		JMenuBar menuBar=new JMenuBar();
		menuBar.add(menuSetting());
		menuBar.setVisible(true);
		
		return menuBar;
	}

	private JMenu menuSetting() {
		JMenu menuSetting= new JMenu();
		menuSetting.setText("设置");
		menuSetting.add(miNet());
		
		return menuSetting;
	}


	private JMenuItem miNet() {
		JMenuItem m=new JMenuItem();
		m.setText("设置网络");
		
		ActionListener l=new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				JPanel panel=new JPanel();
				JLabel lable=new JLabel("清将 8088 添加进防火墙中。");
				panel.add(lable);
				panel.setBounds(0, 0, 300, 300);
				panel.setVisible(true);
				
				
			}

			private Object setPanel1() {
				JPanel panel=new JPanel();
				
				
				return panel;
			}
			
		};
		
		
		m.addActionListener(l);
		
		
		return m;
	}

	private JPanel setPanel() {
		panel=new JPanel();
		panel.setLayout(null);
		panel.add(setButtonChooseFile());
		panel.add(setLabelChooseFIle());
		panel.add(setButtonConnect());
		panel.add(setLabelConnect());
		panel.add(setButtonSend());
		
		panel.add(setLableMessage());
		panel.add(setButtonMessage());
		
		return panel;
	}

	private Component setButtonMessage() {
			bMessage=new JButton("发送信息");
			bMessage.setBounds(360,300,100,50);
			return bMessage;
	}
//50, 250, 300, 100
	private Component setLableMessage() {
		 eMessage =new JEditorPane();
		 eMessage.setBounds(50, 250, 300, 100);
	//	eMessage.setBorder(border);
		return eMessage;
	}
//50, 150, 100, 30
	private Component setButtonSend() {
		JButton bSend=new JButton(); 
		bSend.setText("发送文件");
		bSend.setBounds(50, 150, 100, 30);
		
		ActionListener l=new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				Thread t=new Thread(new Sender(transfer));
				t.setDaemon(true);
				t.start();
			}
		};
		bSend.addActionListener(l);
		return bSend;
	}
//210,100,300,30
	private Component setLabelChooseFIle() {
		lChoose=new JLabel("请选择文件");
		lChoose.setBounds(210,100,300,30);
		return lChoose;
	}
//50, 100, 100, 30
	private Component setButtonChooseFile() {
		JButton bChoose=new JButton();
		bChoose.setBounds(50, 100, 100, 30);
		bChoose.setText("选择文件");

		ActionListener l =new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fileChoosing();
				update();
		}};
		bChoose.addActionListener(l);
		return bChoose;
	}
	//210, 50, 300, 30
	private Component setLabelConnect() {
		lConnect=new JLabel();
		lConnect.setText("还未连接");
		lConnect.setBounds(210, 50, 300, 30);
		return lConnect;
	}
//50, 50, 100, 30
	private Component setButtonConnect() {
		JButton bConnect=new JButton(); 
		bConnect.setText("连接");
		bConnect.setBounds(50, 50, 100, 30);
		ActionListener l=new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(transfer.connectServer()){
					System.out.println("连接成功");
					lConnect.setText("连接成功");
					Thread t=new Thread(new Receiver(transfer));// listening thread start.
					t.setDaemon(true);//except the GUI thread, all other threads are daemon.
					t.start();
				}else{
				System.out.println("连接失败");
				lConnect.setText("连接失败");
				}
			}
		};
		bConnect.addActionListener(l);
		return bConnect;
	}
	
	private void fileChoosing() {
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & GIF Images", "jpg", "gif","txt","zip","tar.gz");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	transfer.setFile(chooser.getSelectedFile());
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
	}
	
	private void update(){
		lChoose.setText(transfer.file.getAbsolutePath());
		
	}
	
	public static void main(String[] args) {
		Transfer transfer=null;
		try{
			transfer=new Transfer();
			
		}catch(Exception e){
			
		}
		GUI gui=new GUI(transfer);
		transfer.setGui(gui);
	
	}

	
	
	
}