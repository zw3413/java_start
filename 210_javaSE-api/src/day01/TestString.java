package day01;



public class TestString {

	public static void main(String[] args) {
		
		testConstantPool();
		//testString();
		//testTrim();
//		testCharAt();
//		testStartWithAndEndWith();
//		testToUpperCaseAndToLowerCase();
	//	testValueOf();
	}

	public static void testConstantPool(){
		String str1="Hello";
		String str2="Hello";//str1 和str2 两个字符串引用都指向了常量池中的 "hello"
		System.out.println("str1==str2:"+(str1==str2));
		String str3=new String("Hello");//str3重新开辟了内存空间。
		System.out.println("str1==str3:"+(str1==str3));
	}
	public static void testString(){
		String str="http://www.oracle.com";
		String subString=str.substring(11, 17);
		System.out.println(subString);
		String subStr=str.substring(7);
		System.out.println(subStr);
	}
	public static void testTrim(){
		String str="good man";
		StringBuilder sb=new StringBuilder(str);
		sb.append('\u0030');
		str=sb.toString();
		System.out.println(str);
		System.out.println(str.length());
		String trimStr=str.trim();
		System.out.println(trimStr);
		System.out.println(trimStr.length());
	}
	public static void testCharAt(){
		String str="whatisjava?";
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			System.out.print(c+" ");
		}
	}
	public static void testStartWithAndEndWith(){
		String str="Thinking in java";
		Boolean b=str.startsWith("T");
		System.out.println(b);
		b=str.endsWith("java");
		System.out.println(b);
	}
	public static void testToUpperCaseAndToLowerCase(){
		String str="我喜欢java";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
	}
	public static void testValueOf(){
		double pi=3.1415;
		String str=String.valueOf(pi);
		System.out.println(str);
	}
	
}
