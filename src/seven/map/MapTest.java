package seven.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		System.out.println("-----------Q14-------------");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2,  "two");
		map.put(3,  "three");
		map.put(4,  "four");
		map.put(5,  "five");
		map.put(6, "six");
		map.put(7, "seven");
		
		//keySet()mapからkeyのみを取り出す
		map.keySet().stream().forEach(key -> {
			System.out.println(map.get(key));
		});
		System.out.println("-----------Q15-------------");
		//map.entrySet()でMap.Entry(１列のkeyとvalue)を取り出す
		map.entrySet().stream().forEach((Map.Entry<Integer, String> entry) -> {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);
		});
	}
}
