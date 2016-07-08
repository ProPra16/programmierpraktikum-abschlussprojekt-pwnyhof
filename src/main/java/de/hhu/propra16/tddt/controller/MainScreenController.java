package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainScreenController {
	Runtime rt = Runtime.getRuntime();
	private Stage stage;

	String commandLine = " ";

	@FXML
	public MenuItem neu, load, saveTest, saveCode, exit, catalog;

	@FXML
	public Button runTest, fieldClear, runCode, clear, nextTest;
	
	@FXML
	public Button nextCode;

	@FXML

	public TextArea leftTA, rightTA, console;

	@FXML

	public TextField commandField;

	@FXML
	public void handleMenuItem(ActionEvent e) {

		if (e.getSource() == neu) {

			leftTA.clear();
			rightTA.clear();
		}

		if (e.getSource() == catalog) {
			FileChooser fileChooser = new FileChooser();

			File initialDirectory = new File("./Task");
			fileChooser.setInitialDirectory(initialDirectory);

			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
			fileChooser.getExtensionFilters().add(extFilter);

			fileChooser.showOpenDialog(stage);
		}
		if (e.getSource() == load) {

			try {
				leftTA.setText("");
				BufferedReader codeLoad = new BufferedReader(new FileReader("./Task/Aufgabe1/Code.java"));
				String code = null;
				while ((code = codeLoad.readLine()) != null) {
					if (!code.startsWith("#")) {
						leftTA.setText(leftTA.getText() + code + "\n");
					}
				}
				codeLoad.close();

				rightTA.setText("");
				BufferedReader testLoad = new BufferedReader(new FileReader("./Task/Aufgabe1/Try.java"));
				String test = null;
				while ((test = testLoad.readLine()) != null) {
					if (!test.startsWith("#")) {
						rightTA.setText(rightTA.getText() + test + "\n");
					}
				}
				testLoad.close();
			} catch (IOException ex) {

			}

		}

		if (e.getSource() == saveTest) {

			File testfile = new File("./Task/Aufgabe1/Try.java");

			if (testfile != null) {
				SaveFile(rightTA.getText(), testfile);
			}
		}

		if (e.getSource() == saveCode) {

			File codefile = new File("./Task/Aufgabe1/Code.java");

			if (codefile != null) {
				SaveFile(leftTA.getText(), codefile);
			}

		}

		if (e.getSource() == exit) {
			System.exit(0);
		}
	}

	@FXML
	public void handleButton(ActionEvent e) throws IOException {
		Console con = new Console(console);
		PrintStream out = new PrintStream(con, true);
		System.setOut(out);
		if (e.getSource() == runCode) {

			ConfigReader config = new ConfigReader("Aufgabe1");

			Information info = new Information(config.getTestName(), config.getProgramName(),
					"./Task/" + config.getTask() + "/");

			Program program = new Program(info, console);

			boolean codeTrue = program.compile();
			
			if(codeTrue) {
				try {
				nextCode.setDisable(false);
				} catch (NullPointerException e2) {
					
				}	
			}

			program.run(" " + commandField.getText());

		}
		if (e.getSource() == runTest) {

			ConfigReader config = new ConfigReader("Aufgabe1");

			Information info = new Information(config.getTestName(), config.getProgramName(),
					"./Task/" + config.getTask() + "/");

			Program program = new Program(info, console);

			boolean testTrue = program.test();
			if(testTrue) {
				try {
				nextTest.setDisable(false);
				} catch (NullPointerException e2) {	
				}
				
			}
			
			
		}
		if (e.getSource() == clear) {
			console.clear();
		}
		if (e.getSource() == fieldClear) {
			commandField.clear();
		}
		
		if(e.getSource() == nextTest){
			runCode.setDisable(false);
			leftTA.setDisable(false);
			runTest.setDisable(true);
			rightTA.setDisable(true);
			nextCode.setDisable(true);
		}
		
		if(e.getSource() == nextCode){
			runCode.setDisable(true);
			leftTA.setDisable(true);
			runTest.setDisable(false);
			rightTA.setDisable(false);
			nextTest.setDisable(true);
		}

	}

	private void SaveFile(String content, File file) {
		try {
			FileWriter fileWriter;

			fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException ex) {
			Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
