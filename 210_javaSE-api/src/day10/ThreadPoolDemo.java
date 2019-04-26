package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要解决两个问题：
 * 1.控制线程数量
 * 	每条线程都需要占用一部分内存，线程数量越多占用内存资源越多，并且线程多了以后cpu轮询时间
 * 	会变长形成cpu过度切换。这些都会导致系统变慢，甚至瘫痪。
 * 2.重用线程
 * 	频繁创建销毁线程也会给线程调度带来负担。尽量重用线程，减小系统开销 
 * @author soft01
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadpool=Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			
			Runnable r=new Runnable(){
				public void run(){
					Thread t=Thread.currentThread();
					try{
						System.out.println(t.getName()+" is executing task.");
						/*
						 * 当线程在阻塞状态下被中断，会抛出中断异常。
						 */
						Thread.sleep(3000);
						System.out.println(t.getName()+" finished the executation.");
					}catch(Exception e){
						System.out.println("Exception: "+t.getName()+" was interrupted.");
					}
				}
			};
			System.out.println("assign a thread to the threadpool.");
			threadpool.execute(r);
		}
		
		threadpool.shutdownNow();
		System.out.println(threadpool.getClass().getName()+" is shutdownNow.");
	}

}
