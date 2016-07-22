package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import javafx.scene.control.TextArea;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerResult;
import vk.core.api.TestFailure;
import vk.core.api.TestResult;
import vk.core.internal.InternalCompiler;

public class Program {
	private TextArea console;
	private CompilerResult result = null;
	private TestResult testResult = null;
	private Information info;
	private Path codeFilePath;
	private Path testFilePath;

	public Program(Information info, TextArea console) {
		this.info = info;
		this.console = console;
		this.codeFilePath = Paths.get(info.getPathToFiles() + info.getCodeFileName() + ".java");
		this.testFilePath = Paths.get(info.getPathToFiles() + info.getTestFileName() + ".java");

	}

	
	public void compile() {
		// Compiliert das Programm NICHT imaginaer
		Process processCompile = null;
		try {
			processCompile = Runtime.getRuntime().exec("javac " + codeFilePath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Solange compiliert wird: WARTEN!
		while (processCompile.isAlive()) {

		}

		// Liest Programm aus einer Datei
		List<String> content;
		try {
			content = Files.readAllLines(codeFilePath);

		} catch (IOException e) {
			System.out.println("ERROR: File Path Not Found!");
			return;
		}

		// Wandelt den Quellcode in einen String um
		String contentS = "";
		for (int i = 0; i < content.size(); i++) {
			contentS = contentS + content.get(i);
		}
		// Erstellt eine CompilationUnit mit den vorangegangenen Daten
		CompilationUnit unit = new CompilationUnit(info.getCodeFileName(), contentS, false);
		CompilationUnit[] units = new CompilationUnit[1];
		units[0] = unit;
		InternalCompiler comp = new InternalCompiler(units);

		// Compiliert das Programm imaginaer
		comp.compileAndRunTests();

		// Nimmt das Resultat des Compilierens entgegen
		result = comp.getCompilerResult();
		Collection<CompileError> error = result.getCompilerErrorsForCompilationUnit(units[0]);
		CompileError[] array = new CompileError[error.size()];
		error.toArray(array);

		// Gibt Errors aus
		for (int i = 0; i < array.length; i++) {
			console.setText(console.getText() + array[i].toString() + "\n");
		}
	}
/**
 * run method (button in the bottom left corner from the GUI)
 * @param args gives the possibility to run a code with parameters like you can do on terminal
 * runs the program when there are no errors within compilation
 */
	public void run(String args) {
		if (result != null && !result.hasCompileErrors()) {
			Process processRun = null;
			try {
				processRun = Runtime.getRuntime()
						.exec("java -cp " + info.getPathToFiles() + " " + info.getCodeFileName() + args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				println(processRun.getInputStream());
				println(processRun.getErrorStream());

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public int test() {
		// Liest Programm aus einer Datei
		List<String> contentTest;
		List<String> contentCode;
		try {
			contentTest = Files.readAllLines(testFilePath);
			contentCode = Files.readAllLines(codeFilePath);

		} catch (IOException e) {
			System.out.println("ERROR: File Path Not Found!");
			return -1;
		}

		// Wandelt den Testcode in einen String um
		String contentTestInString = "";
		for (int i = 0; i < contentTest.size(); i++) {
			contentTestInString = contentTestInString + contentTest.get(i);
		}

		String contentCodeInString = "";
		for (int i = 0; i < contentCode.size(); i++) {
			contentCodeInString = contentCodeInString + contentCode.get(i);
		}

		// Erstellt eine CompilationUnit mit den vorangegangenen Daten
		CompilationUnit unitTest = new CompilationUnit(info.getTestFileName(), contentTestInString, true);
		CompilationUnit unitCode = new CompilationUnit(info.getCodeFileName(), contentCodeInString, false);
		CompilationUnit[] units = new CompilationUnit[2];
		units[0] = unitTest;
		units[1] = unitCode;
		InternalCompiler comp = new InternalCompiler(units);

		// Laesst die Tests laufen
		comp.compileAndRunTests();

		// Nimmt das Resultat des Compilierens entgegen
		result = comp.getCompilerResult();
		Collection<CompileError> errorCode = result.getCompilerErrorsForCompilationUnit(units[0]);
		CompileError[] arrayCode = new CompileError[errorCode.size()];
		errorCode.toArray(arrayCode);

		// Gibt Errors aus
		for (int i = 0; i < arrayCode.length; i++) {
			console.setText(console.getText() + arrayCode[i].toString() + "\n");
		}

		testResult = comp.getTestResult();
		Collection<TestFailure> errorTest = testResult.getTestFailures();
		TestFailure[] arrayTest = new TestFailure[errorTest.size()];
		errorTest.toArray(arrayTest);

		// Gibt Errors aus
		for (int i = 0; i < arrayTest.length; i++) {
			console.setText(console.getText() + arrayTest[i].getMessage() + "\n");
		}
		
		int numberFailed = testResult.getNumberOfFailedTests();
		
		if (numberFailed == 0) {
			Duration testDur = testResult.getTestDuration();
			testDur.toString();
			System.out.println(testDur + "\n" + "All tests succesfull! Congratulations!");
			if(numberFailed == 0) {
				return 0;
			}
		}
		if (numberFailed != 0) {
			int numberIgn = testResult.getNumberOfIgnoredTests();
			int numberSuccess = testResult.getNumberOfSuccessfulTests();
			Duration testDur = testResult.getTestDuration();
			testDur.toString();
			System.out.println(testDur + "\n" + "Number of failed tests: " + numberFailed + "\n"
					+ "Number of ignored tests: " + numberIgn + "\n" + "Number of successful tests: " + numberSuccess);
			
			if(numberFailed == 1) {
				return 1;
			}
		}
		
		return -1;
	}

	private void println(InputStream inStream) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
	}

}
