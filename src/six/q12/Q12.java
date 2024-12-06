package six.q12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//入力されたSQLによって処理を変えるプログラム
//java_gold % java -cp "src:/usr/local/apache-tomcat-9.0.93/lib/mariadb-java-client-3.4.1.jar" six.q12.Q12 "SELECT * FROM users"
public class Q12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース情報
				final String URL = "jdbc:mariadb://localhost/java_gold";
				final String USER_NAME = "root";
				final String PASSWORD = "";
				
		try(Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(args[0])){
			
			if(ps.execute() == false) {
				System.out.println(ps.getUpdateCount());
				return;
			}
			
			ResultSet rs = ps.getResultSet();
			ResultSetMetaData meta = rs.getMetaData();
			int colSize = meta.getColumnCount();
			while(rs.next()) {
				for(int i = 1; i <= colSize; i++) {
					System.out.println(rs.getString(i));
				}
			}
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
