package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainBar implements Tool {
	private MenuBar bar;

	public MainBar(){
		bar = new MenuBar();
	
		Menu file = new Menu("File");
		
		MenuItem fileNew = new MenuItem("New");
		MenuItem fileOpen = new MenuItem("Open");
		MenuItem fileSave = new MenuItem("Save");
		MenuItem fileLoad = new MenuItem("Load");
		MenuItem fileExit = new MenuItem("Exit");
		
		fileNew.setOnAction(Event -> {
			
		});
		
		fileOpen.setOnAction(Event -> {
			
		});
		
		fileSave.setOnAction(Event -> {
			
		});
		
		fileLoad.setOnAction(Event -> {
			
		});
		
		fileExit.setOnAction(Event -> {
			Exit.exit();
		});
		
		file.getItems().addAll(fileNew, fileOpen, fileSave, fileLoad, fileExit);
		bar.getMenus().add(file);
	}
	
	public Node getTool(){
		return bar;
	}

}
