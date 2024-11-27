package three.q12;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable{
	
	private CyclicBarrier barrier;
	
	public Task(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("START: " + name);
		
		int r = new Random().nextInt(10);
		
		try {
			Thread.sleep(r * 1000);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("END: " + name);
		
		try {
			this.barrier.await();
		}catch(InterruptedException | BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}
}
//InterruptedException: スレッドが待機中に中断された場合
//BrokenBarrierException：　他のスレッドが異常終了したり、バリアを通過できない状態になった場合
