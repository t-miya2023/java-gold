package two.q4;

public class Sample {
	public static void main(String[] args) {
		//Item item = new Item.Builder(100).setName("orange").setPrice(100).build();
		Item item = new Item.Builder(100).with(b -> {
			b.name = "orange";
			b.price = 120;
			b.info = "愛媛産";
		}).build();
		System.out.println(item);
	}
}
