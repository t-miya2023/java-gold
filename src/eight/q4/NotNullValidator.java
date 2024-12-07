package eight.q4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NotNullValidator {
	public static List<String> validate(Object target){
		try {
			List<String> message = new ArrayList<String>();
			Class clazz = target.getClass();//クラスの定義情報を取得
			Field[] fields = clazz.getDeclaredFields();//フィールドの定義情報の一覧を取得
			for(Field field: fields) {
				field.setAccessible(true);//privateフィールドにアクセスするためにアクセス情報を変更
				NotNull annotation = field.getAnnotation(NotNull.class);//フィールドからアノテーションの情報を取り出す
				//アノテーションが付いてないフィールドはスキップ
				if(annotation == null) {
					continue;
				}
				//フィールドに値があればスキップ
				if(field.get(target) != null) {
					continue;
				}
				//２つのチェックを通過したならアノテーション付きのフィールドがnulｌなのでメッセージを追加
				message.add(annotation.message());
				
			}
			return message;
			
		}catch(IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
