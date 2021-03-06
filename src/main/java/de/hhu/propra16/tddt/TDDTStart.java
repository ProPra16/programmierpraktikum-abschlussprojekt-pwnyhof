package de.hhu.propra16.tddt;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * Main class of TDDT, loads the root layout from TextScreen.fxml
 * defines the title and shows the Stage.
 * @author group pwnyhof
 *
 */
public class TDDTStart extends Application {

	public void start(Stage primaryStage) throws Exception {

		try {

			// Load root layout from fxml file.
			BorderPane base = FXMLLoader.load(getClass().getResource("TextScreen.fxml"));

			// Show the scene containing the root layout.
			Scene scene = new Scene(base);

			primaryStage.setTitle("TDDT Alpha 0.6");
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
