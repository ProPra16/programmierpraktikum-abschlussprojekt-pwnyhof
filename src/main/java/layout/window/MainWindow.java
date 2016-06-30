package layout.window;

import javafx.scene.layout.GridPane;
import layout.tools.CodeLabel;
import layout.tools.MainBar;
import layout.tools.TestLabel;
import layout.tools.CodeArea;
import layout.tools.TestArea;
import layout.tools.ToolBar;

public class MainWindow {

	public static GridPane createMainWindow(GridPane gPane){
		
		gPane.add(new MainBar().getTool(), 0, 0, 2, 1);
		
		gPane.add(new ToolBar().getTool(), 0, 1, 2, 1);
		
		gPane.add(new CodeLabel().getTool(), 0, 2, 1, 1);
		
		gPane.add(new TestLabel().getTool(), 1, 2, 1, 1);
		
		gPane.add(new CodeArea().getTool(), 0, 3, 1, 1);
		
		gPane.add(new TestArea().getTool(), 1, 3, 1, 1);
		
		return gPane; 
	}
}
