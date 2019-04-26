package day10;
/**线程提供了一个方法
 * 
 * void join()
 * 该方法允许一个线程在另一个线程上等待，直到其完成工作后才接触阻塞继续运行
 * 所以join可以协调线程之间同步运行
 * 
 * 同步与异步
 * 同步运行指代码运行是有先后顺序的执行
 * 异步运行指代码与代码间是“各干各的”，互不影响。
 * 
 * 多线程并发是异步运行代码的。但是有时候又需要这些线程间的代码同步运行时可以使用join完成线程间的同步。
 * 
 * 
 * 
 */
public class Thread_join {
	
	public static boolean isFinish=false;
	public static void main(String[] args) {
		final Thread download=new Thread(){
			public void run(){
				System.out.println("download:start the downloading.");
				for(int i=0;i<100;i++){
					System.out.println("download:downloading "+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("download:download complete.");
				isFinish=true;
			}
		};
		Thread show=new Thread(){
			public void run(){
				System.out.println("show:start to show the image.");
				try {
					/*
					 * 当show线程调用download.join()方法后，就进入了阻塞状态。
					 * 直到download执行完毕才会接触阻塞继续运行后续代码。
					 * 
					 */
					download.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!isFinish){
					throw new RuntimeException("show:image is not finished downloading.");
					
				}
				System.out.println("show:Show complete.");
			}
		};
		
		download.start();
		show.start();
		
		
	}
}
