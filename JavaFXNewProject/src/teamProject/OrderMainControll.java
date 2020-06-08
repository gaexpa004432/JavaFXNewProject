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
	Database db = new Database();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
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
