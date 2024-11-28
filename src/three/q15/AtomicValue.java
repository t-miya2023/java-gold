package three.q15;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicValue extends Value{
	//処理が原始性が担保されている
	private AtomicInteger num = new AtomicInteger(0);
	
	public void add(int num) {
		this.num.addAndGet(num);
	}
	
	public int get() {
		return this.num.intValue();
	}
}
