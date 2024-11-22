package two.q5;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class Test {
	public static void main(String args[]) {
		var map = new HashMap<String, Integer>();
		BiConsumer<String, Integer> bi = (k, v) -> map.put(k, v);
		
		bi.accept("apple", 3);
		bi.accept("orange", 4);
		
		System.out.print(map);
	}
}
