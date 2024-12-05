package five.q16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
//コンソールからの入力をファイル末尾に追加する
//Filesクラスを利用してバッファから読み書きするストリームを作る　Q5と比較
public class Q16 {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		Path sample = Paths.get("dir", "sample.txt");
		if(Files.exists(sample) == false) {
			Files.createFile(sample);
		}
		
		Scanner scan = new Scanner(System.in);
		
		BufferedWriter out = Files.newBufferedWriter(sample, StandardOpenOption.APPEND);
		
		try(scan; out){//複数のリソースを利用する場合；で区切る
			System.out.println("> ");
			out.write(scan.nextLine());
			out.newLine();
		}
		
		BufferedReader in = Files.newBufferedReader(sample);
		try(in){
			in.lines().forEach(System.out::println);
		}
	}

}
