package three.q13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//競合が発生するサンプル 300が出力されるが、稀に200の場合がある、
//add()で同時にnumを参照した場合200となる（競合が発生した）
public class Sample implements Runnable {
	
	private int num = 100;
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Sample s = new Sample();
		
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
	
	public void add(int amount) {
		int temp = this.num;
		temp = temp + amount;
		this.num = temp;
	}
	
	@Override
	public void run() {
		add(100);
	}
}
