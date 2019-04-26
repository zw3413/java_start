package day01;
/*
 * String
 * 1. int indexOf(String)
 * 2. int indexOf(String,int)
 * 3. int lastIndexOf(String)
 * 4. int lastIndexOf(String,int)
 */
public class String_indexOf {

	public static void main(String[] args) {
		String str="I can because I think I can";
		int index;
		index=str.indexOf("can");
		System.out.println(index);
		
		index=str.indexOf("can",6);
		System.out.println(index);
		
		index=str.lastIndexOf("can");
		System.out.println(index);
		
		index=str.indexOf("Can",6);
		System.out.println(index);
		

	}

}
