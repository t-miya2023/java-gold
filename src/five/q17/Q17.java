package five.q17;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
//srcの上のディレクトリで実行する
public class Q17 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		Path base = Paths.get(".");
		Files.list(base).forEach(System.out::println);
		//Files.list()は引数のdirのパスを返す(subdirまでは表示しない)
		System.out.println("-------");
		Files
			.walk(base.resolve("src"))
			.forEach(System.out::println);
//		Files.walk()はsubdirまでパスを返す
		System.out.println("-------");
		BiPredicate<Path, BasicFileAttributes> bp = (p, attr) -> {
			return p.toFile().getName().endsWith(".java");
		};
		Files
			.find(base, 3, bp)
			.forEach(System.out::println);
//		Files.find()はsubdirまで探索し、必要なものだけに絞り込める
//		find(path, 処理するdirの深さ, 絞り込み条件(BiPredicate))
//		3階層目にある.javaで終わるパスを返す
	}

}
