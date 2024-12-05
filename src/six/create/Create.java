package six.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース情報
		final String URL = "jdbc:mariadb://localhost/java_gold";
		final String USER_NAME = "root";
		final String PASSWORD = "";
		
		String sql = """
				CREATE TABLE users (
					user_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
					name VARCHAR(255) NOT NULL,
					age INT(11) NOT NULL
				);
		""";
		
		try(Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.executeUpdate();
			System.out.println("テーブル作成成功！！");
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
