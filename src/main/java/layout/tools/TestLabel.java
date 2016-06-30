package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TestLabel implements Tool {
	
	private Label test;

	public TestLabel() {
		test = new Label("Test");
		
		test.setTextFill(Paint.valueOf("RED"));
		test.setLayoutX(125);
		test.setLayoutY(10);
		test.setFont(Font.font("Courier New", FontWeight.BOLD, 22));
	}

	public Node getTool() {
		return test;
	}

}
