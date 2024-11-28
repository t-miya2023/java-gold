package three.q13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q13 implements Runnable{
	private int num = 100;
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Q13 s = new Q13();
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(s);
		exec.submit(s);
		
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println(s.num);
		exec.shutdown();
	}
	//synchronized　メソッド全体を排他制御する
	public synchronized void add(int amount) {
		int temp = this.num;
		temp = temp + amount;
		this.num = temp;
	}
	
	@Override
	public void run() {
		add(100);
	}
}
