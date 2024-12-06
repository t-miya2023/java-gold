package seven.q7;

public class Q7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Test<?> t = new Test<>("hello");
		//String msg = t.getValue(); 非境界ワイルドカードのインスタンスのメソッドの戻り値の型はObjectになる
		String msg = (String)t.getValue();//ダウンキャストしないとコンパイルエラー
		
//		t.setValue(1);
//		t.setValue(new Object());
//		t.setValue("message"); メソッドの引数にはnullしか渡せない
		t.setValue(null);
	}

}
