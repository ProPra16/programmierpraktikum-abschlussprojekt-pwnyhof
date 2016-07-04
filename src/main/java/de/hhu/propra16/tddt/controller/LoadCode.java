package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LoadCode {

	
	private static Stage stage;
	
	@FXML
	private static TextArea leftTA;

	@FXML
	public static void load() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(stage);
		// System.out.println(file);

		try {
			leftTA.setText("");
			BufferedReader bufferedLoad = new BufferedReader(new FileReader(file));
			String zeile = null;
			while ((zeile = bufferedLoad.readLine()) != null) {
				if (!zeile.startsWith("#")) {
					leftTA.setText(leftTA.getText() + "\n" + zeile);
				}
			}
			bufferedLoad.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
