package two.q8;

import java.util.function.BiPredicate;

public class Q8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		BiPredicate<String, String> b = (str, suffix) -> str.endsWith(suffix);
		System.out.println(b.test("Q8.java", "java"));
		
		Name n = new Name("侍太郎", "太");
		System.out.println(b.test(n.getName(), n.getNickName()));
	}

}
