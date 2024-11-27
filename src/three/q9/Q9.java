package three.q9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q9 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		ExecutorService exec = Executors.newSingleThreadExecutor();
		//Futureを利用するとそのスレッドを外部から操作することが可能
		Future<Integer> future = exec.submit(() -> {
			try {
				System.out.println("start");
				Thread.sleep(2000);
				System.out.println("end");
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		},0);//submitの第二引数に戻り値を指定
		
		System.out.print(future.get());
		
	}

}
