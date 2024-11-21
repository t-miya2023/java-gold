package one;

public interface A {
	static void test() {
		System.out.println("1-9");
	}
	
	static void test10() {
		System.out.println("1-10:A");
	}
	
	default void test11() {
		System.out.println("1-11:A");
	}
}
