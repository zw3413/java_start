package day09;
/**
 * 线程的优先级
 * 
 * 线程优先级有10个等级，分别用整数1-10表示。
 * 其中1最低，10最高，5为默认优先级。
 * 
 * 由于线程不能干涉线程调度工作，即：不能主动获取CPU时间，也不能决定时间片长短。
 * 所以只能通过调整优先级来最大程度改善获取CPU时间片的几率。
 * 理论上线程优先级越高的线程，获取CPU时间片的次数就越多。
 * 
 * @author soft01
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		
		Thread min=new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread nor=new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("nor");
				}
			}
		};
		Thread max=new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		
		min.start();
		nor.start();
		max.start();
		
		
		
		
	}
}
