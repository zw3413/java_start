package day09;
/**
 * 多线程
 * 多线程允许多段代码“同时”（并发）运行。
 * 
 * 创建线程有两种方式，方式一：
 * 继承Thread并重写run方法。
 * @author soft01
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		
		Thread mt1=new MyThread1();
		Thread mt2=new MyThread2();
		/*
		 * 启动县城调用start方法。不要直接调用run（）方法。
		 * 当start方法执行完毕后，线程纳入线程调度，一旦该线程获取cpu时间片开始运行时
		 * 会自动调用自己的run方法开始工作
		 */
		mt1.start();
		mt2.start();

	}
}
/**
 * 第一种创建线程的方式有两个不足：
 * 1：由于java是单继承，这就导致继承了Thread就不能再继承其他类。实际开发中会导致诸多不便。
 * 2：由于将run方法重写，把线程要执行的任务代码定义在了run方法中，就导致该线程与任务有一个必然的耦合关系。不利于线程的重用。
 * 
 * @author soft01
 *
 */
class MyThread1 extends Thread{
	private int count=0;
	private int num=1;
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println(num+" "+count++ +":我是查水表的！");
		}
	}
}
class MyThread2 extends Thread{
	private int count=0;
	private int num=2;
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println(num+" "+count++ +":你是谁啊？");
		}
	}
}