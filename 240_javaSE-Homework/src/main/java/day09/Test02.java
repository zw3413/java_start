package day09;
/**
 * 使用线程方式二创建两个线程:分别输出1000次，你好和再见
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		
		for(int i=0;i<1000;i++){
			Runnable r1=new Runnable1();
			Runnable r2=new Runnable2();
			Thread t1=new Thread(r1);
			Thread t2=new Thread(r2);
			t1.start();
			t2.start();
		}
	}
}

class Runnable1 implements Runnable{

	public void run() {
		System.out.println("hello");
	}
	
}
class Runnable2 implements Runnable{

	public void run() {
		System.out.println("bye-bye");
	}
	
}
