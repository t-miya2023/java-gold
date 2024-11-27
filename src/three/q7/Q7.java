package three.q7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q7 {
	public static void main(String[] args) throws Exception {
		//2つのスレッドを生成しプールする
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
		//2つのスレッドが１秒ずつ遅延しながら実行する
		exec.scheduleWithFixedDelay(() -> {
			System.out.print("A");
		}, 1, 1, TimeUnit.SECONDS );
		
		exec.scheduleWithFixedDelay(() -> {
			System.out.print("B");
		}, 1, 1, TimeUnit.SECONDS );
		
		Thread.sleep(10000);//10sec後に終了する
		
		exec.shutdown();
	}
}
