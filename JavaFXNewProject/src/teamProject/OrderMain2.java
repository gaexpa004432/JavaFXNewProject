package teamProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class OrderMain2 implements Initializable {
	
	@FXML
	ImageView order ;
	public Window win(Window window) {
		return window;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void mainBorderOn(MouseEvent event) {
//		Parent node = (Parent) event.getSource();
//		Stage stage = (Stage) node.getScene().getWindow();
//		stage.close();
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(order.getScene().getWindow());
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("MenuBorder.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public void btAction(){
//		setPage("test");
//	}
//	public void setPage(String string) {
//		try {
//			Parent root= FXMLLoader.load(getClass().getResource(string+".fxml"));
//			bp.setCenter(root);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public void ordermain(Window window) {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(window.getScene().getWindow());
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

}
