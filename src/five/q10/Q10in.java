package five.q10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Q10in {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		FileInputStream fis = new FileInputStream("sample.ser");
		ObjectInputStream in = new ObjectInputStream(fis);
		
		try(in){
			Object obj = in.readObject();
			Item item = (Item) obj;
			System.out.println(item);
		}
	}

}
