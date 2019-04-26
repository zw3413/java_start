package mytest;


public class StaticBlockTest {

	
	static{
		System.out.println("static block was excuted.");
	}
	public StaticBlockTest(){
		System.out.println("contructer was excuted");
	}
	
	public static void main(String[] args) {

		
		System.out.println("main was excuted");
		StaticBlockTest s1=new StaticBlockTest();
		StaticBlockTest s2=new StaticBlockTest();
		Outer o1=new Outer(1);
		Outer o2=new Outer(1);
		for(;;){
			System.out.println("1");
		}
	}

}
