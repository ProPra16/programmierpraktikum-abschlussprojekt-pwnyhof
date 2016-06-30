package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CodeLabel implements Tool {

	private Label code;

	public CodeLabel() {
		code = new Label("Code");
		
		code.setTextFill(Paint.valueOf("BLUE"));
		code.setLayoutX(125);
		code.setLayoutY(10);
		code.setFont(Font.font("Courier New", FontWeight.BOLD, 22));
	}

	public Node getTool() {
		return code;
	}

}
