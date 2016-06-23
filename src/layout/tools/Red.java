package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class Red implements Tool{
	private final Button red;
	private final int columnIndex;
	private final int rowIndex;
	private final int colSpan;
	private final int rowSpan;
	
	public Red(int columnIndex, int rowIndex, int colSpan, int rowSpan){
		red = new Button("Red");
		this.columnIndex = columnIndex;
		this.rowIndex = rowIndex;
		this.colSpan = colSpan;
		this.rowSpan = rowSpan;
		
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
