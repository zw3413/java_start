package shootgame;

public class Bullet extends FlyingObject{
	
	private int speed=10;
	
	public Bullet(int x, int y) {
		super(x, y);
		image=ShootGame.bullet;
	
	}
	
	public Bullet(){
		super(0,0);
		image=ShootGame.bullet;
	}
	
	@Override
	public void step() {
		y-=speed;
		
	}
	
	public boolean outOfBounds(){
		if(this.y<0){
			return true;
		}else{
			return false;
		}
	}
	public boolean hit(FlyingObject f){
		int x=f.getX();
		int y=f.getY();
		return this.x>x && this.x<x+f.getWidth()&& this.getY()>y&&this.getY()<y+f.getHeight();
	}
	
}
