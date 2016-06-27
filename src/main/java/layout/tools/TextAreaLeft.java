package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class TextAreaLeft extends TextArea implements Tool {
	final TextArea left = new TextArea();

	public void make() {
		left.setPrefHeight(530);
		left.setPrefWidth(295);
		// l.autosize();
		left.setLayoutX(0);
		left.setLayoutY(40);
		left.setDisable(true);
	}

	@Override
	public Node getTool() {
		// TODO Auto-generated method stub
		return left;
	}
}
