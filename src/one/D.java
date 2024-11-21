package one;

public class D implements A,D11{
	
	public static void test10() {
		System.out.println("1-10:B");
	}
	
	//問11
	public void test11() {
		A.super.test11();
		//B11.super.test11();　呼び出せるのは継承した1つ上のスーパーインターフェースのみ
		//C11.super.test11();
		D11.super.test11();
		//デフォルトメソッドのオーバーライド　
	}
	
	public static void main (String[] args) {
	//問９
		A.test();
		//B.test();
		//C.test();
		//test();
		//インターフェースに鄭義されたstaticメソッドは呼び出し時に定義したインターフェース名を使う必要がある
		
	//問10
		A.test10();
		D.test10();
		//static メソッドはオーバーライドできない
		
	//Q11
		new D().test11();
	//Q12
		A12 a12 = new C12();
		a12.test12();
		//C12では同一シグ二チャーのtest12が定義されているがスーパークラスのものが優先される
	}
}
