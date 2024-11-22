package one;

public class Main15 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("(1)" + Test15.values()[0]);//values()はEnumを配列に入れて返す
		for(Test15 t : Test15.values()) {
			System.out.println("(2)" +t);
		}
		System.out.println("(3)" +Test15.valueOf("A"));//valueOf()は名前から列挙子を取り出す
		System.out.println("(4)" +Test15.A);
	}

}
