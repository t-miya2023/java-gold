package one;

public interface A14 {
	//private void a(); 処理を持たないメソッドはprivateにできない
	private void b() {
		System.out.println("1-14:A");
	}
	//インターフェースのprivateメソッドはクラスと同じように定義できる　default修飾子は不要
	/*
	private default void c() {
		System.out.println("1-14:A");
	}
	*/
	private static void d() {
		System.out.println("1-14:B");
	}
}
