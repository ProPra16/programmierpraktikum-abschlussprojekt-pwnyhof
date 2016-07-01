package layout.tools;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class MainScreenController {

	@FXML
	public MenuItem neu;

	@FXML
	public MenuItem load;

	@FXML
	public MenuItem save;

	@FXML
	public MenuItem exit;

	@FXML
	public Button start;

	@FXML
	public Button runTest;

	@FXML
	public Button runCode;

	@FXML
	public TextArea leftTA;

	@FXML
	public TextArea rightTA;

	@FXML
	public void handleMenuItem(ActionEvent e) {
		if (e.getSource() == neu) {

		}
		if (e.getSource() == load) {

		}
		if (e.getSource() == save) {

		}
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}

	@FXML
	public void handleButton(ActionEvent e) {
		if (e.getSource() == runCode) {

			rightTA.setText(leftTA.getText());
			return;

		}
		if (e.getSource() == load) {

		}
		if (e.getSource() == save) {

		}
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}

}
