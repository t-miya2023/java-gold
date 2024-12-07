package eight.q2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//実行時までアノテーションの情報を保持する
//@Retention(RetentionPolicy.CLASS)//実行時にアノテーション情報は破棄される
//@Retention(RetentionPolicy.SOURCE)//コンパイル時にアノテーション情報は破棄される
public @interface Test {
	String name();
	int price();
}
