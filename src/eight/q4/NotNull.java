package eight.q4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//フィールドに付与するアノテーションということ
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
	String message();
}
