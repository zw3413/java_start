package shootgame;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Hero {

	private int life;
	private int doubleFire=40;
	private BufferedImage image=ShootGame.hero0;
	private int width=image.getWidth();
	private int height=image.getHeight();
	private int x;
	private int y;
	private int xStep=this.width/4;
	private BufferedImage[] images=new BufferedImage[2];
	private int imageFlag=0;
	
	public int getXStep(){
		return xStep;
	}
	
	public void reduceDoubleFire(){
		
		doubleFire-=2;
	}
	
	public Hero(){
		x=(ShootGame.WIDTH-image.getWidth())/2;
		y=ShootGame.HEIGHT-image.getHeight()-150;
	}
	
	public void imageUpdate(){
		if(imageFlag==0){
			imageFlag=1;
			image=ShootGame.hero1;
		}else{
			imageFlag=0;
			image=ShootGame.hero0;
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public BufferedImage getImage(){
		return image;
	}
	
	public void step(){
		
	}
	public int getFire(){
		return doubleFire;
	}
	public Bullet[] shoot(Bullet[] bullets){
		if(doubleFire>0){
			Bullet b1=new Bullet(this.x+this.xStep,this.y);
			Bullet b2=new Bullet(this.x+3*this.xStep,this.y);
			bullets=Arrays.copyOf(bullets, bullets.length+2);
			bullets[bullets.length-2]=b1;
			bullets[bullets.length-1]=b2;
			return bullets;
		}else{
			Bullet b=new Bullet(this.x+2*this.xStep,this.y);
			bullets=Arrays.copyOf(bullets, bullets.length+1);
			bullets[bullets.length-1]=b;
			return bullets;
		}
	}
	
	public void addLife(){
		life++;
	}
	public void addDoubleFire(){
		doubleFire++;
	}
}
