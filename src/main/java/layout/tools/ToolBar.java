package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class ToolBar implements Tool{
	
	private MenuBar bar;

	public ToolBar(){
		bar = new MenuBar();
		
		Menu red = new Menu("Red");
		Menu green = new Menu("Green");
		
		red.setOnAction(Event -> {
			
		});
		
		green.setOnAction(Event -> {
			
		});
		
		bar.getMenus().addAll(red, green);
	}
	
	public Node getTool(){
		return bar;
	}
}
