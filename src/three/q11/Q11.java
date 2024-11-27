package three.q11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q11 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		ExecutorService exec = Executors.newSingleThreadExecutor();


		//ExecutorServiceが例外をキャッチし、スローされた例外は ExecutionException にラップされる。
		//ExecutionExceptionはExceptionのサブクラスで検査例外
		List<Future<Boolean>> futures = new ArrayList<>();
		for(int i = 0; i < 10 ; i++) {
			futures.add(exec.submit(() -> {
				if(new Random().nextInt() % 2 != 0) {
					throw new Exception("odd number");
				}
				return true;
			}));
		}
		
		int total = 0;
		for(Future<Boolean> future: futures) {
			Boolean result = false;
			try {
					result = future.get();
					System.out.println(result);
				}catch(ExecutionException e) {
					System.out.println(e.getMessage());
					//ExecutionExceptionに保持されている例外はe.getCause()で取り出せる
				}
			if(result) {
				total++;
			}
		}
		System.out.println(total);
		exec.shutdown();
	}

}
