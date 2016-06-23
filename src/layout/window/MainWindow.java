package layout.window;

import javafx.scene.layout.GridPane;
import layout.tools.Red;

public class MainWindow{

	public static void buildWindow(GridPane root){
		Red red = new Red(0, 0, 1, 1);
		root.add(red.getTool(), 0, 0, 1, 1);
	}
	

}
