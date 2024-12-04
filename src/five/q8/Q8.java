package five.q8;

import java.io.Console;

public class Q8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// コンソールからの入力を受け付ける
		Console console = System.console();
		String str = console.readLine();//入力値が表示される　戻り値String
		System.out.println(str);
		
		char[] password = console.readPassword();//入力値が表示されない　戻り値char[]
		System.out.println(String.valueOf(password));
	}

}
