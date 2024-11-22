package two.q2;

import java.util.function.Supplier;

public class Test {
	public void execute(Supplier<A> supplier) {
		System.out.println("before");
		A a = supplier.get(); //supplier.get()でnew C() が実行されるようにしている
		a.hello();
		System.out.println("after");
	}
}
