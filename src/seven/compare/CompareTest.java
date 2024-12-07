package seven.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("-----------Q16-------------");
		//Comparableインターフェースを実装したItem 自身と引数を比較する compareTo
		Item a = new Item("apple", 100);
		Item b = new Item("orange", 150);
		Item c = new Item("banana", 200);
		Item d = new Item("berry", 45);
		
		List<Item> list = Arrays.asList(a, b, c, d);
		
		Collections.sort(list);
		list.stream().forEach(System.out::println);
		
		System.out.println("-----------Q17-------------");
		//Comparatorインターフェースを実装したItemName 引数２つの比較　compare
		list.sort(new ItemName());
		list.forEach(System.out::println);
		
		System.out.println("-----------lamda-------------");
		list.sort((a1, b1) -> {
			return a1.getName().compareTo(b1.getName());
		});
		list.forEach(System.out::println);
	}

}
