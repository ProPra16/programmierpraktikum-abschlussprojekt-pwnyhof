package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.smartcardio.CommandAPDU;

import de.hhu.propra16.tddt.TDDTStart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;<<<<<<<HEAD
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;=======>>>>>>>refs/heads/master
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainScreenController {
	Runtime rt = Runtime.getRuntime();
	private Stage stage;<<<<<<<
	HEAD String commandLine="";=======
	String commandLine = " ";>>>>>>>refs/heads/master

	@FXML
	public MenuItem neu;

	@FXML
	public MenuItem loadCode;

	@FXML
	public MenuItem loadTest;

	@FXML
	public MenuItem saveTest;

	@FXML
	public MenuItem saveCode;

	@FXML
	public MenuItem exit;

	@FXML
	public MenuItem catalog;

	@FXML
	public Button runTest;

	@FXML
	public Button runCommand;

	@FXML
	public Button runWithCommand;

	@FXML
	public Button runCode;

	@FXML
	public Button clear;

	@FXML
	public TextArea leftTA;

	@FXML
	public TextArea rightTA;

	@FXML
	public TextField commandField;

	@FXML
	public TextArea console;

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

			File file = fileChooser.showOpenDialog(stage);
		}
		if (e.getSource() == loadCode) {

			FileChooser fileChooser = new FileChooser();

			File initialDirectory = new File("./Task");
			fileChooser.setInitialDirectory(initialDirectory);

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
						leftTA.setText(leftTA.getText() + zeile + "\n");
					}
				}
				bufferedLoad.close();
			} catch (IOException ex) {

			}

		}
		if (e.getSource() == loadTest) {

			FileChooser fileChooser = new FileChooser();
			File initialDirectory = new File("./Task");
			fileChooser.setInitialDirectory(initialDirectory);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(stage);
			// System.out.println(file);

			try {
				rightTA.setText("");
				BufferedReader bufferedLoad = new BufferedReader(new FileReader(file));
				String zeile = null;
				while ((zeile = bufferedLoad.readLine()) != null) {
					if (!zeile.startsWith("#")) {
						rightTA.setText(rightTA.getText() + "\n" + zeile);
					}
				}
				bufferedLoad.close();
			} catch (IOException ex) {

			}
		}
		if (e.getSource() == saveTest) {

			FileChooser testFileChooser = new FileChooser();
			File initialDirectory = new File("./Task");
			testFileChooser.setInitialDirectory(initialDirectory);
			FileChooser.ExtensionFilter testExtFilter = new FileChooser.ExtensionFilter("Java files (*.java)",
					"*.java");
			testFileChooser.getExtensionFilters().add(testExtFilter);
			File testFile = testFileChooser.showOpenDialog(stage);

			// if file doesnt exists, then create it
			if (testFile != null) {
				SaveFile(rightTA.getText(), testFile);
			}
		}

		if (e.getSource() == saveCode) {
			// TODO: CTRL + S fuer save
			// saveCode.setAccelerator(new KeyCodeCombination(KeyCode.S,
			// KeyCombination.CONTROL_DOWN));

			FileChooser codeFileChooser = new FileChooser();
			File initialDirectory = new File("./Task");
			codeFileChooser.setInitialDirectory(initialDirectory);
			FileChooser.ExtensionFilter codeExtFilter = new FileChooser.ExtensionFilter("Java files (*.java)",
					"*.java");
			codeFileChooser.getExtensionFilters().add(codeExtFilter);
			File codefile = codeFileChooser.showOpenDialog(stage);

			// Show save file dialog

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

		if (e.getSource() == runCode) {

			// Schickt den Output auf die TextArea "console"
			Console con = new Console(console);
			PrintStream out = new PrintStream(con, true);
			System.setOut(out);

			ConfigReader config = new ConfigReader("Aufgabe1");

			Information info = new Information(config.getTestName(), config.getProgramName(),
					"./Task/" + config.getTask() + "/");

			Program program = new Program(info, console);

			program.compile();

			program.run(commandLine);

		}
		if (e.getSource() == runTest) {

			// Schickt den Output auf die TextArea "console"
			Console con = new Console(console);
			PrintStream out = new PrintStream(con, true);
			System.setOut(out);

			ConfigReader config = new ConfigReader("Aufgabe1");

			Information info = new Information(config.getTestName(), config.getProgramName(),
					"./Task/" + config.getTask() + "/");

			Program program = new Program(info, console);

			program.test();

		}
		if (e.getSource() == clear) {
			console.clear();
		}
		if (e.getSource() == runCommand) {

			try {
				// Load root layout from fxml file.
				AnchorPane command = FXMLLoader.load(getClass().getResource("CommandLineScreen.fxml"));

				// Show the scene containing the root layout.
				Scene scene = new Scene(command);
				Stage commandStage = new Stage();
				commandStage.setScene(scene);

				commandStage.show();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == runWithCommand) {

			// TODO: Ausgabe auf Console
			commandLine = " " + commandField.getText();

			ConfigReader config = new ConfigReader("Aufgabe1");

			Information info = new Information(config.getTestName(), config.getProgramName(),
					"./Task/" + config.getTask() + "/");

			Program program = new Program(info, console);

			program.compile();

			program.run(commandLine);
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
