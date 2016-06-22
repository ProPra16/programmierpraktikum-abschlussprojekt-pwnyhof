package layout.window;

import javafx.scene.layout.GridPane;
import layout.tools.Red;

public class MainWindow{

	public static void buildWindow(GridPane root){
		Red red = new Red();
		root.add(red.getTool(), red.getColumnIndex(), red.getRowIndex(), red.getColSpan(), red.getRowSpan());
	}
	

}
