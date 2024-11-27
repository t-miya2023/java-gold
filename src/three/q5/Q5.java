package three.q5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q5 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		//1秒ごとにinterrupt
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		//scheduleAtFixedRateメソッドは定期的に繰り返し実行する
		exec.scheduleAtFixedRate(() -> {
			System.out.println("interrupt");
		}, 1, 1, TimeUnit.SECONDS);//(Rannable,初期遅延時間,インターバル,時間の単位)
		//0.1秒ごとに>
		int count = 0;
		while(true) {
			Thread.sleep(100);
			System.out.print(">");
			count++;
			if(count == 100) {
				exec.shutdown();
				System.out.print("終わり");
				break;
			}
			
		}
		
	}

}
