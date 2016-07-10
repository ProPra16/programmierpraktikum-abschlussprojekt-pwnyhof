package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD

=======
>>>>>>> refs/heads/master
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainScreenController {
	private Stage stage;
	private ConfigReader config = null;

	@FXML
	public MenuItem neu, load, saveTest, saveCode, exit, catalog;

	@FXML
<<<<<<< HEAD
	public Button runTest, fieldClear, runCode, clear, nextTest;

	@FXML
	public Button nextCode;
=======
	public Button runTest, fieldClear, runCode, clear, nextTest, run;
>>>>>>> refs/heads/master

	@FXML
	public Button nextCode, currentPhase;

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
			
			runCode.setDisable(true);
			nextCode.setDisable(true);
			leftTA.setDisable(true);
			runTest.setDisable(false);
			rightTA.setDisable(false);
			nextTest.setDisable(true);
			currentPhase.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

			final DirectoryChooser ExerciseFolder = new DirectoryChooser();
			File initialDirectory = new File("./Task");
			ExerciseFolder.setInitialDirectory(initialDirectory);
			String sfolder = "";

			final File selectedDirectory = ExerciseFolder.showDialog(stage);
			if (selectedDirectory != null) {
				sfolder = selectedDirectory.getName();
			}

			if (!sfolder.isEmpty()) {
				config = new ConfigReader(sfolder);
				loadMethod();
			}

		}
		if (e.getSource() == load) {
			loadMethod();
		}

		if (e.getSource() == saveTest) {

			File testfile = new File(config.getPath() + config.getTestName() + ".java");

			if (testfile != null) {
				SaveFile(rightTA.getText(), testfile);
			}
		}

		if (e.getSource() == saveCode) {

			File codefile = new File(config.getPath() + config.getProgramName() + ".java");

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

			try {
				Information info = new Information(config.getTestName(), config.getProgramName(),
						"./Task/" + config.getTask() + "/");

				Program program = new Program(info, console);

				int zeroFails = program.test();
				
				if (zeroFails == 0) {
					try {
						nextCode.setDisable(false);
					} catch (NullPointerException e2) {

<<<<<<< HEAD
			boolean codeTrue = program.compile();

			if (codeTrue) {
				try {
					nextCode.setDisable(false);
				} catch (NullPointerException e2) {

				}
=======
					}
				}

			} catch (NullPointerException e1) {
				System.out.println("Bitte waehlen Sie eine Übung aus");

>>>>>>> refs/heads/master
			}

		}

		if (e.getSource() == runTest) {

			try {
				Information info = new Information(config.getTestName(), config.getProgramName(),
						"./Task/" + config.getTask() + "/");

				Program program = new Program(info, console);

				int oneFail = program.test();
				if (oneFail == 1) {
					try {
						nextTest.setDisable(false);
					} catch (NullPointerException e2) {
					}

<<<<<<< HEAD
			boolean testTrue = program.test();
			if (testTrue) {
				try {
					nextTest.setDisable(false);
				} catch (NullPointerException e2) {
=======
>>>>>>> refs/heads/master
				}
<<<<<<< HEAD
=======
			} catch (NullPointerException e1) {
				System.out.println("Bitte waehlen Sie eine Übung aus");
>>>>>>> refs/heads/master

			}

		}
		
		if (e.getSource() == run){
			try {
				Information info = new Information(config.getTestName(), config.getProgramName(),
						"./Task/" + config.getTask() + "/");

				Program program = new Program(info, console);
				
				program.compile();

				program.run(" " + commandField.getText());

			} catch (NullPointerException e1) {
				System.out.println("Bitte waehlen Sie eine Übung aus");

			}
		}
		
		if (e.getSource() == clear) {
			console.clear();
		}
		if (e.getSource() == fieldClear) {
			commandField.clear();
		}

		if (e.getSource() == nextTest) {
<<<<<<< HEAD

=======
>>>>>>> refs/heads/master
			runCode.setDisable(false);
			leftTA.setDisable(false);
			runTest.setDisable(true);
			rightTA.setDisable(true);
			nextCode.setDisable(true);
			currentPhase.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

		if (e.getSource() == nextCode) {
			runCode.setDisable(true);
			nextCode.setDisable(true);
			leftTA.setDisable(true);
			runTest.setDisable(false);
			rightTA.setDisable(false);
			nextTest.setDisable(true);
			currentPhase.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
	
	private void loadMethod() {
		try {
			leftTA.setText("");
			BufferedReader codeLoad = new BufferedReader(
					new FileReader(config.getPath() + config.getProgramName() + ".java"));
			String code = null;
			while ((code = codeLoad.readLine()) != null) {
				if (!code.startsWith("#")) {
					leftTA.setText(leftTA.getText() + code + "\n");
				}
			}
			codeLoad.close();

			rightTA.setText("");
			BufferedReader testLoad = new BufferedReader(
					new FileReader(config.getPath() + config.getTestName() + ".java"));
			String test = null;
			while ((test = testLoad.readLine()) != null) {
				if (!test.startsWith("#")) {
					rightTA.setText(rightTA.getText() + test + "\n");
				}
			}
			testLoad.close();
		} catch (IOException ex) {

		} catch (NullPointerException e1) {
			System.out.println("Bitte waehlen Sie eine Übung aus (du Lappen)");
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