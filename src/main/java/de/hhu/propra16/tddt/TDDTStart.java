package de.hhu.propra16.tddt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TDDTStart extends Application {

	public void start(Stage stage) throws Exception {

		try{
		// Load root layout from fxml file.
		BorderPane base = FXMLLoader.load(getClass().getResource("./layout/TextScreen.fxml"));

		// Show the scene containing the root layout.
		Scene scene = new Scene(base);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		catch(Exception e){
			
		}

	}



	public static void main(String[] args) {
		launch(args);
	}
}
