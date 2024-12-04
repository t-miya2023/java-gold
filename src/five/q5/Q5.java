package five.q5;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Q5 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------Q5-------------");
		//FileWriter１文字ずつ出力する
		FileWriter out = new FileWriter("output.txt", true);//true追記を有効にする　デフォルトではfalse(上書きする)
		try(out){
			out.write("\n");
			out.write("Hello, Java!");
		}
		
		System.out.println("--------------Q6-------------");
		FileWriter out2 = new FileWriter("output.txt", true);
		BufferedWriter writer = new BufferedWriter(out2);
		try(writer){
			writer.newLine();//改行メソッド
			writer.write("buffering output");//バッファに一度書き込んでからファイルに書き込む　バッファ→ファイルは自動　データが食い違うタイミングあり
			writer.flush();//強制的に書き込みを行う　同期できる
		}
	}

}
