package eight.q4;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Sample sample = new Sample(null);
		List<String> messages = NotNullValidator.validate(sample);
		if(messages.isEmpty()) {
			System.out.println("vaild object");
			return;
		}
		for(String message : messages) {
			System.out.println(message);
		}
	}

}
