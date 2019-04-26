package day02;

public class String_replace {

	public static void main(String[] args) {
		String str="wqnmlgb!你这个sb!你怎么这么nc!tmd!";
		String regex="wqnmlgb|cnm|nc|tmd|mdzz|mmp|djb|sb";
		System.out.println(str);
		str=str.replaceAll(regex,"***");
		System.out.println(str);
		
	}
}
