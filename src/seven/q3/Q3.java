package seven.q3;

import java.util.ArrayList;
import java.util.List;

public class Q3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//<>の型推論が使えるのは
//			1.変数への代入
//			2.メソッドの戻り値
//			3.メソッド呼び出しの引数
		//1
		List<String> list = new ArrayList<>();
		//3
		execute(new ArrayList<>());

	}
	private static void execute(List<String> list) {
		
	}
	//2
	private List<String> getList(){
		return new ArrayList<>();
	}
}
