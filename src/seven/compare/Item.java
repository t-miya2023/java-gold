package seven.compare;

public class Item implements Comparable<Item>{
	private String name;
	private int price;
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public int compareTo(Item other) {
		if(this.price < other.price) {
			return -1;
		}else if(this.price > other.price) {
			return 1;
		}else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Item [name = " + name + ", price = " + price + "]";
	}
}
