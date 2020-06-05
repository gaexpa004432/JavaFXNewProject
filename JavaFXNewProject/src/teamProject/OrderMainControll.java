package teamProject;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class OrderMainControll implements Initializable{
	@FXML Button order,basket,mypage;
	Connection conn;
	PreparedStatement pstmt;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		order.setOnAction((e)->{
			orderAction();
		});
		mypage.setOnAction((e->{
			mypageAction();
		}));
		basket.setOnAction((e)->{
			basketAction();
		});
	}
	private void basketAction() {
		
	}
	public void mypageAction() {
		
	}
	public void orderAction() {
		
	}

}
