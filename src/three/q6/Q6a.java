package three.q6;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q6a {
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		//
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		//scheduleAtFixedRateメソッドはインターバルが終了したら次の処理がを始める。
		//タスクを「固定間隔」で繰り返し実行。インターバルは一定ではない。スケジュール間隔に影響しない
		//タスクが長引くと、間隔内でタスクが連続して実行される場合も
		//適用シーン:データ取得、定期監視
		exec.scheduleAtFixedRate(() -> {
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