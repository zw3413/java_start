package day01;

public class TestStringBuilder {

	public static void main(String[] args) {
		//StringBuilder str="javacppc#object-c";
		String str="Programming Language:";
		StringBuilder sb=new StringBuilder(str);
		sb.append("java").append("cpp").append("php").append("c#").append("objective-c");
		System.out.println(sb.toString());
		StringBuilder sb1=new StringBuilder("javacppc#objective-c");
		sb1.insert(9, "#");
		System.out.println(sb1.toString());
		StringBuilder sb2=new StringBuilder("javaoraclecppc#php");
		sb2.delete(4, 4+6);
		System.out.println(sb2);
	}
}

/**
 * StringBuilder
 * append()
 * replace()
 * insert()
 * delete()
 * 
 */
