package day10;
/**
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能的提高并发效率
 * @author soft01
 *
 */
public class SyncDemo2 {
	static Shop  shop=new Shop();
	public static void main(String[] args) {
		Thread t1=new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}
class Shop{
	
	public  void buy(){
		Thread t= Thread.currentThread();
		try{
		System.out.println(t.getName()+": select the clothes.");
		Thread.sleep(5000);
		/*
		 *同步块可以更精确的指定需要同步的代码段。
		 *
		 * 若希望多个线程同步执行里面的代码，就需要在同步块中指定的”同步监视器“
		 * (即：上锁对象）必须是同一个才可以
		 * 
		 * 这里由于t1，t2调用的是统一个shop的buy方法，所以这里两个线程看到的this都是这个shop对象
		 * 那么这个同步块就具备了同步效果
		 */
		synchronized(this){
		System.out.println(t.getName()+": try the clothes.");
		Thread.sleep(5000);
		}
		System.out.println(t.getName()+": do the payment and leave.");
		}catch(Exception e){
		}
	}
}









