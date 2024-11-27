package three.q8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		ExecutorService exec = Executors.newFixedThreadPool(3);
		
		Future<Integer> future1 = exec.submit(() -> {
			Thread.sleep(1000);
			System.out.println("Task1 Complete");
			return 100;
		});
		Future<Integer> future2 = exec.submit(() -> {
			Thread.sleep(2000);
			System.out.println("Task12 Complete");
			return 10;
		});
		Future<Integer> future3 = exec.submit(() -> {
			Thread.sleep(3000);
			System.out.println("Task3 Complete");
			return 1;
		});
		
		
        // 各タスクの結果を取得
        int result1 = future1.get(); // タスク1の結果を取得
        int result2 = future2.get(); // タスク2の結果を取得
        int result3 = future3.get(); // タスク3の結果を取得
        
        
		int total = result1 + result2 + result3;
		System.out.println("合計：" + total);
		
		
		// スレッドプールの終了
        exec.shutdown();
	}

}
