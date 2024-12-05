package six.q6where;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース情報
		final String URL = "jdbc:mariadb://localhost/java_db";
		final String USER_NAME = "root";
		final String PASSWORD = "";
		
		String sql = "SELECT * FROM posts WHERE user_id = ?;";
		
		int targetId = 1002;
		
		try(Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(0, targetId);//（index1(1から), セットしたい文字（数字））
//			範囲外のインデックスを指定すると例外が発生する
//			?を全て指定しないと例外が発生する
			ResultSet res = ps.executeQuery();
//			executeQuery()　検索結果を戻す
//			executeUpdate() データの更新・削除・挿入を行う　更新した数を返す
//			execute()　Resultsetが戻っていたかbooleanで戻す
//			executeBatch()　複数のSQLを一度に実行し、更新された数の配列を戻す
			
			while(res.next()) {
				Date date = res.getDate("posted_at");
				String post = res.getString("post_content");
				int likes = res.getInt("likes");
				System.out.println(
						res.getRow() + "件目：投稿日時＝" + date + 
						"/投稿内容＝" + post + "/いいね数＝" + likes
						);
				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
