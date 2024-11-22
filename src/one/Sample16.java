package one;

public enum Sample16 {
	A("hello"), B("Hello"), C("hello!!!");
	private final String value; //暗黙的にprivateである必要がある
	//定数に文字列を割り振るためにコンストラクタが必要
	private Sample16(String value) {
		System.out.println(value);
		this.value = value;
	}
	//読み込みが行われタイミングで定数が初期化される→コンストラクタが実行される→各定数ごとに１回ずつ
	
	@Override
	public String toString() {
		return value;
	}
}
