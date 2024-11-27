package three.q12;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ExecutorService exec = Executors.newFixedThreadPool(5);
		// 第一引数は同期させるスレッド数、第二引数はBarrierAction
		CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println("it's all done");
			exec.shutdown();
		});
		
		for(int i = 0; i < 5; i++) {
			exec.submit(new Task(barrier));
		}
		
	}

}
