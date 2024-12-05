package six.q3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Q3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース情報
		final String URL = "jdbc:mariadb://localhost/java_db";
		final String USER_NAME = "root";
		final String PASSWORD = "";
		
		try (
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD)){
//			Connection　DBMSとの接続を管理する
//			DriverManager　クラスパス上にあるDBMSベンダーから提供されたドライバーを検索し接続する
//			getConnection()は引数の接続文字列を受け取り、接続を確率する
			System.out.println("接続成功");
			System.out.println(con);
			//con.close(); try-withなら必要なし
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
