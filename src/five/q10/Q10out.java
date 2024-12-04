package five.q10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Q10out {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		FileOutputStream fos = new FileOutputStream("sample.ser");
		//シリアライズして書き出すためのObjectOutputStream
		ObjectOutputStream out = new ObjectOutputStream(fos);
		
		try(out){
			Item item = new Item("apple", 100);
			out.writeObject(item);
		}
	}

}
