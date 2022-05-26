package jdbc;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://192.168.0.7:3306/practice2";
			conn = DriverManager.getConnection(dburl, "group1", "1234");
			stmt = conn.createStatement();
			//conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			String sql = "SELECT no, 음식분류, 음식점이름, 메뉴, 가격, 리뷰수 "
					+ " FROM lunch2 ORDER BY 리뷰수 DESC";
					
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong("no");
				String 음식분류 = rs.getString("음식분류");
				String 음식점이름 = rs.getString("음식점이름");
				String 메뉴 = rs.getString("메뉴");
				Long 가격 = rs.getLong("가격");
				Long 리뷰수 = rs.getLong("리뷰수");
				
				System.out.println(no + ":" + 음식분류 + ":" + 음식점이름 + ":" + 메뉴 + ":" + 
														가격 +":" + 리뷰수);
			}
			} catch (ClassNotFoundException e) {
				System.err.println("드라이버 로딩 실패!");
			} catch (Exception e) {
				System.err.println("쿼리 수행 실패!");
				e.printStackTrace();
				
			} finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
		}
		
	}

}
