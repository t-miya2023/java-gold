package eight.q2;

public class TestItem {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Class<Item> clazz = Item.class;
		//クラスリテラルでクラスの定義情報を取得する
		Test test = clazz.getAnnotation(Test.class);
		//Itemクラスの定義情報からTestアノテーションの情報を取り出す
		if(test == null) {
			return;
		}
		
		String name = test.name();
		int price = test.price();
		
		Item item = new Item(name, price);
		
		System.out.println(item.getName());
		System.out.println(item.getPrice());
	}

}
