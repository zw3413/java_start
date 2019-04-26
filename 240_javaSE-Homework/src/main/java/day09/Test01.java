package day09;
/**
 * 使用线程方式一创建两个线程:分别输出1000次，你好和再见
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {

		for(int i=0;i<1000;i++){
			Thread t1= new Thread1();
			Thread t2=new Thread2();
			t1.start();
			t2.start();
		}
	}
}
class Thread1 extends Thread{
	public void run(){
		System.out.println("hello");
	}
}
class Thread2 extends Thread{
	public void run(){
		System.out.println("bye-bye");
	}
}
