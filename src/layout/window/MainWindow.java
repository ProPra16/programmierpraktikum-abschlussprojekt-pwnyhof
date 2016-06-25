package layout.window;

import javafx.scene.layout.GridPane;
import layout.tools.Bar;
import layout.tools.Red;

public class MainWindow{

	public static void buildWindow(GridPane root){
		Red red = new Red();
		root.add(red.getTool(), 0, 1);
		
		
		Bar menubar = new Bar();
		root.add(menubar.getTool(), 0, 0, 2, 1);
	}
	

}
