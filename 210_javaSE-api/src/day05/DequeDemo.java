package day05;

import java.util.LinkedList;
import java.util.Deque;

public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque=new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");
		System.out.println(deque);
		
		deque.offerFirst("three");
		System.out.println(deque);
	
		deque.offerLast("four");
		System.out.println(deque);
	
	
	}
	
}
