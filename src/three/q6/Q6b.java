package three.q6;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q6b {
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		//
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		//scheduleWithFixedDelayメソッドは処理の時間に関係なく一定のインターバルをとる。
		//タスクを「前回の実行が終わってから一定の遅延後」に実行 遅れがそのまま反映される
		//適用シーン:リソース負荷を抑える間隔処理
		exec.scheduleWithFixedDelay(() -> {
			//ランダムな処理時間を作る
			int r = new Random().nextInt(10);
			System.out.print(r);
			try {
				Thread.sleep(r * 100);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
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
//処理の間隔が一定でないことが確認できる