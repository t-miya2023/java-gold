package four.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsSample {
	public static void main(String[] args) {
			List<Item> list = Arrays.asList(
					new Item(1, ItemType.BOOK, "Java", 1980),
					new Item(2, ItemType.BOOK, "JavaScript", 2980),
					new Item(3, ItemType.MAGAZINE, "PHP", 1980),
					new Item(4, ItemType.MAGAZINE, "HTML", 980),
					new Item(5, ItemType.BOOK, "Ruby", 980),
					new Item(6, ItemType.DVD, "Laravel", 2980),
					new Item(7, ItemType.DVD, "SpringBoot", 3980)
					);
		System.out.println("-------------Q23------------------");
			List<Item> books = list.stream().filter(item -> item.getType() == ItemType.BOOK).collect(Collectors.toList());
			//CollectorsクラスのtoListメソッド　新しいリストを作成する　ストリームを操作して得た結果で構成されたコレクションを作れる
			books.forEach(System.out::println);
			
		System.out.println("-------------Q24------------------");
			//groupingByメソッド グループ化を行う。　Mapを戻り値とし、キーがラムダ式の戻り値、バリューがグルーピング化された要素のリスト
			Map<ItemType, List<Item>> group = list.stream().collect(Collectors.groupingBy(Item::getType));
			System.out.println(group);
			
		System.out.println("-------------Q25------------------");
			//groupingByメソッドの第二引数に,CollectorsクラスのsummingIntメソッドを指定するとグループごとの合計値を表示できる
			Map<ItemType, Integer> group2 = list.stream().collect(Collectors.groupingBy(Item::getType, Collectors.summingInt(Item::getPrice)));
			System.out.println(group2);
			//平均も出せる
			Map<ItemType, Double> group3 = list.stream().collect(Collectors.groupingBy(Item::getType, Collectors.averagingInt(Item::getPrice)));
			System.out.println(group3);
			
		System.out.println("-------------Q26------------------");
			//条件ごとにグループ化を行う　partitioningメソッド 2グループしかできない。
			Map<Boolean, List<Item>> map = list.stream().collect(Collectors.partitioningBy(item -> item.getPrice() > 2000));
			System.out.println(map);
			list.stream().collect(Collectors.partitioningBy(item -> item.getPrice() > 2000)).keySet().forEach(System.out::println);
			
		System.out.println("-------------Q27------------------");
			//Streamインターフェースのpeekメソッド　デバック目的、ストリームパイプラインの途中で状態を確認する
			//1要素ずつストリームパイプラインに渡されるため１つの要素連続して出力される結果になる	
			list.stream().filter(a -> a.getName().length() > 5)
						.peek(a -> System.out.println("debug: "+a.getName()))
						.map(a -> a.getName().toUpperCase())
						.peek(a -> System.out.println("debug: "+a))
						.forEach(System.out::println);
		
		System.out.println("-------------Q28------------------");
			//ストリームパイプラインの終端操作は１回しか呼び出せない。
			List<Integer> listInt = Arrays.asList(1,2,3,4,5);
			Stream<Integer> stream = listInt.stream();
			System.out.println(stream.count());
			//stream.forEach(System.out::println);2回目の操作は例外が発生する
		//リストに変換されてからの操作（例: forEach, size）は、リストクラスの標準的なメソッドを使用しており、ストリームの制約とは無関係
			List<Integer> list1 = list.stream().filter(a -> a.getName().length() > 5).map(a -> a.getId()).toList();
				list1.forEach(System.out::println);
				list1.forEach(System.out::println);
				System.out.println(list1.size());
	}

}
