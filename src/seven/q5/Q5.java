package seven.q5;

public class Q5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Test<A> a = new Test<>();
		Test<B> b = new Test<>();
		//Test<C> c = new Test<>();　制約によりコンパイルエラー
		
		a.execute(new A());
		a.execute(new B());
		b.execute(new B());
	}

}
