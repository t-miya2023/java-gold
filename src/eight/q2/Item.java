package eight.q2;

@Test(name = "test", price = 100)
//アノテーションで扱う値のことを『注釈パラメータ』という
//@SampleValue("sample") 注釈パラメータ名がvalueのみの場合、値だけの記述ができる
@DefaultValue //デフォルトで値を設定することも可能
public class Item {
	private String name;
	private int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
