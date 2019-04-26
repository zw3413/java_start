package day10;
/**
 * 互斥锁
 * synchronized修饰不同的代码片段，当同步监视器对象是相同的时候，
 * 这些代码片段之间就是互斥的。
 * 多个线程不能同时进到这些代码片段中一起执行。
 * @author soft01
 *
 */
public class SyncDemo4 {
	static Boo boo=new Boo();
	public static void main(String[] args) {
		Thread t1=new Thread(){
			public void run(){
				boo.methodA();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized void methodA(){
		try{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+":start the methodA()");
			Thread.sleep(5000);
			System.out.println(t.getName()+":end the methodA()");
		}catch(Exception e){
		}
	}
	public synchronized void methodB(){
		try{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+":start the methodB()");
			Thread.sleep(5000);
			System.out.println(t.getName()+":end the methodB()");
		}catch(Exception e){
		}
	}
}