package shootgame;

import java.awt.image.BufferedImage;

public class Bee extends FlyingObject implements Enemy,Award{
	
	private int speed=3;
	
	public Bee(int x,int y){
		super(x, y);
		image=ShootGame.bee;
		super.width=image.getWidth();
		super.height=image.getHeight();
		
	}
	public void step(){
		y+=speed;
	}
	public int getScore(){
		
		return 0;
	}
	@Override
	public void addLife(Hero h) {
		h.addLife();
	}
	@Override
	public void addDoubleFire(Hero h) {
		h.addDoubleFire();	
	}
	public boolean outOfBounds(){
		if(this.y>ShootGame.HEIGHT){
			return true;
		}else{
			return false;
		}
	}
}