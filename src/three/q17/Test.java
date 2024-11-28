package three.q17;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	public void lock() {
		this.lock.lock();
	}
	
	public void unlock() {
		this.lock.unlock();
	}
	
	public void first() {
		System.out.println(
			Thread.currentThread().getName()
				+ ":1");
	}
	
	public void second() {
		System.out.println(
			Thread.currentThread().getName()
				+ ":2");
	}
	
	public void third() {
		System.out.println(
			Thread.currentThread().getName()
				+ ":3");
	}
}
