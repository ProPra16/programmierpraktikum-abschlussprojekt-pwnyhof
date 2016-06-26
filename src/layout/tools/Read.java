package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Read implements Tool {
	private final Button read;

	private final TextArea textArea;

	public Read() {
		read = new Button("Read");
		read.setPrefHeight(25);
		read.setPrefWidth(50);
		read.setTextFill(Color.TOMATO);
		read.setFont(Font.font("Courier New", FontWeight.BOLD, 13));
		read.setLayoutX(40);
		read.setLayoutY(10);

		textArea = new TextArea();

		read.setOnAction(Event -> {
			System.out.println(textArea.getText());
			textArea.setText(textArea.getText());
		});
	}

	public Node getTool() {
		return read;
	}
}
