package day10;
/**
 * 多线程并发安全问题
 * 由于线程之间运行是异步的，互相没有牵制，但如果同时访问一个资源时就出现了“抢”的现象。
 * 由于线程发生切换现象的实际不确定
 * 导致代码执行顺序可能未能按照设计的顺序执行，出现一系列不可预知的后果。
 * @author soft01
 *
 */
public class SyncDemo {
	static Table table=new Table();
	public static void main(String[] args) {
		
	
	Thread t1=new Thread(){
		public void run(){
			while(true){
			int bean=table.getBean();
		
			System.out.println(getName()+":"+bean);
		}}
	};
	Thread t2=new Thread(){
		public void run(){
			while(true){
			int bean=table.getBean();

			System.out.println(getName()+":"+bean);
		}}
	};
	
	t1.start();
	t2.start();
	
	}
}


class Table{
	private  int beans=20;
	/*
	 * 当一个方法被synchronized修饰后，该方法成为同步方法，即：多个线程不能同时
	 * 进入到方法的内部去执行代码，这样就不会同时对bens这个数据进行操作，没有抢的问题。
	 * 就不会出现并发安全问题了
	 * 
	 * 在一个方法上使用synchronized修饰，那么同步监视器对象就是该方法所属对象，
	 * 即方法内部看到的this
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("bean number is 0.");
		}
		Thread.yield();
		return beans--;
	}	}