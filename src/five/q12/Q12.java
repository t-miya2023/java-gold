package five.q12;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q12 {
	public static void main(String[] args) {
		//Paths.get()はパスを作る　探して参照するわけではない。
		Path path = Paths.get("test/test.txt");
		System.out.println(path);
		Path path2 = Paths.get("test", "test.txt");
		System.out.println(path2);
		Path path3 = Paths.get("test", "testin", "testin.txt");
		System.out.println(path3);
		System.out.println(path3.toAbsolutePath());//絶対パス
		Path path4 = Paths.get("test", "testdummy", "dummy.txt");//実在しなファイル
		System.out.println(path4.toAbsolutePath());
		Path path5 = new File("sample.txt").toPath();
		System.out.println(path5.toAbsolutePath());
	}
}
