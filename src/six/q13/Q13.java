package six.q13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Q13 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース情報
		final String URL = "jdbc:mariadb://localhost/java_gold";
		final String USER_NAME = "root";
		final String PASSWORD = "";
		
		String sql  = "INSERT INTO users (name, age) values(?, ?)";
		
		String[] fruits = {"apple", "orange", "banana"};
		
		try(Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)){
			
			int i = 10;
			for(String f: fruits) {
				ps.setString(1, f);
				ps.setInt(2, i);
				ps.addBatch();
				i++;
			}
			int[] res = ps.executeBatch();//更新した件数は配列で[1, 1, 1]のように戻る
			System.out.println(Arrays.toString(res));
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
