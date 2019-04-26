package shootgame;

public class Airplane extends FlyingObject implements Enemy {

	private int speed=3;
	
	public Airplane(int x,int y){
		super(x,y);
		image=ShootGame.airplane;
		super.width=image.getWidth();
		super.height=image.getHeight();
	}
	
	public void step(){
		y+=speed;
	}
	
	public int getScore(){
		
		return 0;
	}
	
	public boolean outOfBounds(){
		if(this.y>ShootGame.HEIGHT){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
}
