package three.q1;

public class Q1 {
	public static void main(String[] args) {
		Thread t = new Thread() {
		@Override
		public synchronized void start() {
			super.start();
			System.out.println("A");
		}
		@Override
		public void run() {
			super.run();
			System.out.println("B");
		}
	};
		t.start();//新しいスタックを作るのはstart
		//start->新しいスレッドが作られる->スレッドがRunnable状態に移行し、run()が呼び出される。
		t.run();//スレッド内で実行したいコードを定義するメソッド
	}
}	
