package layout.tools;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StartButton implements Initializable {

	@FXML
	private final Button startButton = new Button();

	@Override // This method is called by the FXMLLoader when initialization is
				// complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert startButton != null : "fx:id=\"start\" was not injected: check your FXML file 'StartLayout.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("That was easy, wasn't it?");
			}
		});
	}
}