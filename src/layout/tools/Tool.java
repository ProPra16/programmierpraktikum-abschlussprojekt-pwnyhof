package layout.tools;

import javafx.scene.Node;

public interface Tool {

	public Node getTool();
	public int getColumnIndex();
	public int getRowIndex();
	public int getColSpan();
	public int getRowSpan();
}
