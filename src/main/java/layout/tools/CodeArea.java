package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class CodeArea implements Tool {
	private TextArea left;
	
	public CodeArea(){
		this.left = new TextArea();
		
		left.setPrefHeight(530);
		left.setPrefWidth(295);

		left.setLayoutX(0);
		left.setLayoutY(40);
		left.setDisable(true);
		
	}

	public Node getTool() {
		return left;
	}
}
