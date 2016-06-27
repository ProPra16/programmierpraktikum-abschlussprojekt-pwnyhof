package de.hhu.propra16.abschlussprojekt.layout.window;

import javafx.scene.layout.GridPane;
import de.hhu.propra16.abschlussprojekt.layout.tools.Bar;
import de.hhu.propra16.abschlussprojekt.layout.tools.Red;

public class MainWindow{

	public static void buildWindow(GridPane root){
		Red red = new Red();
		root.add(red.getTool(), 0, 1);
		
		Bar menubar = new Bar();
		root.add(menubar.getTool(), 0, 0, 2, 1);
	}
	

}
