package five.q15;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q15 {
	
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		Path dir = Paths.get("dir", "subdir");
		if(Files.exists(dir) == false) {
			Files.createDirectories(dir);
		}
		
		Path a = Paths.get("test.txt");
		Path testPath = Files.createFile(dir.resolve(a));//dir > subdirにtest.txtを作成
		
		Path outFile = Paths.get("dir", "test_bk.txt");
		Files.copy(testPath, outFile);//dirディレクトリにコピー(test_bk.txt)を作成
		//Files.copy(コピー元,コピー先);
		Path dir2 = Paths.get("");
		Path dist = dir2.resolve(Paths.get("test_bk.txt"));
		Files.move(outFile, dist);//カレントディレクトリに移動
		////Files.move(移動元,移動先);
	}

}
