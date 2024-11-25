package two.q13;

import java.util.ArrayList;
import java.util.List;

public class Q13 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//リストの処理を一律に処理を行う
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		/*このコードを省略している
		UnaryOperator<String> toUpperCaseOperator = x -> x.toUpperCase();
		list.replaceAll(toUpperCaseOperator);
		*/
		list.replaceAll(x -> x.toUpperCase());
		
		//replaceAllの引数はUnaryOperator<T>であるため、x -> x.toUpperCase() を書くだけで、自動的に UnaryOperator<String> として扱われます。
		
		for(String s : list) {
			System.out.println(s);
		}
	}

}
