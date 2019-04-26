package day06;

public class AndTest {
	public static void main(String[] args) {
		int n=-4;
		int m= ~n+1;
		System.out.println("原数:"+n);
		System.out.println("原码形式："+Integer.toBinaryString(n));
		System.out.println("取反加1："+m);
		System.out.println("补码形式："+Integer.toBinaryString(m));
		
		
	}
}
