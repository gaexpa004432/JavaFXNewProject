package teamProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderMainControll implements Initializable{
	@FXML Button login;
	@FXML Label registry;
    @FXML TextField id;
    @FXML PasswordField password;
	Database db = new Database();
	ProjectMain pm =new ProjectMain();
	ObservableList<Customer> customer = null;
	OrderMain2 om = new OrderMain2();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		customer = FXCollections.observableArrayList();
		registry.setOnMouseClicked((e)-> register());

	}


	@FXML
	public void login(MouseEvent event) {
			Customer cus = new Customer(id.getText(),password.getText());
			boolean login = db.dbselect(cus);
			if(login == true) {
			Parent node = (Parent) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
				stage.close();
//				om.ordermain(registry.getScene().getWindow());
				ordermain();
				
		}
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
				ImageView order = (ImageView) parent.lookup("#order"); 
				ImageView basket = (ImageView) parent.lookup("#basket");
				ImageView mypage = (ImageView) parent.lookup("#mypage");
				order.setOnMouseClicked((e)-> {
					order();
					addStage.close();
					});
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
		}
	private void order() {
		String str = "restaurantFXML";
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(login.getScene().getWindow());
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("MenuBorder.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
			BorderPane bp = (BorderPane) parent.lookup("#bp");
			Parent root = FXMLLoader.load(getClass().getResource(str+".fxml"));
			bp.setCenter(root);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
				TextArea txtadress = (TextArea) parent.lookup("#txtadress");
				TextField txtname = (TextField) parent.lookup("#txtname");
				TextField txtphone = (TextField) parent.lookup("#txtphone");
				PasswordField txtpassword = (PasswordField) parent.lookup("#txtpassword");
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
