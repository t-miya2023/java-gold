package three.q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//mainとは別に新しいメソッドを引数の数だけ作ってプールする
		ExecutorService exec = Executors.newFixedThreadPool(3);
		System.out.println("newFixedThreadPool");
		for(int i = 0; i < 5 ; i++) {
			exec.submit(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		}
	}

}
