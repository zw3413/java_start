package day04;
/**
 * 泛型 JDK1.5之后推出的一个特性。
 * 
 * 
 * @author soft01
 *
 */


public class Point<E> {
	private E x;
	private E y;
	public Point(E x, E y){
		super();
		this.x=x;
		this.y=y;
	}
	/*public E add(){
		return x+y;
	}*/
	public E getX() {
		return x;
	}
	public void setX(E x) {
		this.x = x;
	}
	public E getY() {
		return y;
	}
	public void setY(E y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
