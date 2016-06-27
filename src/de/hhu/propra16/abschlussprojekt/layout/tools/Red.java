package de.hhu.propra16.abschlussprojekt.layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class Red implements Tool{
	private final Button red;

	
	public Red(){
		red = new Button("Red");
		
		red.setPrefSize(100, 50);
		
        red.setOnAction(event -> {
        	System.out.println("Hello");
        });
	}

	public Node getTool(){
		return red;
		
	}
}
