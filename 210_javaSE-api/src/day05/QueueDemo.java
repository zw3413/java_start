package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列
 * 队列可以存放一组元素，存取元素必须遵循：FIFO
 * 即：First Input First Output 先进先出 
 *
 *Queue接口继承自Collection
 * @author soft01
 *
 */
public class QueueDemo {
	
	public static void main(String[] args) {

		Queue<String> queue=new LinkedList<String>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		/*
		 * E poll()
		 */
		String str=queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * E peek()
		 */
		str=queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * 使用迭代器遍历队列元素，元素还在队列中
		 */
		for(String s:queue){
			System.out.println(s);
		}
		while(queue.size()>0){
			String s=queue.poll();
			System.out.println(s);
		}
		System.out.println(queue);
		
	}
	
	
}
