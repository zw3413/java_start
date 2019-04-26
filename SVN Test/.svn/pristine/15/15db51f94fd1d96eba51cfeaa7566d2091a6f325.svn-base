package day09;
/**
 * 使用线程方式二创建两个线程:分别输出1000次，你好和再见
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
class MyRunnable1 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你好");
		}
	}
}
class MyRunnable2 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("再见");
		}
	}
}