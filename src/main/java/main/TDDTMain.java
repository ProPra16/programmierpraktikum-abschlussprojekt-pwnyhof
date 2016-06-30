package main;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import layout.tools.CodeLabel;
import layout.tools.MenueBar;
import layout.tools.PrStageNameLb;
import layout.tools.TestLabel;
import layout.tools.TextAreaLeft;
import layout.tools.TextAreaRight;

public class TDDTMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane base = new AnchorPane();
		base.setPrefHeight(400);
		base.setPrefWidth(600);
		Scene scene = new Scene(base);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TDDT 1.0");
		// --------------------------------------------------------
		Button start = new Button("Start");

		start.setPrefHeight(55);
		start.setPrefWidth(165);
		start.setLayoutX(215);
		start.setLayoutY(215);
		// -----------------------------------------------------
		PrStageNameLb name = new PrStageNameLb();
		name.make();

		base.getChildren().add(start);
		base.getChildren().add(name.getTool());
		// ****************************************************
		start.setOnAction(event -> {

			AnchorPane second = new AnchorPane();

			second.setPrefHeight(600);
			second.setPrefWidth(600);
			// -----------------------------------------------------
			Scene secondscene = new Scene(second);
			primaryStage.setScene(secondscene);

			// -----------------------------------------------------
			MenueBar bar = new MenueBar();
			bar.make();

			second.getChildren().add(bar.getTool());
			// ------------------------------------------------------

			TextAreaLeft l = new TextAreaLeft();
			l.make();
			TextAreaRight r = new TextAreaRight();
			r.make();

			// -----------------------------------------------------------------------
			CodeLabel code = new CodeLabel();
			code.make();
			TestLabel test = new TestLabel();
			test.make();
			// -------------------------------------------------------------------------------

			Button read = new Button("read");
			read.setPrefHeight(25);
			read.setPrefWidth(50);
			read.setTextFill(Color.TOMATO);
			read.setFont(Font.font("Courier New", FontWeight.BOLD, 13));
			read.setLayoutX(40);
			read.setLayoutY(10);
			// -------------------------------------------------------------------------------

			AnchorPane left = new AnchorPane();
			left.getChildren().addAll(l.getTool(), code.getTool());
			AnchorPane right = new AnchorPane();
			right.getChildren().addAll(r.getTool(), test.getTool(), read);

			read.setOnAction(Event -> {

				Scanner scanner = new Scanner(r.getText());
				while (scanner.hasNext()) {
					String input = scanner.nextLine();

					r.setText(input);

					System.out.println(r.getText());
				}
				scanner.close();
			});
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
}
