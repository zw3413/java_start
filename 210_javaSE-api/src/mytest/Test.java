package mytest;

public class Test {
	String str=new String("tedu"); 
	char[]ch={'x','y','z'}; 
	public static void main(String args[]){ 
		Test t = new Test(); 
		t.change(t.str,t.ch); 
		System.out.print(t.str+"and"); 
		System.out.print(t.ch);} 
	public void change(String str,char ch[]){ 
		str="tarena"; 
		ch[0]='w';	
}
}