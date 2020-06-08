package teamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {
	
	Connection conn = null;
	PreparedStatement pstmt= null;

	
	public Connection dbconnect(){

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;
	}
	public void dbselect() {
	conn = dbconnect();
	String sql = "select id from customer";
	try {
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.getInt("id");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	public void dbfood() {
		conn = dbconnect();
		String sql = "select * from food";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dbbasket() {
		conn = dbconnect();
		String sql = "insert into vasket values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			int rs = pstmt.executeUpdate();
			System.out.println(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}