package day10;
/**
 * 静态方法使用synchronized修饰后，该方法一定具有同步效果
 * 
 * 静态方法上使用synchronized修饰后，同步监视器对象是当前类的类对象。
 * JVM在加载每个类的时候，都会实例化一个且只实例化一个Class类型的实例来描述这个类。
 * 而静态方法锁的就是这个对象。
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1=new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
	t1.start();
	t2.start();
	}
}


class Foo{
	public synchronized static void dosome(){
		Thread t=Thread.currentThread();
		try{
			System.out.println(t.getName()+": 正在调用dosome方法");
			Thread.sleep(5000);
			System.out.println(t.getName()+": dosome方法运行完毕！");
		}catch(Exception e){
		
		}
}}