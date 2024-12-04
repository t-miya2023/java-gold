package five.q7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Q7 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		//コピーを作成するプログラム
		FileInputStream fis = new FileInputStream("sample.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);//バッファを利用し効率化
		
		FileOutputStream fos = new FileOutputStream("sample_bk.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		try(bis; bos){
			byte[] data = null;
			//1024byteずつ取り出す
			while((data = bis.readNBytes(1024)).length != 0) {
				//readAllBytesで全データを取り出すことも可能→メモリの負担大
				bos.write(data);
			}
			bos.flush();
		}
	}

}
