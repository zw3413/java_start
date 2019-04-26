package com.zhangwei.core;

import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class HitTheGuy extends JPanel {

	private static BufferedImage background;
	private static BufferedImage seat;
	private static BufferedImage animal1;
	private static BufferedImage animal2;
	private static BufferedImage animal3;
	
	static{
		try{
			background=ImageIO.read(HitTheGuy.class.getResource("background.png"));
			seat=ImageIO.read(HitTheGuy.class.getResource("seat.png"));
			animal1=ImageIO.read(HitTheGuy.class.getResource("animal1.png"));
			animal2=ImageIO.read(HitTheGuy.class.getResource("animal2.png"));
			animal3=ImageIO.read(HitTheGuy.class.getResource("animal3.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	{
		
	}
	public HitTheGuy(){
		
		
	}
	
	public static void main(String[] args) {
		
		HitTheGuy hit=new HitTheGuy();
		JFrame frame=new JFrame("打坏蛋");
		frame.setSize(750, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		MenuBar menubar=hit.initMenuBar();
		
		frame.setMenuBar(menubar);
		frame.add(hit);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		hit.action();
	}

	/**
	 * 创建菜单栏
	 * @return
	 */
	private  MenuBar initMenuBar() {
		MenuBar menubar=new MenuBar();
		Menu m1=new Menu("打坏蛋");
		MenuItem m11=new MenuItem("新游戏");
		MenuItem m12=new MenuItem("保存游戏");
		MenuItem m13=new MenuItem("加载游戏");
		MenuItem m14=new MenuItem("退出");
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		m1.addSeparator();
		m1.add(m14);
		Menu m2=new Menu("帮助");
		MenuItem mh1= new MenuItem("操作方法");
		MenuItem mh2= new MenuItem("关于");
		m2.add(mh1);
		m2.addSeparator();
		m2.add(mh2);
		menubar.add(m1);
		menubar.add(m2);
		return menubar;
	}
	/**
	 * 绘制初始界面
	 */
	public void paint(Graphics g){
		g.drawImage(background, -200, 0, null);
		g.drawImage(seat, 50, 120, null);
		g.drawImage(seat,520, 120, null);
		g.drawImage(seat, 300, 120, null);
		g.drawImage(seat, 50, 300, null);
		g.drawImage(seat,520, 300, null);
		g.drawImage(seat, 300, 300, null);
		g.drawImage(seat, 50, 500, null);
		g.drawImage(seat,520, 500, null);
		g.drawImage(seat, 300, 500, null);
	}
	
	
	
	private void action(){
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			public void run() {

				
				
			}
		}, 10);
		
		
		
		
	}
}
