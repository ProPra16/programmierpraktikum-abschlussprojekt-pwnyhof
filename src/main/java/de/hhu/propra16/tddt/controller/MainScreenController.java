package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.hhu.propra16.tddt.Console;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerResult;
import vk.core.internal.InternalCompiler;

public class MainScreenController {
	Runtime rt = Runtime.getRuntime();
	private static List<String> content;
	private static Path filePath;
	private Stage stage;

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
				// System.err.println(ex);
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
				// System.err.println(ex);
			}
		}
		if (e.getSource() == saveTest) {
			FileChooser testFileChooser = new FileChooser();
			FileChooser.ExtensionFilter testExtFilter = new FileChooser.ExtensionFilter("Java files (*.java)",
					"*.java");
			testFileChooser.getExtensionFilters().add(testExtFilter);
			File testFile = testFileChooser.showOpenDialog(stage);

			// if file doesnt exists, then create it
			if (testFile != null) {
				SaveFile(leftTA.getText(), testFile);
			}
		}

		if (e.getSource() == saveCode) {

			FileChooser codeFileChooser = new FileChooser();
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

			// Liest Programm aus einer Datei
			filePath = Paths.get("./Code/Code.java");
			try {
				content = Files.readAllLines(filePath);

			} catch (IOException e1) {

				createFile();
				System.out.println("Fail");
			}

			// Wandelt den Quellcode in einen String um
			String contentS = "";
			for (int i = 0; i < content.size(); i++) {
				contentS = contentS + content.get(i);
			}

			// Erstellt eine CompilationUnit mit den vorangegangenen Daten
			CompilationUnit unit = new CompilationUnit("Code", contentS, false);
			CompilationUnit[] units = new CompilationUnit[1];
			units[0] = unit;
			InternalCompiler comp = new InternalCompiler(units);

			// Compiliert das Programm imagin�r
			comp.compileAndRunTests();

			// Compiliert das Programm NICHT imagin�r
			Process processCompile = null;
			try {
				processCompile = Runtime.getRuntime().exec("javac ./Code/Code.java");
			} catch (IOException e6) {
				e6.printStackTrace();
			}

			// Solange compiliert wird WARTEN!
			while (processCompile.isAlive()) {

			}

			// Nimmt das Resultat des Compilierens entgegen
			CompilerResult result = comp.getCompilerResult();
			Collection<CompileError> error = result.getCompilerErrorsForCompilationUnit(units[0]);
			CompileError[] array = new CompileError[error.size()];
			error.toArray(array);

			// Gibt Errors aus
			for (int i = 0; i < array.length; i++) {
				console.setText(console.getText() + array[i] + "\n");
			}

			// Wenn es keine Errors gibt wird das Programm gestartet
			if (!result.hasCompileErrors()) {
				Process processRun = null;
				try {
					processRun = Runtime.getRuntime().exec("java -cp ./Code Code");
				} catch (IOException e7) {
					e7.printStackTrace();
				}
				try {
					printLines(" stdout:", processRun.getInputStream());
					printLines(" stderr:", processRun.getErrorStream());
				} catch (Exception e8) {
					e8.printStackTrace();
				}
			}

		}
		if (e.getSource() == runTest) {

		}

	}

	private static void printLines(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
		}
	}

	private static void createFile() {

		filePath = Paths.get("./Code/Code.java");
		try {
			Files.createFile(filePath);
		}

		catch (IOException e) {
			System.out.print("Der gegebene Dateipfad ist falsch!\n");
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
