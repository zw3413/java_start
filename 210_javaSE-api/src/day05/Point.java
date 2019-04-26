package day05;
/**
 * 使用该类测试作为集合元素对自定义元素的排序
 * @author soft01
 */
public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
	public Point() {

	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		
		return "("+x+","+y+")";
	}
	
	/*
	 * 实现Comparable接口后需要重写方法 compareTo
	 * 该方法是用来定义当前对象（this）与参数（o）之间的大小关系。
	 * 返回值不管主具体值，只关注取值范围；
	 * 当返回值>0：当前对象大于参数对象（this>o)
	 * 当返回值<0：当前对象小于参数对象
	 * 当返回值=0：两个对象相等
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Point o) {
		/*
		 * 点到原点距离长的大
		 */
		int len=(this.x*this.x+this.y*this.y)-(o.x*o.x+o.y*o.y);
		return len;
	}
	
}
