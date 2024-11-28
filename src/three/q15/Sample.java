package three.q15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//排他制御されていないため、稀に『100』が出力される
		Value val = new Value();
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(new Task(val));
		exec.submit(new Task(val));
		
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("排他制御なし:" + val.get());
		exec.shutdown();
		
		//AtomicItegerクラスのaddAndGetメソッドを使い、一連の処理とし他のスレッドの影響がないようにする
		Value atVal = new AtomicValue();
		
		ExecutorService exec2 = Executors.newFixedThreadPool(2);
		exec2.submit(new Task(atVal));
		exec2.submit(new Task(atVal));
		
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("atomic:" + atVal.get());
		exec2.shutdown();
	}

}
