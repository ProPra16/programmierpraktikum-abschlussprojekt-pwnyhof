package main;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import layout.window.MainWindow;

public class TDDTMain {
	
	public static  void mainWindow(Stage primaryStage){
		
		GridPane gPane = new GridPane();
		
        primaryStage.setTitle("TDDTrainer");
		primaryStage.setMinHeight(600.0);
		primaryStage.setMinWidth(600.0);
		
		
		// Zwei Spalten die jeweils 50% der Spaltenlänge einnehmen
	    ColumnConstraints column1 = new ColumnConstraints();
	    column1.setPercentWidth(50);
	    ColumnConstraints column2 = new ColumnConstraints();
	    column2.setPercentWidth(50);
	    gPane.getColumnConstraints().addAll(column1, column2);
	    
        //gPane.setHgap(10);
        //gPane.setVgap(10);
		
		MainWindow.createMainWindow(gPane);
		
		Scene scene = new Scene(gPane);	
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
