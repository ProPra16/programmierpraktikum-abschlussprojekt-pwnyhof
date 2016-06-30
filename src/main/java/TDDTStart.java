
import javafx.application.Application;
import javafx.stage.Stage;
import main.TDDTMain;

public class TDDTStart extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		TDDTMain.mainWindow(primaryStage);
	}
}
