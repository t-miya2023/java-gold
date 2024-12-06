package seven.q2;

public class Q2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//型パラメータを渡さなかった場合、Objectの型が渡されたものと判断される
		Value v = new Value("Hello");
		Object a = v.getVal();
		System.out.println(a);
		
		Value<String> v1 = new Value<String>("Hello");
		String b = v1.getVal();
		System.out.println(b);
	}

}
