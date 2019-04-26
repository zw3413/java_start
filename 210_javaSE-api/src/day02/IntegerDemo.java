package day02;

/**
 * 包装类
 * java有8个基本类型，由于他们不是引用类型，不具有面向对象特性，所以不能直接参与面向对象的开发。
 * 为此Java对这8个基本类型分别提供了对应的包装类来解决问题。
 * 
 * 
 * int  java.lang.Integer  
 * long java.lang.Lang
 * short java.lang.Short
 * byte java.lang.Byte
 * char java.lang.Character
 * boolean java.lang.Boolean
 * float java.lang.Float
 * double java.lang.Double
 * 
 * java.lang.Number
 */

public class IntegerDemo {

	public static void main(String[] args) {
	/**
	 * 基本类型转换为包装类的时候不建议采用new的形式，
	 * 而应当使用包装类的静态方法：valueOf();
	 */
		Integer i1=Integer.valueOf(127);
		Integer i2=Integer.valueOf(127);
		
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		System.out.println(i1.intValue());
		
		Double dou=Double.valueOf(123.123);
		double dd=dou.doubleValue();
		System.out.println(dd);
		int d=dou.intValue();
		System.out.println(d);
		
		int iMax;
		iMax=Integer.MAX_VALUE;
		System.out.println(iMax);
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
	}

}
