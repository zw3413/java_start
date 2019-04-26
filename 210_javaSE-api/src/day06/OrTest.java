package day06;

public class OrTest {
	public static void main(String[] args) {
		int n=0x80;
		int m=0x2b;
		int k=n|m;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(k));
	}
}
