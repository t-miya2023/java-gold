package four.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------Q12-------------");
			//コレクションは管理する順で処理される
			List<String> list = Arrays.asList("A", "B", "C", "D", "E");
			Stream<String> stream = list.stream();
			System.out.println("--list----");
			stream.forEach(x->{
				System.out.println(x);
			});
			
			Set<String> set = new HashSet<>();
			set.add("E");
			set.add("D");
			set.add("C");
			set.add("B");
			set.add("A");
			Stream<String> stream2 = set.stream();
			System.out.println("--HashSet----");
			stream2.forEach(x->{
				System.out.println(x);
			});
			
		System.out.println("--------------Q13-------------");
			//並列ストリーム　複数のスレッドが一斉に処理するので順番を制御できない。
			Stream<String> parallelStream = list.parallelStream();
			parallelStream.forEach(System.out::println);
			//forEachOrdered 順番通りになる　パフォーマンスが落ちる
			System.out.println("forEachOrdered");
			Stream<String> parallelStream2 = list.parallelStream();
			parallelStream2.forEachOrdered(System.out::println);
			
		System.out.println("--------------Q14-------------");
			//要素の絞り込み filterメソッド
			List<Integer> listQ14 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
			listQ14.stream().filter(x -> x > 5).filter(x -> x % 2 == 0).forEach(System.out::println);;
			
		System.out.println("--------------Q15-------------");
			//重複を取り除く distinctメソッド equalsメソッドの結果がtrueになるものが対象
			List<String> listQ15 = Arrays.asList("A","B","C","A");
			listQ15.stream().distinct().forEach(System.out::println);
			//Valueクラスのequalsは常にtrueを返す。→重複してると見なされ最初のAのみが残る
			List<Value> listVal = Arrays.asList(
					new Value("A"),
					new Value("B"),
					new Value("C"),
					new Value("A")				
					);
			long size = listVal.stream().distinct().count();
			System.out.println("listValの数: "+size);
			//数で絞り込む　limitメソッド
			System.out.println("limit");
			listQ14.stream().limit(5).forEach(System.out::println);
			//指定した数以降を取り出す skipメソッド
			System.out.println("skip");
			listQ14.stream().skip(5).forEach(System.out::println);
			
		System.out.println("--------------Q16-------------");
		//要素を１つ戻す findAny findFirst
		List<String> listQ16 = Arrays.asList("A","B","C","D","E");
		Optional<String> result1 = listQ16.stream().findAny();//シングルスレッドでもランダム？
		result1.ifPresent(System.out::println);
		Optional<String> result2 = listQ16.stream().findFirst();//シングルでもストリームの先頭
		result2.ifPresent(System.out::println);
		System.out.println("並列");
		Optional<String> result3 = listQ16.parallelStream().findAny();//並列処理時の戻り値はランダム
		result3.ifPresent(System.out::println);
		Optional<String> result4 = listQ16.parallelStream().findFirst();//並列処理時の戻り値はストリームの先頭　処理した要素を戻すわけではない
		result4.ifPresent(System.out::println);
		
		System.out.println("--------------Q17-------------");
		//ストリームの要素を並び替える　sortedメソッド
		listQ15.stream().sorted().forEach(System.out::println);
		
		List<Item> listQ17 = Arrays.asList(
					new Item(1, "Apple", "Nagano"),
					new Item(2, "Orange", "Ehime"),
					new Item(3, "Banana", "Okinawa")
				);
		listQ17.stream().sorted((a,b) -> a.getName().compareTo(b.getName())).forEach(System.out::println);
		listQ17.stream().sorted((a,b) -> a.getArea().compareTo(b.getArea())).forEach(System.out::println);
		listQ17.stream().sorted((a,b) -> {
			if(a.getId() > b.getId()) {
				return -1;
			}else if(a.getId() < b.getId()) {
				return 1;
			}else {
				return 0;
			}
		}).forEach(System.out::println);
		
		System.out.println("--------------Q18-------------");
		//ストリーム要素に対し処理を加える mapメソッド 処理に応じて異なる型も返せる
		Stream<String> result5 =  listQ17.stream().map(a -> a.getName().toUpperCase());
		result5.forEach(System.out::println);
		listQ17.stream().map(a -> a.getArea().toUpperCase()).forEach(System.out::println);
		Stream<Integer> result6 = listQ17.stream().map(a -> a.getArea().length());
		result6.forEach(System.out::println);
		listQ17.stream().map(a -> String.valueOf(a.getId())).forEach(System.out::println);
		
		System.out.println("--------------Q19-------------");
		//リダクション操作　値を累積的に結合していく階数を実行するもの　reduceメソッド
		Optional<Integer> result7 = listQ14.stream().reduce((a,b) -> a + b);//初期値を設定しなければOptional型で戻される
		result7.ifPresent(System.out::println);
		listQ14.stream().reduce((a,b) -> a - b).ifPresent(System.out::println);
		Integer result8 = listQ14.stream().reduce(100, (a,b) -> a + b);//第一引数に初期値、第二引数にラムダ式、初期値はボクシングされInteger型として扱われる
		System.out.println(result8);
		
		System.out.println("--------------Q20-------------");
		//リダクション操作　最大の要素を返す maxメソッド　最小を返す　minメソッド
		Optional<Integer> result9 = listQ14.stream().max((a,b) -> {
			if(a > b) {
				return 1;
			}else if(a < b) {
				return -1;
			}else {
				return 0;
			}
		});
		System.out.println(result9.get());
		listQ14.stream().sorted((a,b) -> {
			if(a > b) {
				return 1;
			}else if(a < b) {
				return -1;
			}else {
				return 0;
			}
		}).forEach(System.out::print);
		
		Optional<String> result10 = list.stream().max((a,b) -> a.compareTo(b));
		System.out.println(result10.get());
		list.stream().sorted((a,b) -> a.compareTo(b)).forEach(System.out::print);
	
		
	}

}
