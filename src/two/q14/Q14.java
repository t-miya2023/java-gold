package two.q14;

import java.util.function.BinaryOperator;

public class Q14 {
	public static void main(String[] args) {
		BinaryOperator<String> b = (str, add) -> str.concat(add);
		
		System.out.println(b.apply("java ", "gold"));
	}
}
