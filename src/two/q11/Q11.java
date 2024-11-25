package two.q11;

import java.util.function.BiFunction;

public class Q11 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		BiFunction<String, String, String> b =
				(str, addStr) -> str.concat(addStr);
				
		String result = b.apply("Hello, ", "Lamda");
		System.out.println(result);
		System.out.println("2-11:" + b.apply(result, " Java"));
	}

}
