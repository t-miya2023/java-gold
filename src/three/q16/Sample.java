package three.q16;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//ArrayListを使った拡張for文では読み出し中に要素数が変わるとConcurrentModificationExceptionがスローされる
		//List<Integer> list = new ArrayList<>();
		
		//参照時にコピーを作り参照する　スレッドセーフ
		List<Integer> list = new CopyOnWriteArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(new WriteTask(list));
		exec.submit(new ReadTask(list));
		
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		exec.shutdown();
		
		System.out.println("-----------");
		list.forEach(System.out::println);
	}

}
