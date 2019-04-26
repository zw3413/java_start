package day02;
/**
 * 
 * 包装类提供了一个静态方法
 * parseXXX(String str)
 * 可以将给定的字符串转换为对应的基本数据类新数据。
 * 但是前提是该字符串描述的数据能被该基本类型保存。
 * 
 * @author soft01
 *
 */
public class Integer_parseInt {

	public static void main(String[] args) {
		String str="125.123";
		int i=Integer.parseInt(str);
		System.out.println(i);

	}

}
