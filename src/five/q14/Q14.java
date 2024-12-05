package five.q14;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q14 {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		Path dir = Paths.get("dir", "subdir");
		if(Files.exists(dir) == false) {
			Files.createDirectories(dir);//存在しないすべての親ディレクトリをまず作成することで、ディレクトリを作成します
		}
		Path a = Paths.get("data.txt");
		Files.createFile(dir.resolve(a));//指定されたパスをこのパスに対して解決します。
		//dirとfileを分けてresolveを使って表している
	}

}
