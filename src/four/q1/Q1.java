package four.q1;

import java.util.Optional;

public class Q1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//Optional<String> sample = Optional.of(null); nullを許容しないためnullpointExceptionが発生する
		Optional<String> sample = Optional.of("Test");//null以外のoptinal インスタンスを生成する
		System.out.println(sample);
		//optionalインスタンスからgetメソッドで取り出せる
		System.out.println(sample.get());
		//値を持っているか、nullの場合は空のインスタンスを生成し参照を戻す
		Optional<String> sample2 = Optional.ofNullable(null);
		System.out.println(sample2);
		//System.out.println(sample2.get()); 空のインスタンスに対してgetは使えない→NoSuchElementException
		//空のoptionalインスタンスを生成する
		Optional<String> sample3 = Optional.empty();
		System.out.println(sample3);
		//値があればTrue
		if(sample3.isPresent()) {
			System.out.println(sample3.get());
		}else {
			System.out.println("空でした");
		}
		//空ならTrue
		if(sample3.isEmpty()) {
			System.out.println("empty");
		}
		
		System.out.println("-----Q3------------");
		//orElseは値がある場合はその値を、なければ引数を返す
		System.out.println(sample.orElse("Test"));
		System.out.println(sample.orElse("A"));
		System.out.println(sample2.orElse("A"));
		System.out.println(sample2.orElseGet(() -> "orElseGet"));//処理をして返す場合  引数はSupplier型
 	}

}
