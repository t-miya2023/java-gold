package three.q17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Test test = new Test();
		//それぞれのスレッドが１つのtestインスタンスへの参照を共有している。ランダムな順で実行される。
		//	->ReentrantLockクラスを利用して複数のメソッドにまたがって排他制御を行う
		ExecutorService exec = Executors.newFixedThreadPool(3);
		exec.submit(new Task(test));
		exec.submit(new Task(test));
		exec.submit(new Task(test));
		exec.shutdown();
	}

}
