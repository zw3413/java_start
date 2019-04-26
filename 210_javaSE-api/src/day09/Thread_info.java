package day09;
/**
 * 获取线程相关信息的方法
 * @author soft01
 */
public class Thread_info {
	public static void main(String[] args) {
		//获取运行main方法的线程
		Thread t=Thread.currentThread();
		//获取线程的名字
		String name=t.getName();
		System.out.println("name:"+name);
		//获取线程ID（唯一标识）
		long id=t.getId();
		System.out.println("id:"+id);
		//线程优先级
		int priority=t.getPriority();
		System.out.println("优先级:"+priority);
		//是否还活着
		boolean isAlive=t.isAlive();
		//是否是守护线程
		boolean isDaemon=t.isDaemon();
		//是否被中断
		boolean isInterrupted=t.isInterrupted();
		System.out.println("isAlive:"+isAlive);
		System.out.println("isDaemon:"+isDaemon);
		System.out.println("isInterrupted:"+isInterrupted);
	}
}
