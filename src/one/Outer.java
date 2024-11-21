package one;

public class Outer {
	public Outer() {};
	//-------------問２-------------
	private class Inner2{
		public void test() {
			System.out.println("1-2");
		}
	}
	//-------------問３-------------
	//staticなインナークラスの呼び出しはエンクロージングクラスを呼ぶ必要なし
	private static class Inner3{
		public void test() {
			System.out.println("1-3");
		}
	}
	//-------------問４-------------
	private static int num4 =2;
	//private int num =2; staticクラスから非staticなフィールドにアクセスできない
	public void hoge4() {
		Inner4 test = new Inner4();
		test.data = 100;
		test.execute();
	}
	private static class Inner4{
		private int data;
		void execute() {
			System.out.println("1-4：" + num4 * data);
		}
	}
	//-------------問５-------------
	void test5() {
		Inner5.message = "Hello, Java";
	}
	//class Inner5{
	//非staticのインナークラスにはstaticなメソッド、フィールドは定義できない。
	static class Inner5{
		private static String message;
		public void test() {
			System.out.println("1-5：" + message);
		}
	}
	//-------------問６-------------
	private String message6;
	public Test test6(String value) {
		String text = ", good!!";
		class A implements Test{
			@Override
			public void execute() {
				System.out.println("1-6：" + message6 + value + text);
			}
		}
		//value = "LocalClass"; ローカルクラスから参照するローカル変数は実質　finalでなければならない。
		message6 = "Hello, "; //フィールドは後から代入でも問題なし。
		//String text = "good!!";ローカルクラスから参照するローカル変数はローカルクラスより前に定義する
		return new A();
	}
	//-------------問７-------------
	private int num7;
	public Outer(int num7) {
		this.num7 = num7;
	}
	public int getNum7() {
		return num7;
	}
	public void setNum7(int num7) {
		this.num7 = num7;
	}
	
	public static void main(String[] args) {
		new Outer().new Inner2().test();
		new Inner3().test();
		new Outer().hoge4();
	//5
		Outer outer = new Outer();
		outer.test5();
		//outer.new Inner5().test();
		new Inner5().test();
	//6
		new Outer().test6("Java").execute();
	//7
		var outer7 = new Outer(10) {
			//Outerクラスを継承した匿名クラスの実装
			void modify(int num) {
				setNum7(num);
			}
		};
		outer7.modify(100);
		System.out.println("1-7：" + outer7.getNum7());
	}
}
