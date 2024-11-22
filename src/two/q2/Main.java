package two.q2;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Test test = new Test();
		test.execute(() -> new C());

		test.execute(B::new);//インスタンスの生成だけならメソッド参照の方が簡潔
	}

}
