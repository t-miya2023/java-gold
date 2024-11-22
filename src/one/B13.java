package one;

public abstract class B13 {
	//protected void test() { 同じシグ二チャの場合、クラスが優先されるが、インターフェースよりアクセス修飾子を厳しくできない。
	public void test() {
		System.out.println("1-13:B");
	}
}
