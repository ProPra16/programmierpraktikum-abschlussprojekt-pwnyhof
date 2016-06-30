package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class TestArea extends TextArea implements Tool {
	final TextArea right;

	public TestArea() {
		right = new TextArea();
		right.setPrefHeight(530);
		right.setPrefWidth(295);

		right.setLayoutX(0);
		right.setLayoutY(40);
		right.setEditable(true);
	}

	public Node getTool() {
		return right;
	}
}
