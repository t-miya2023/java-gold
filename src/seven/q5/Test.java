package seven.q5;

//public class Test<T> { Tがhello()を持っているか保証できずコンパイルエラー
public class Test<T extends A>{ //A またはAのサブクラスのみに制約できる
	public void execute(T t){
		t.hello();
	}
}
