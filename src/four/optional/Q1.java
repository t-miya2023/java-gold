package four.optional;

import java.util.List;
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
		
		Optional<Integer> sample4 = Optional.of(100);
		
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
		
		System.out.println("-----Q4------------");
		try {
			//optionalが空の場合、orElseThrowで例外をスローできる
			System.out.println(sample2.orElseThrow(()-> new Exception()));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("-----Q5------------");
		//値を取り出さず、処理する場合はifPresentメソッドを使用する
		sample.ifPresent((str) -> System.out.println(str));//Consumer型のラムダ式を受け取る
		sample2.ifPresent((str) -> System.out.println(str));//nullの場合出力されず、例外も発生しない。
		System.out.println("-----Q6------------");
		//ifPresentはnullの場合何もしない。処理をしたい場合は,ifPresentOrElseを使用する。
		//第一引数に値が存在する場合の処理をConsumer型で、第二引数にnullの場合の処理をRannable型で。
		sample.ifPresentOrElse((str)->System.out.println(str), ()->System.out.println("Empty"));
		sample2.ifPresentOrElse((str)->System.out.println(str), ()->System.out.println("Empty"));
		System.out.println("-----Q7------------");
		//mapメソッドはFunction型の引数を受け取り、処理結果を持った新しいインスタンスを生成する
		Optional<String> result = sample.map(str -> str.toUpperCase());//大文字に変換したインスタンスの生成
		Optional<String> result2 = sample2.map(str -> str.toUpperCase());//引数が空の場合は空にインスタンスを生成
		System.out.println(result.get());
		System.out.println(sample.get());
		System.out.println(result2.isEmpty());
		System.out.println("-----Q8------------");
		//mapメソッドは処理結果を保持した新しいOptionalインスタンスを生成する。
		//Optional<Integer> q8 = sample4.map(price -> calc(price, 3));　Optional<Optional<Integer>>を返し、互換性がないためエラーになる
		Optional<Integer> q8 = sample4.flatMap(price -> calc(price, 3));//Optionalで内包しないのならflatMapを利用する
		System.out.println(q8.get());

		System.out.println("-----Q9------------");
		List<Integer> list = List.of(1, 2, 3 , 4, 5);
		System.out.println("forEach");
		//foreach 要素を順番に取り出しながらConsumer型のラムダ式を実行する
		list.forEach(x -> System.out.println(x));
		System.out.println("メソッド参照");
		list.forEach(System.out::println);//コンソールに表示するだけならメソッド参照の方が簡単
 	}
	
	private static Optional<Integer> calc(int price, int qty){
		if(qty < 0) {
			return Optional.empty();
		}
		return Optional.of(price * qty);
	}

}
