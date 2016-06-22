package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class Red implements Tool{
	private final Button red;
	private final int columnIndex;
	private final int rowIndex;
	private final int colSpan;
	private final int rowSpan;
	
	public Red(){
		red = new Button("Red");
		columnIndex = 0;
		rowIndex = 0;
		colSpan = 1;
		rowSpan = 1;
		
        red.setOnAction(event -> {
        	System.out.println("Hello");
        });
	}

	public Node getTool(){
		return red;
		
	}
	public int getColumnIndex(){
		return columnIndex;
		
	}
	public int getRowIndex(){
		return rowIndex;
		
	}
	public int getColSpan(){
		return colSpan;
		
	}
	public int getRowSpan(){
		return rowSpan;
		
	}
}
