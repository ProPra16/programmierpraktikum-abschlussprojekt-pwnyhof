package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class PrStageNameLb extends Label implements Tool {
	Label name = new Label("Welcome to TDDT 1.0!");

	public void make() {
		name.setLayoutX(125);
		name.setLayoutY(85);
		name.setPrefWidth(362);
		name.setPrefHeight(39);
		name.setFont(new Font("Mariet", 35));
		name.setTextFill(Paint.valueOf("BLUE"));
	}

	@Override
	public Node getTool() {
		// TODO Auto-generated method stub
		return name;
	}

}
