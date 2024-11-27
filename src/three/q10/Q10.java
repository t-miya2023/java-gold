package three.q10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q10 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		ExecutorService exec = Executors.newSingleThreadExecutor();
		//Runnableはnullもしくは固定値しか戻せない。
		//Callableは戻り値を設定できる
		/*
		
		Callable<Boolean> task = new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception{
				return new Random().nextInt() % 2 == 0;
			}
		};
		
		List<Future<Boolean>> futures = new ArrayList<>();
		for(int i = 0; i < 10 ; i++) {
			futures.add(exec.submit(task));
		}
		
		*/

		//上のコードをラムダ式で書くと　Rannableと区別がつかなくなるが、returnしているのはCallable
		List<Future<Boolean>> futures = new ArrayList<>();
		for(int i = 0; i < 10 ; i++) {
			futures.add(exec.submit(() -> {
				return new Random().nextInt() % 2 == 0;
			}));
		}
		
		int total = 0;
		for(Future<Boolean> future: futures) {
			Boolean result = future.get();
			System.out.println(result);
			if(result) {
				total++;
			}
		}
		System.out.println(total);
		exec.shutdown();
	}

}
