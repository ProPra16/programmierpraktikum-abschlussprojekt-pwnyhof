package main.java.de.hhu.propra16.tddt;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TDDTStart extends Application {

	public void start(Stage primaryStage) throws Exception {

		try{
		// Load root layout from fxml file.
		BorderPane base = FXMLLoader.load(getClass().getResource("./controller/TextScreen.fxml"));

		// Show the scene containing the root layout.
		Scene scene = new Scene(base);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
