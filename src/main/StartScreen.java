package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartScreen extends Application {

	public static void main(String[] args) {
		Application.launch(StartScreen.class);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(StartScreen.class.getResource("StartLayout.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("TDDT 1.0");
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
