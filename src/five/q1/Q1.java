package five.q1;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Q1 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------Q1-------------");
		File file = new File("data.txt");
		if(file.exists() == false) {
			file.createNewFile();//新規ファイルを作成するメソッド
		}
		System.out.println(file.getAbsolutePath());
		
		File dir = new File("test");
		if(file.exists() == false) {
			dir.mkdir();//新規ディレクトリを作るメソッド
		}
		System.out.println(dir.getAbsolutePath());
		
		System.out.println("--------------Q2-------------");
		//FileFilterインターフェース　抽出するファイルにフィルターをかけれる
		FileFilter  filter = (path) -> {
			if(path.isDirectory()) {
				return true;
			}//ディレクトリなら通す
			if(path.getName().endsWith(".java")) {
				return true;
			}// javaファイルなら通す
			return false;
		};
		
		File rootDir = new File(".");
		showTree(rootDir, filter,"");
		/* list()はStringの配列を返す
		String[] lists = rootDir.list();
		for(String s : lists) {
			System.out.println(s);
		}
		*/

	}

	//引数のパスにあるファイル名を配列で取得
	private static void showTree(File dir, FileFilter filter,String indent) {
		File[] files = dir.listFiles(filter);//ファイル名を配列で取得するメソッド
		for(File file: files) {
			System.out.println(indent + file.getName());
			if(file.isDirectory()) {
				showTree(file, filter,indent + " ");
			}
		}
	}
}
