package seven.q8;

public class Q8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		上限境界ワイルドカード
		//Bもしくはそのサブクラスを受け取るTest型の変数
		Test<? extends B> test = new Test<B>(new B());
		B b = test.getValue();//渡される型が保証されているためダウンキャスト不要
		b.hello();
		
		Test<? extends B> test2 = new Test<C>(new C());
		B b2 = test2.getValue();
		b2.hello();
		
		//Test<? extends B> test3 = new Test<A>(new A()); A型はサブクラスではないのでエラー
		
		//test.setValue(new B());　上限境界ワイルドカードでは改善できない
//		Testのフィールドは不定なのでnullしか渡せない。
		System.out.println("------------Q9-------------");
//		下限境界ワイルドカード
		//Bもしくはそのスーパークラスを受け取るTest型の変数
		Test<? super B> test4 = new Test<A>(new A());
		Test<? super B> test5 = new Test<B>(new B());
//		Test<? super B> test6 = new Test<C>(new C()); 上位しか扱えないのでエラー
		
//		test4.setValue(new A()); AはBのサブクラスではないのでエラー
		test4.setValue(new B());
		test5.setValue(new C());
//		取り出しはObject　どの型が入っているか不定のため
		Object objA = test4.getValue();
		Object objB = test5.getValue();
//		ダウンキャスト必要
		A aObjA = (A)test4.getValue();
		
//		メソッドの目的が戻り値を戻すこととしたProducerであればExtends、引数を受け取って利用するConsumerならSuper
//		『PECS』。両方を安全につかうにはワイルドカードなしのジェネリクスで。
	}

}
