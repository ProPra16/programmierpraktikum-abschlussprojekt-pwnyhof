package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TestLabel implements Tool {
	final Label test = new Label("Test");

	public void make() {
		test.setTextFill(Paint.valueOf("RED"));
		test.setLayoutX(125);
		test.setLayoutY(10);
		test.setFont(Font.font("Courier New", FontWeight.BOLD, 22));
	}

	@Override
	public Node getTool() {
		// TODO Auto-generated method stub
		return test;
	}

}
