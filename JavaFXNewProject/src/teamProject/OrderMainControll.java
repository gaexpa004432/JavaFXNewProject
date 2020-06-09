package teamProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderMainControll implements Initializable{
	@FXML Button login;
	@FXML Label registry;
    @FXML TextField id,password;
//	@FXML ImageView order,basket,mypage;
	Database db = new Database();
	ProjectMain pm =new ProjectMain();
	ObservableList<Customer> customer = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		customer = FXCollections.observableArrayList();
		registry.setOnMouseClicked((e)-> register());
		login.setOnAction((e) -> login());
//		order.setOnMouseClicked((e)->{
//			orderAction();
//		});
//		mypage.setOnMouseClicked((e)->{
//			mypageAction();
//		});
//		basket.setOnMouseClicked((e)->{
//			basketAction();
//		});
	}
//	public void mypageAction() {
//		
//	}
//	private void basketAction() {
//		Platform.exit();
//	}
//	public void orderAction() {
//		db.dbselect();
//	}
	public void login() {
		login.setOnAction((e)->{
			Customer cus = new Customer(id.getText(),password.getText());
			boolean login = db.dbselect(cus);
			
			if(login == true) {
				ordermain();
			}
		});
	}

	public void ordermain() {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(login.getScene().getWindow());
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("OrderMain.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	public void register() {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(login.getScene().getWindow());
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("signup.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
			Button btnregistry = (Button) parent.lookup("#addbtn");
			btnregistry.setOnAction((e)-> {
				TextField txtId = (TextField) parent.lookup("#txtid");
				TextField txtadress = (TextField) parent.lookup("#txtadress");
				TextField txtname = (TextField) parent.lookup("#txtname");
				TextField txtphone = (TextField) parent.lookup("#txtphone");
				TextField txtpassword = (TextField) parent.lookup("#txtpassword");
				Customer cus = new Customer(txtId.getText(), txtadress.getText(), txtname.getText(),
						txtphone.getText(), txtpassword.getText());
				db.dbregistry(cus);
				addStage.close();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
