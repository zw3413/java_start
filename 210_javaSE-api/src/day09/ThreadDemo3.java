package day09;
/**
 * 
 * 使用匿名内部类完成线程的创建
 * @author soft01
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("我要查水表！");
				}
			}
		};
		
		Thread t2=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你要干嘛?");
				}
			}
		};
		t1.start();
		t2.start();
	}
}
