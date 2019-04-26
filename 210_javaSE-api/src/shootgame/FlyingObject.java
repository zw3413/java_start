package shootgame;
import java.awt.image.BufferedImage;
import java.util.Random;


public abstract class FlyingObject implements Enemy {
	
	protected int x;// protected: 访问权限为：本类，本包，子类
	protected int y;
	protected int width;
	protected int height;
	protected int speed;
	protected BufferedImage image;
	private int score=3;
	Random rand=new Random();
	
	public FlyingObject(){
		x=0;
		y=0;
	}
	public FlyingObject(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public abstract void step();
	public abstract boolean outOfBounds();
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}
	

}
