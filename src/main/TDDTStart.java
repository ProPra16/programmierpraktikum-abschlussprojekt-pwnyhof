package main;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import layout.tools.Exit;
import layout.tools.Read;
import javafx.scene.paint.*;

public class TDDTStart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane base = new AnchorPane();
		base.setPrefHeight(400);
		base.setPrefWidth(600);
		Scene scene = new Scene(base);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TDDT 1.0");

		Button start = new Button("Start");
		Label name = new Label("Welcome to TDDT 1.0!");

		start.setPrefHeight(55);
		start.setPrefWidth(165);
		start.setLayoutX(215);
		start.setLayoutY(215);

		name.setLayoutX(125);
		name.setLayoutY(85);
		name.setPrefWidth(362);
		name.setPrefHeight(39);
		name.setFont(new Font("Mariet", 35));
		name.setTextFill(Paint.valueOf("BLUE"));

		base.getChildren().add(start);
		base.getChildren().add(name);
		// ****************************************************
		start.setOnAction(event -> {

			AnchorPane second = new AnchorPane();

			second.setPrefHeight(600);
			second.setPrefWidth(600);
			// -----------------------------------------------------
			Scene secondscene = new Scene(second);
			primaryStage.setScene(secondscene);

			// -----------------------------------------------------
			MenuBar bar = new MenuBar();
			bar.setPrefHeight(25);
			bar.setPrefWidth(600);
			Menu file = new Menu("File");
			MenuItem fileExit = new MenuItem("Exit");

			fileExit.setOnAction(Event -> {
				Exit.exit();
			});
			file.getItems().add(fileExit);
			bar.getMenus().add(file);
			second.getChildren().add(bar);
			// ------------------------------------------------------

			final TextArea l = new TextArea();
			final TextArea r = new TextArea();
			l.setPrefHeight(530);
			l.setPrefWidth(295);
			// l.autosize();
			l.setLayoutX(0);
			l.setLayoutY(40);
			l.setDisable(true);
			// TODO: unlock after first unsuccessful test

			r.setPrefHeight(530);
			r.setPrefWidth(295);
			// r.autosize();
			r.setLayoutX(0);
			r.setLayoutY(40);
			// -----------------------------------------------------------------------
			final Label code = new Label("Code");
			code.setTextFill(Paint.valueOf("BLUE"));
			code.setLayoutX(125);
			code.setLayoutY(10);
			code.setFont(Font.font("Courier New", FontWeight.BOLD, 22));

			final Label test = new Label("Test");
			test.setTextFill(Paint.valueOf("RED"));
			test.setLayoutX(125);
			test.setLayoutY(10);
			test.setFont(Font.font("Courier New", FontWeight.BOLD, 22));
			// -------------------------------------------------------------------------------

			Read read = new Read();

			// -------------------------------------------------------------------------------

			AnchorPane left = new AnchorPane();
			left.getChildren().addAll(l, code);
			AnchorPane right = new AnchorPane();
			right.getChildren().addAll(r, test, read.getTool());
			// -------------------------------------------------------------------
			SplitPane split = new SplitPane();

			split.setPrefHeight(575);
			split.setPrefWidth(600);
			split.setLayoutX(0);
			split.setLayoutY(25);

			split.getItems().addAll(left, right);

			second.getChildren().add(split);

			// ------------------------------------------------------

			primaryStage.show();
		});
		// ******************************************************
		primaryStage.show();

	}

//	public static void main(String[] args) {
//		launch(args);
//	}

}
