package day06;

public class AndOrTest {
	public static void main(String[] args) {
		//'中'的unicode是“0x4E2D”
		int c=0x4e2d;
		int m=0x3f;
		int k=c&m;
		
		int f=0x80;
		int b3=k|f;
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(0x80|c&0x3f));
	
	
	}
}
