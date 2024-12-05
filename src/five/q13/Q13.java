package five.q13;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Q13 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.print("> ");
		try (Scanner scan = new Scanner(System.in)) {
			String name = scan.nextLine();
			//dir配下のファイルパスを取得
			Path p = Paths.get("dir", name);
			//存在しなければ新規で作る　存在するのにcreateFileとするとFileAlreadyExistsException
			if(Files.exists(p) == false) {
				Files.createFile(p);
			}
					
			System.out.println(Files.getLastModifiedTime(p));//ファイルの最終変更時間を返します
			System.out.println(Files.getPosixFilePermissions(p));//ファイルのPOSIXファイル・アクセス権を返します。
			
			System.out.println("delete y/n? > ");
			if("y".equals(scan.nextLine())) {
				Files.delete(p);//ファイルが存在する場合は削除します
				System.out.println("deleted");
			}
		}
	}

}
