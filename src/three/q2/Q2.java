package three.q2;

public class Q2 {
	public static void main(String[] args) {
		//マルチスレッドで並行処理をするには
		//1.Threadを継承したサブクラスを定義し、run()をオーバーライドするか
		//2.RunnableインターフェースをThreadに渡し、run()をオーバーライドする。
		Thread t = new Thread(() -> {
			System.out.println("A");//ｔスレッドが起動してから実行
		});
		t.start();
		System.out.println("B");//メインスレッドで即座に実行
		//Bー>Aとなる
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("C");
			}
		});
		t2.start();
		System.out.println("D");
	}
}	
//マルチスレッドの実行順序は保証されません。
//出力の順序は環境やスケジューラの動作に依存します。