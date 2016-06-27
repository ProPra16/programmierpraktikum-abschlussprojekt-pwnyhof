package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class TextAreaRight extends TextArea implements Tool {
	final TextArea r = new TextArea();

	public void make() {
		r.setPrefHeight(530);
		r.setPrefWidth(295);
		// r.autosize();
		r.setLayoutX(0);
		r.setLayoutY(40);
		r.setEditable(true);
	}

	@Override
	public Node getTool() {
		// TODO Auto-generated method stub
		return r;
	}
}
