package three.q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//mainとは別に新しいメソッドを１つだけ作ってプールする
		ExecutorService exec = Executors.newSingleThreadExecutor();
		System.out.println("newSingleThreadExecutor");
		for(int i = 0; i < 5 ; i++) {
			exec.submit(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		}

	}
}
