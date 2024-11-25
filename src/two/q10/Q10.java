package two.q10;

import java.util.function.Function;

public class Q10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Function<Integer, Integer> plus = x -> x + 2;
		Function<Integer, Integer> times = x -> x * 2;
		
		System.out.println("andthen:" + plus.andThen(times).apply(5));//順次処理
		System.out.println("andthen:" +times.andThen(plus).apply(5));
		System.out.println("compose:" +plus.compose(times).apply(5));//逆順処理
		System.out.println("compose:" +times.compose(plus).apply(5));
	}

}
