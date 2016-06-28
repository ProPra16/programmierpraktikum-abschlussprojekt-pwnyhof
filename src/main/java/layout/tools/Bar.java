package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Bar implements Tool{
	
	private MenuBar menuBar;
	private Menu file;
	private MenuItem fileExit;
	
	public Bar(){
		menuBar = new MenuBar();
		file = new Menu("File");
		fileExit = new MenuItem("Exit");
		
		file.getItems().add(fileExit);
		menuBar.getMenus().add(file);
		
	}
	
	public Node getTool(){
		return menuBar;
	}

}
