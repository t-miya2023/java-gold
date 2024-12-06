package seven.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		Setは重複を許容しない
		
		System.out.println("-----------TreeSet-------------");
//		自然順序で並び替えるか、引数のアルゴリズムに従う　パフォhashより劣る
		Set<String> set = new TreeSet<>();
		set.add("B");
		set.add("A");
		set.add("D");
		set.add("C");
		set.add("B");
		set.add("A");
		set.stream().forEach(System.out::println);
		
		System.out.println("-----------HashSet-------------");
//		並び順を保証しない　高速 環境の影響（JVM）で変わっている？
		Set<String> set2 = new HashSet<>();
		set2.add("B");
		set2.add("A");
		set2.add("D");
		set2.add("C");
		set2.add("B");
		set2.add("A");
		set2.stream().forEach(System.out::println);
	}

}
