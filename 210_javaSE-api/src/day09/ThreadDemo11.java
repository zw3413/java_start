package day09;

public class ThreadDemo11 {

	public static void main(String[] args) {
		
		MyThread3 mt1=new MyThread3();
		MyThread4 mt2=new MyThread4();
		
		mt1.start();
		mt2.start();	
	}
	
}
class MyThread3 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("This is the thread 1");
		}
	}
}

class MyThread4 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("This is the thread 2");
		}
	}
}
