package seven.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("-----------Q11-------------");
		
		Queue<String> queue = new ArrayDeque<>(5);
		queue.add("A");
		queue.add("A");
		queue.add("A");
		queue.add("A");
		queue.add("E");
		queue.stream().forEach(System.out::println);
		
		System.out.println("-----------Q12-------------");
		Deque<String> deque = new ArrayDeque<>();
		deque.add("A");
		deque.addLast("B");
		deque.addFirst("C");
		deque.addLast("D");
		deque.addFirst("E");
		deque.stream().forEach(System.out::println);
	}
	

}
