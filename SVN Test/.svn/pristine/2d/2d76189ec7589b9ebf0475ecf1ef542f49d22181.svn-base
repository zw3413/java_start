package day01;
/**
 * 1:输出字符串"HelloWorld"的字符串长度
 * 2:输出"HelloWorld"中"o"的位置
 * 3:输出"HelloWorld"中从下标5出开始第一次出现"o"的位置
 * 4:截取"HelloWorld"中的"Hello"并输出
 * 5:截取"HelloWorld"中的"World"并输出
 * 6:将字符串"  Hello   "中两边的空白去除后输出
 * 7:输出"HelloWorld"中第6个字符"W"
 * 8:输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
 * 9:将"HelloWorld"分别转换为全大写和全小写并输出。
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		String str = "HelloWorld";
		String str1 = "  Hello   ";
		test1(str);
		//以下自行调用test2,test3...等方法。
		test2(str);
		test3(str);
		test4(str);
		test5(str);
		test6(str1);
		test7(str);
		test8(str);
		test9(str);
	}
	/**
	 * 以当前方法为例，下面继续编写test2,test3...等方法。
	 * 每个方法中实现类描述中的一个需求。
	 * 当前方法实现:1输出字符串"HelloWorld"的字符串长度
	 * 
	 * test2实现:2:输出"HelloWorld"中"o"的位置
	 * 以此类推。
	 * @param str
	 */
	public static void test1(String str){
		System.out.println("len:"+str.length());
	}
	/**
	 * 输出str中"o"的位置
	 * @param str
	 */
	public static void test2(String str){
		System.out.println("index of 'o':"+str.indexOf('o'));
	}
	/**
	 * 输出"HelloWorld"中从下标5出开始第一次出现"o"的位置
	 */
	public static void test3(String str){
		System.out.println("index of 'o':"+str.indexOf('o',5));
	}
	/**
	 * 截取"HelloWorld"中的"Hello"并输出
	 */
	public static void test4(String str){
		System.out.println("sub:"+str.substring(0, 5));
	}
	/**
	 * 截取"HelloWorld"中的"World"并输出
	 * @param str
	 */
	public static void test5(String str){
		System.out.println("sub:"+str.substring(5));
	}
	/**
	 * 将字符串"  Hello   "中两边的空白去除后输出
	 * @param str
	 */
	public static void test6(String str){
		System.out.println("trim:"+str.trim());
	}
	/**
	 * 输出"HelloWorld"中第6个字符"W"
	 * @param str
	 */
	public static void test7(String str){
		System.out.println("charAt:"+str.charAt(5));
	}
	/**
	 * 输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
	 * @param str
	 */
	public static void test8(String str){
		System.out.println("startsWith:"+str.startsWith("h"));
		System.out.println("endsWith:"+str.endsWith("ld"));
	}
	/**
	 * 将"HelloWorld"分别转换为全大写和全小写并输出。
	 * @param str
	 */
	public static void test9(String str){
		System.out.println("upper:"+str.toUpperCase());
		System.out.println("lower:"+str.toLowerCase());
	}
	
}
