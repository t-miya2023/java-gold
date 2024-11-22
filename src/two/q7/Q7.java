package two.q7;

import java.util.function.Predicate;

public class Q7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		Predicate<Integer> p1 = x -> x > 0;
		Predicate<Integer> p2 = x -> x < 100;
		Predicate<Integer> p3 = x -> x == 1000;
		
		System.out.println("(1):" +  p1.or(p2).test(1000));
		System.out.println("(2):" +  p1.and(p2).test(1000));
		System.out.println("(3):" +  p1.or(p2).and(p3).test(1000));
		System.out.println("(4):" +  p1.or(p2).or(p3).test(1000));
	}

}
