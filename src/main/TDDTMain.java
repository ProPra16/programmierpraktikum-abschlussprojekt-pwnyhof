package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
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
		
	    ColumnConstraints column1 = new ColumnConstraints();
	    column1.setPercentWidth(50);
	    ColumnConstraints column2 = new ColumnConstraints();
	    column2.setPercentWidth(50);
	    root.getColumnConstraints().addAll(column1, column2);
	     
        root.setHgap(10);
        root.setVgap(10);
		
		MainWindow.buildWindow(root);
    
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
    
	}
}
