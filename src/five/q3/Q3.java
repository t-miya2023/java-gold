package five.q3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Q3 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------Q3-------------");
//		FileReader reader = null;
//		try {
//			reader = new FileReader("sample.txt");
//			int i = 0;
//			while((i = reader.read()) != -1) {
//				char c = (char) i;
//				System.out.print(c);
//			}
//		}finally{
//			reader.close();
//		}
		//入出力を行うストリームはtry-with-resourcesを使う ->自動でリソースが解放されないため
		//FileReadeerは一文字づつ読み込む→文字が多いとパフォ低下
		FileReader reader = new FileReader("sample.txt");
		try(reader){
			int i = 0;
			while((i = reader.read()) != -1) {
				char c = (char) i;
				System.out.print(c);
			}
		}
		
		System.out.println("--------------Q4-------------");
		//BufferedReader 効率的に参照できる。Reader型を通じて参照する
		FileReader fr = new FileReader("sample.txt");
		BufferedReader reader2 = new BufferedReader(fr);
		try(reader2){
			String line = null;
			while((line = reader2.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

}
