package day06;
/*
 * 数学右移位>> :
 * 其结果满足数学规律，
 * 整除向小方向取整，（除不尽，舍1）
 * 负数移位，高位补1，结果还是负数
 * 正数移位，高位补0，结果还是正数
 * 面试题目 
 * 优化计算机 n*=1.5;
 * n=n+n>>1
 * 
 * 
 * 逻辑右移位>>>：
 * 无论正负高位补0！
 * 用于编码解码
 * 
 */
public class MoveBitTest {
	public static void main(String[] args) {
		int i=50;
		System.out.println(Integer.toBinaryString(i)+" "+i);
		System.out.println(Integer.toBinaryString(i<<1)+" "+(i<<1));
		System.out.println(Integer.toBinaryString(i<<2)+" "+(i<<2));	
	}
}







