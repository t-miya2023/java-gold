package three.q4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO 自動生成されたメソッド・スタブ
		//遅延実行するにはscheduleメソッドを使う。
		//ScheduledExecutorServiceはタイミングの制御や定期的な処理を実行する場合に使うインターフェース
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		
		exec.schedule(() -> {
			System.out.print("finished");
			exec.shutdown();//スレッドプールを閉じる
		}, 1, TimeUnit.SECONDS);
		
		int count = 0;
		
		while(true) {
			Thread.sleep(100);
			if(exec.isShutdown()) {
				break;
			}
			System.out.println((++count) * 100 + "ms");
		}
	}

}
