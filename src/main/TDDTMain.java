package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import layout.window.MainWindow;

public class TDDTMain extends Application{

	//Main Klasse
	public static void start(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("TDDT");
		GridPane root = new GridPane();
		
		MainWindow.buildWindow(root);
    
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
    
	}
}
