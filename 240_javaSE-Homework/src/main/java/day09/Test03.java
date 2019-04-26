package day09;
/**
 * 使用匿名内部类方式创建两个线程:分别输出1000次，你好和再见
 * @author Xiloer
 *
 */
public class Test03 {
public static void main(String[] args) {
	for(int i=0;i<1000;i++){
	Thread t1=new Thread(){
		public void run(){
			System.out.println("hello");
		}
	};
	Thread t2=new Thread(){
		public void run(){
			System.out.println("bye-bye");
		}
	};
	t1.start();
	t2.start();}
}
}
