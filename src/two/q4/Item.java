package two.q4;

import java.util.function.Consumer;

public class Item {
	private int id;
	private String name;
	private int price;
	private String info;
	
	private Item(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.price = builder.price;
		this.info = builder.info;
	}
	
	@Override
	public String toString() {
		return "2-4: id: " + id + " 商品名: " + name + " 名前: " + price +" 情報: " + info;
	}
	
	//builderがコンストラクタの代わりにインスタンスを初期化する,
	//フィールド数が変わってもコンストラクタの引数を変更しなくていい。
	public static class Builder{
		private int id;
		public String name;
		public int price;
		public String info;
		
		public Builder(int id) {
			this.id = id;
		}
		
		/* しかしsetterが増えるデメリットがあるためconsumerを利用する
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}
		*/
		
		public Builder with(Consumer<Builder> consumer) {
			consumer.accept(this);//builderを受け取り必要なプロパティを設定する
			return this;
		}
		
		
		public Item build() {
			return new Item(this);
		}
	}
}
