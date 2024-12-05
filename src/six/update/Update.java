package six.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース情報
		final String URL = "jdbc:mariadb://localhost/java_gold";
		final String USER_NAME = "root";
		final String PASSWORD = "";
		
		String sql = """
				INSERT INTO users(name, age) VALUES
				  ('テストユーザー', 35),
				  ('テストマン', 27)
			""";
		
		try(Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)){
			
			int i = ps.executeUpdate();
//			boolean i = ps.execute();Resultsetが戻っていたかbooleanで戻す
//			 ps.executeUpdate(sql); →　PreparedStatementがStatementを継承しているためコンパイルは可能　例外が発生する
			System.out.println(i + "件、データ挿入完了！！");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
