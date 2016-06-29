package layout.tools;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenueBar extends MenuBar implements Tool {
	private final MenuBar bar = new MenuBar();

	public void make() {
		bar.setPrefHeight(25);
		bar.setPrefWidth(600);
		Menu file = new Menu("File");
		MenuItem fileNew = new MenuItem("New");
		MenuItem fileOpen = new MenuItem("Open");
		MenuItem fileSave = new MenuItem("Save");
		MenuItem fileLoad = new MenuItem("Load");
		MenuItem fileExit = new MenuItem("Exit");

		fileExit.setOnAction(Event -> {
			Exit.exit();
		});

		file.getItems().addAll(fileNew, fileOpen, fileSave, fileLoad, fileExit);
		bar.getMenus().add(file);

	}

	@Override
	public Node getTool() {
		// TODO Auto-generated method stub
		return bar;
	}

}
