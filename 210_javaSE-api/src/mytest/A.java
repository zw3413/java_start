package mytest;

public class A implements B { 
	int k = 20;
	private static int y; 
	public static void main(String args[]) { 
		int i; 
		B c1 = new A(); 
		i = c1.k; 
		System.out.println("i=" + i); 
		int x = 10; 
		x = x++ +10; 
		System.out.println(x);
		A1 a1=new A1();
		System.out.println(a1.y);
		int a = 0; do{ --a; }while(a>0); int b = 0; while(b>0){ --b; } System.out.print(a); System.out.print(b);
		
		System.out.println();
		String str1="wo";
		String str2="wo";
		System.out.println(str1==str2);
		
		B1 b1=new B1(5);
		System.out.println(b1.num);
		} 
	} 
interface B { 
	int k = 10; 
	}

class A1{  
	private int x=0; 
	static int y=1;  
	protected int z=2;  
	}  
class B1 extends A1{  
	int num;
	B1(int num){
		num=num;
	}
	void method(){  
		//System.out.println(x); 
		System.out.println(y);  
		System.out.println(z);  
		}  }