package two.q14;

import java.util.function.BinaryOperator;

public class UseOperator {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//2つの値を処理して、同じ方で返す。
		//ファクトリークラスを介すことでロジックを隠蔽できる
		BinaryOperator<Integer> a = OperatorFactory.add();
		BinaryOperator<Integer> b = OperatorFactory.minus();
		BinaryOperator<String> c = OperatorFactory.strAdd();
		
		System.out.println(a.apply(10, 20));
		System.out.println(b.apply(20, 10));
		System.out.println(c.apply("java ", "gold"));
	}

}
