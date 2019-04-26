package mytest;

public class Book{ 
	private String name; 
	private double price; 
	public Book(){ 
		this.name = "三国演义"; this.price = 70.5; 
		} 
	public Book(String name){ 
		this.name = name; 
		} 
	public Book(String name,double price){ 
		this(name); 
		this.price = price; 
		} 
	public static void main(String[] args){ 
		Book book = new Book("水浒传",60.5); 
		System.out.println(book.name); 
		System.out.println(book.price); 
		int[][]arr = new int[3][]; 
		System.out.println(arr[0]);
		String str1 = "TEDU"; 
		String str2 = "TEDU"; 
		String str3 = new String("TEDU"); 
		System.out.println(str1==str2); 
		System.out.println(str1==str3);

			StringBuilder str = new StringBuilder("abc"); 
			int result = getResult(str); 
			System.out.println(result);	  
	}
	public static int getResult(StringBuilder str){
		str.append("abc"); 
		str.delete(0,3); 
		str.insert(0, "abc"); 
		str.replace(0,3, "abc"); 
		return str.length(); }
		
	}