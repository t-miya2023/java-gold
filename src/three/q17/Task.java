package three.q17;

public class Task implements Runnable {
	private Test test;
	
	public Task(Test test) {
		this.test = test;
	}
	
	@Override
	public void run() {
		try {
			test.lock();//ロック後、メソッドを実行
			test.first();
			test.second();
			test.third();
		} finally {
			test.unlock();//途中で例外が発生してもロックが解除されるようにする
		}
	}
}
