package two.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Supplier<List<String>> supplier = () -> new ArrayList();
		List<String> list = supplier.get();
		
	}
}
