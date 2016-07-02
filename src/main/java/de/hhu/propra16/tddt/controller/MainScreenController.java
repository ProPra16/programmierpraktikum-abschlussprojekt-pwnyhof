package de.hhu.propra16.tddt.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	public Button runTest;

	@FXML
	public Button runCode;

	@FXML
	public TextArea leftTA;

	@FXML
	public TextArea rightTA;

	@FXML
	public TextArea console;

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
	public void handleButton(ActionEvent e) throws IOException {
		if (e.getSource() == runCode) {

			rightTA.setText(leftTA.getText());
			return;

		}
		if (e.getSource() == runTest) {
			
			/*
			try {

				
				String content = rightTA.getText();

				File file = new File("C:/Users/Han/Desktop/Data/Test1.java");

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();

				System.out.println("Done");
				

			} catch (IOException ee) {
				ee.printStackTrace();
			}
			*/
			// Runtime rt = Runtime.getRuntime();
			// Process pr = rt.exec("javac Test.java");
			// JUnitCore junit = new JUnitCore();
			// Result result = junit.run(pr.getClass());
		}
		
	}

}
