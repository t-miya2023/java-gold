package four.collector;

import java.util.Arrays;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> list = Arrays.asList("A", "B", "C", "D", "E");
		
		String result = list.parallelStream().collect(new SampleCollector());
		System.out.println(result);
	}

}
