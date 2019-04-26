package shootgame;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class ShootGame extends JPanel{
	
	public static BufferedImage bee;
	public static BufferedImage airplane;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage background;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage bullet;
	
	public static int timerInterval=10;
	
	public FlyingObject[] flyings={};
	public Bullet[] bullets=new Bullet[2];
	
	public Hero hero=new Hero();
	public int score=0;
	public ShootGame(){
		bullets[0]=new Bullet();
		bullets[1]=new Bullet();
	}
	
	static{
		
		try {
			bee=ImageIO.read(ShootGame.class.getResource("bee.png"));
			airplane=ImageIO.read(ShootGame.class.getResource("airplane.png"));
			hero0=ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1=ImageIO.read(ShootGame.class.getResource("hero1.png"));
			background=ImageIO.read(ShootGame.class.getResource("background.png"));
			pause=ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover=ImageIO.read(ShootGame.class.getResource("gameover.png"));
			bullet=ImageIO.read(ShootGame.class.getResource("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final int WIDTH= 400;
	public static final int HEIGHT= 654;
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly");
		ShootGame game=new ShootGame();
		frame.add(game);
		frame.setSize(WIDTH,HEIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("/images/icon.png").getImage());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.action();
	}
	
	
	public void action(){
		
		MouseAdapter l= new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				hero.setX(e.getX()-hero.getWidth()/2);
				hero.setY(e.getY()-hero.getHeight()/2);
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				
				enterAction();
				stepAction();
				shootAction();
				outOfBoundsAction();
				bangAction();
				
				repaint();
			}
		}, timerInterval,timerInterval);}
	
	private int enterIndex=0;
	public void enterAction(){
		
		if(enterIndex++%100==0){
			int x,y;
			Random rand=new Random();
			int r=rand.nextInt(20);		
			if(r<4){
				x=(WIDTH-bee.getWidth())*rand.nextInt(100)/100;
				y=0;
				FlyingObject f=new Bee(x,y);
				flyings=Arrays.copyOf(flyings,flyings.length+1);
				flyings[flyings.length-1]=f;
			}else{
				x=(WIDTH-airplane.getWidth())*rand.nextInt(100)/100;
				y=0;
				FlyingObject f=new Airplane(x,y);
				flyings=Arrays.copyOf(flyings,flyings.length+1);
				flyings[flyings.length-1]=f;
			}
		}
	}
	private int stepIndex=0;
	public void stepAction(){
		
		if(stepIndex++%20==0){
			hero.imageUpdate();
		}
		if(stepIndex++%3==0){
			for(int i=0;i<flyings.length;i++){
				flyings[i].step();
			}
			for(int i=0;i<bullets.length;i++){
				bullets[i].step();
			}
			
		}
	}
	int shootIndex=0;
	public void shootAction(){
		if(shootIndex++%30==0){
		bullets=hero.shoot(bullets);
	}}
	public void outOfBoundsAction(){
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].outOfBounds()){
				FlyingObject t=flyings[flyings.length-1];
				flyings[flyings.length-1]=flyings[i];
				flyings[i]=t;
				flyings=Arrays.copyOf(flyings,flyings.length-1);
			}
		}
		for(int i=0;i<bullets.length;i++){
			if(bullets[i].outOfBounds()){
				Bullet t=bullets[bullets.length-1];
				bullets[bullets.length-1]=bullets[i];
				bullets[i]=t;
				bullets=Arrays.copyOf(bullets, bullets.length-1);
				
			}
			
		}
		
		
		
		
		
	}
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){
			for(int j=0;j<flyings.length;j++){
				if(bullets[i].hit(flyings[j])){
					//remove the hitted flying and the bullet
					
					score+=flyings[j].getScore();
					
					Bullet tb=bullets[bullets.length-1];
					bullets[bullets.length-1]=bullets[i];
					bullets[i]=tb;
					bullets=Arrays.copyOf(bullets, bullets.length-1);
					
					FlyingObject tf=flyings[flyings.length-1];
					flyings[flyings.length-1]=flyings[j];
					flyings[j]=tf;
					flyings=Arrays.copyOf(flyings, flyings.length-1);
					
					//System.out.println("hitted");
				}
			}
		}
	}

	public void paint(Graphics g){
		g.drawImage(ShootGame.background,0,0,null);
		paintHero(g);
		paintFlyingObject(g);
		paintBullet(g);
	}
	public void paintHero(Graphics g){
		g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
	}
	public void paintFlyingObject(Graphics g){
		for(int i=0;i<flyings.length;i++){
		g.drawImage(flyings[i].getImage(),flyings[i].getX(),flyings[i].getY(),null);
		}
	}
	public void paintBullet(Graphics g){
		for(int i=0;i<bullets.length;i++){
			g.drawImage(bullets[i].getImage(),bullets[i].getX(),bullets[i].getY(),null);
		}
	}
}
