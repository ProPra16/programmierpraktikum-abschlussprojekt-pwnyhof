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
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainScreenController {
	private Stage stage;
	private ConfigReader config = null;
	private File testfile;
	private File codefile;
	private Program program;
	private String contentOfPhase;
	private Timer timer;
	private boolean firstTest;
	private long babystepDuration;
	protected static Tracking MyProgress = new Tracking();

	@FXML
	public MenuItem neu, load, saveTest, saveCode, exit, catalog;

	@FXML
	public Button runTest, fieldClear, runCode, clear, nextTest, run;

	@FXML
	public Button nextCode, currentPhase, tracking;

	@FXML
	public TextArea leftTA, rightTA, console;

	@FXML
	public TextField commandField;

	@FXML
	public void handleMenuItem(ActionEvent e) {
		Console con = new Console(console);
		PrintStream out = new PrintStream(con, true);
		System.setOut(out);

		if (e.getSource() == neu) {
			leftTA.clear();
			rightTA.clear();
		}

		if (e.getSource() == catalog) {

			disableCode();

			final DirectoryChooser ExerciseFolder = new DirectoryChooser();
			File initialDirectory = new File("./Task");
			ExerciseFolder.setInitialDirectory(initialDirectory);
			String sfolder = "";

			final File selectedDirectory = ExerciseFolder.showDialog(stage);
			if (selectedDirectory != null) {
				sfolder = selectedDirectory.getName();
			}

			if (!sfolder.isEmpty()) {
				MyProgress.clearLists();
				config = new ConfigReader(sfolder);
				loadMethod();
				firstTest = true;
				if(config.withBabysteps()){
					babystepDuration = config.timeOfBabysteps();
				}
				
			}
			codefile = new File(config.getPath() + config.getProgramName() + ".java");
			testfile = new File(config.getPath() + config.getTestName() + ".java");
		}
		if (e.getSource() == load) {
			loadMethod();
		}

		if (e.getSource() == saveTest) {

			try {
				SaveFile(rightTA.getText(), testfile);
			} catch (Exception e1) {
				System.out.println("Keine Uebung ausgewaehlt");
			}
		}

		if (e.getSource() == saveCode) {

			try {
				SaveFile(leftTA.getText(), codefile);
			} catch (Exception e1) {
				System.out.println("Keine Uebung ausgewaehlt");
			}
		}

		if (e.getSource() == exit) {
			System.exit(0);
		}
	}

	// Button Methods
	@FXML
	public void handleButton(ActionEvent e) throws IOException {
		Console con = new Console(console);
		PrintStream out = new PrintStream(con, true);
		System.setOut(out);

		try {
			Information info = new Information(config.getTestName(), config.getProgramName(),
					"./Task/" + config.getTask() + "/");

			program = new Program(info, console);

		} catch (NullPointerException e3) {
			if (e.getSource() != clear && e.getSource() != fieldClear && e.getSource() != tracking){
				System.out.println("Bitte waehlen Sie eine Uebung aus");
				return;
			}
		}

		if (e.getSource() == runCode) {
			try {
				SaveFile(leftTA.getText(), codefile);
				program.compile();
				int zeroFails = program.test();

				if (zeroFails == 0) {
					try {
						nextCode.setDisable(false);
						currentPhase.setBackground(
								new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
						timer.stopTimer();
					} catch (NullPointerException e2) {

					}
				}
			} catch (NullPointerException e1) {

			}
		}

		if (e.getSource() == runTest) {
			try {
				SaveFile(rightTA.getText(), testfile);
				program.compile();
				int oneFail = program.test();
				if (oneFail == 1) {
					try {
						nextTest.setDisable(false);
					} catch (NullPointerException e2) {
					}

				}
			} catch (NullPointerException e1) {

			}
		}

		if (e.getSource() == run) {
			try {

				program.compile();

				program.run(" " + commandField.getText());

			} catch (NullPointerException e1) {

			}
		}

		if (e.getSource() == clear) {
			console.clear();
		}
		if (e.getSource() == fieldClear) {
			commandField.clear();
		}

		if (e.getSource() == nextTest) {
			try {
				SaveFile(rightTA.getText(), testfile);
				int oneFail = program.test();

				if (oneFail == 1) {
					try {

						MyProgress.addToTestList(rightTA.getText());
						disableTest();
						if(config.withBabysteps()){
							if(!firstTest){
								timer.stopTimer();
							}
							timer = new Timer(this, babystepDuration);
							contentOfPhase = leftTA.getText();
							firstTest = false;
						}
					} catch (NullPointerException e2) {

					}
				}
			} catch (NullPointerException e1) {

			}
		}

		if (e.getSource() == nextCode) {
			try {
				SaveFile(leftTA.getText(), codefile);
				int zeroFails = program.test();

				if (zeroFails == 0) {
					try {
						MyProgress.addToCodeList(leftTA.getText());
						disableCode();
						if(config.withBabysteps()){
							timer = new Timer(this, babystepDuration);
							contentOfPhase = rightTA.getText();
						}
					} catch (NullPointerException e2) {

					}
				}
			} catch (NullPointerException e1) {

			}
		}
		
		if (e.getSource() == tracking) {
			showTrackingWindow();
		}
	}

	private void loadMethod() {
		Console con = new Console(console);
		PrintStream out = new PrintStream(con, true);
		System.setOut(out);

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
			if (code != null) MyProgress.addToCodeList(leftTA.getText() + code);
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
			if (test != null) MyProgress.addToTestList(rightTA.getText() + test);
			testLoad.close();
		} catch (IOException ex) {

		} catch (NullPointerException e1) {
			System.out.println("Please choose an exercise!");
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
	
	public void timerLapsed(){
		if(leftTA.isDisabled()){
			rightTA.setText(contentOfPhase);
			SaveFile(contentOfPhase, testfile);
			
			disableTest();
		}
		else if(rightTA.isDisabled()){
			leftTA.setText(contentOfPhase);
			SaveFile(contentOfPhase, codefile);
			disableCode();
		}
	}
	
	private void disableTest(){
		runCode.setDisable(false);
		leftTA.setDisable(false);
		runTest.setDisable(true);
		rightTA.setDisable(true);
		nextCode.setDisable(true);
		currentPhase.setBackground(
				new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void disableCode(){
		runCode.setDisable(true);
		nextCode.setDisable(true);
		leftTA.setDisable(true);
		runTest.setDisable(false);
		rightTA.setDisable(false);
		nextTest.setDisable(true);
		currentPhase.setBackground(
				new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void showTrackingWindow(){
		try {
			
			Stage trackingStage = new Stage();
			BorderPane base = FXMLLoader.load(getClass().getResource("TrackingScreen.fxml"));
			Scene scene = new Scene(base);
			
			TrackingScreenController tracking = new TrackingScreenController();
			tracking.setMain(this);

			trackingStage.setTitle("Tracking");
			trackingStage.setScene(scene);

			trackingStage.show();
			
		} catch (IOException e) {
			System.out.println("Error while loading the Tracking-Window!");
		}
	}
	
	

}
