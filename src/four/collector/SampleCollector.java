package four.collector;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SampleCollector implements Collector<String, StringBuilder, String> {
	//Collector リダクション操作のためのインターフェース　処理途中のオブジェクトを適切に扱える
	//5つの抽象メソッド　全て実装する必要がある
		//supplier　処理途中の値を保持するオブジェクトを生成する
		//accumulator　実行したい処理を記述
		//combiner　並列処理で個々に作られた処理途中の値を保持するためのオブジェクトを結合すること
		//finisher　処理結果を戻す
		//characteristics　Collectorの特徴を表すEnumのセットを戻す

	@Override
	public Supplier<StringBuilder> supplier() {
		// TODO 自動生成されたメソッド・スタブ
		return StringBuilder::new;
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		// TODO 自動生成されたメソッド・スタブ
		return (builder, str) -> {
			if(builder.length() != 0) {
				builder.append(",");
			}
			builder.append(str);
		};
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		// TODO 自動生成されたメソッド・スタブ
		return (a,b) -> {
			if(a.length() != 0) {
				a.append(",");
			}
			a.append(b);
			return a;
		};
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		// TODO 自動生成されたメソッド・スタブ
		return builder -> builder.toString();
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO 自動生成されたメソッド・スタブ
		return EnumSet.noneOf(Characteristics.class);
	}

}
