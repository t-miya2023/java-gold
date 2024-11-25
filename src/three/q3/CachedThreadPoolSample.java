package three.q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//必要に応じてスレッドを増減させるスレッドプールを作る
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Runnable test = () -> {
			System.out.println(Thread.currentThread().getName());
		};
		for(int i = 0 ; i < 5 ; i++) {
			exec.submit(test);
		}
		
		try {
			Thread.sleep(1 * 10000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//同一のスレッドが使い回される
		System.out.println("-----------10sec------------");
		for(int i = 0 ; i < 5 ; i++) {
			exec.submit(test);
		}
		
		try {
			Thread.sleep(1 * 70000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//60秒後には生成されたスレッドは破棄され新しいスレッドが作られる
		System.out.println("-----------70sec------------");
		for(int i = 0 ; i < 5 ; i++) {
			exec.submit(test);
		}
	}

}
