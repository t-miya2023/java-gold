package five.q10;

import java.io.Serializable;

public class Item implements Serializable{
	//Serializableインターフェースを実装することでシリアライズとデシリアライズが可能になる
	//transient,staticは対象から除外される
	private String name;
	private int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return "Item [name=" + name + " , price=" + price + "]";
	}
}
