package day09;
/**
 * 
 * 第二种创建线程的方式
 * 实现Runnable接口单独定义任务
 * @author soft01
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		
		Runnable r1=new MyRunnable1();
		Runnable r2=new MyRunnable2();
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		
		t1.start();
		t2.start();
	}
	
}

class MyRunnable1 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}
class MyRunnable2 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的！");
		}
	}
}