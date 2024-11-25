package two.q12;

import java.util.function.UnaryOperator;

public class Q12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//UnaryOperatorはfunctionのサブインターフェース
		//１つの型を処理し、同じ方で返す
		UnaryOperator<Integer> increment = x -> ++x;
		UnaryOperator<Integer> twice = x -> x * 2;
		//UnaryOperator<String> str = x -> x.length(); 違う方に変換できない
		UnaryOperator<String> st = x -> x.concat(" , Hello!");
		
		System.out.println(increment.apply(10));
		System.out.println(twice.apply(10));
		System.out.println(st.apply("Java"));
	}

}
