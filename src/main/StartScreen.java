
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartScreen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
			//Wo ist denn die StartLayout.fxml ?
		AnchorPane page = FXMLLoader.load(StartScreen.class.getResource("StartLayout.fxml"));
		Scene scene = new Scene(page);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TDDT 1.0");
		primaryStage.show();
	}
	public static void main(String[] args){ launch();}
}
