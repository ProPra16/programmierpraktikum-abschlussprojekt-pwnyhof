package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import de.hhu.propra16.tddt.Console;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerResult;
import vk.core.internal.InternalCompiler;

public class MainScreenController {
	Runtime rt = Runtime.getRuntime();
	private static List<String> content;
	private static Path filePath;
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
			try {
				BufferedReader bufferedLoad = new BufferedReader(new FileReader("./Code/Code.java"));
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
		if (e.getSource() == save) {
			try {

				String test = rightTA.getText();

				File testFile = new File("./Code/Test.java");

				// if file doesnt exists, then create it
				if (!testFile.exists()) {
					testFile.createNewFile();
				}

				FileWriter testFw = new FileWriter(testFile.getAbsoluteFile());
				BufferedWriter testBw = new BufferedWriter(testFw);
				testBw.write(test);
				testBw.close();

				// ************************************************************************************************

				String code = leftTA.getText();

				File codeFile = new File("./Code/Code1.java");

				// if file doesnt exists, then create it
				if (!codeFile.exists()) {
					codeFile.createNewFile();
				}

				FileWriter codeFw = new FileWriter(codeFile.getAbsoluteFile());
				BufferedWriter codeBw = new BufferedWriter(codeFw);
				codeBw.write(code);
				codeBw.close();
				System.out.println("Done");

			} catch (IOException ee) {
				ee.printStackTrace();
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

			// Compiliert das Programm imaginär
			comp.compileAndRunTests();
			
			// Compiliert das Programm NICHT imaginär
			Process processCompile = null;
			try {
				processCompile = Runtime.getRuntime().exec("javac ./Code/Code.java");
			} catch (IOException e6) {
				e6.printStackTrace();
			}

			// Solange compiliert wird WARTEN!
			while (processCompile.isAlive()) {

			}

			//Nimmt das Resultat des Compilierens entgegen
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
		try {
			Files.createFile(filePath);
		}

		catch (IOException e) {
			System.out.print("Der gegebene Dateipfad ist falsch!\n");
		}
	}

}
