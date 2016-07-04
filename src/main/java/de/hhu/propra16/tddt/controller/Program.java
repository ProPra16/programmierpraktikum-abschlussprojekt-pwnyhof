package de.hhu.propra16.tddt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import javafx.scene.control.TextArea;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerResult;
import vk.core.internal.InternalCompiler;

public class Program {
	private final String programName;
	private final String pathToDir;
	private final Path pathToFile;
	private TextArea console;
	private CompilerResult result = null;
	
	public Program(String programName, String pathToDir, TextArea console){
		this.programName = programName;
		this.pathToDir = pathToDir;
		this.pathToFile = Paths.get(pathToDir + programName + ".java");
		this.console = console;
		
		try {
			Files.exists(pathToFile);
			if(Files.isDirectory(pathToFile)){
				createFile();
			}

		} catch (Exception e) {
			createFile();
		}
	}
	
	public void compile(){
		// Liest Programm aus einer Datei
		List<String> content;
		try {
			content = Files.readAllLines(pathToFile);

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
		CompilationUnit unit = new CompilationUnit(programName, contentS, false);
		CompilationUnit[] units = new CompilationUnit[1];
		units[0] = unit;
		InternalCompiler comp = new InternalCompiler(units);

		// Compiliert das Programm imaginär
		comp.compileAndRunTests();
		
		// Compiliert das Programm NICHT imaginär
		Process processCompile = null;
		try {
			processCompile = Runtime.getRuntime().exec("javac " +pathToFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Solange compiliert wird: WARTEN!
		while (processCompile.isAlive()) {

		}
		
		//Nimmt das Resultat des Compilierens entgegen
		result = comp.getCompilerResult();
		Collection<CompileError> error = result.getCompilerErrorsForCompilationUnit(units[0]);
		CompileError[] array = new CompileError[error.size()];
		error.toArray(array);

		// Gibt Errors aus
		for (int i = 0; i < array.length; i++) {
			console.setText(console.getText()  +array[i].toString() +"\n");
		}
	}
	
	public void run(){
		// Wenn es keine Errors gibt wird das Programm gestartet
		if (result != null && !result.hasCompileErrors()) {
			Process processRun = null;
			try {
				processRun = Runtime.getRuntime().exec("java -cp " + pathToDir +" " + programName);
			} catch (IOException e) {
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
	
	public void test(){
		
	}
	
	private void createFile() {
		try {
			Files.createFile(pathToFile);
		}

		catch (IOException e) {
			System.out.print("Der gegebene Dateipfad ist falsch!\n");
		}
	}
	
	private void println(InputStream inStream) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
	}
	
	

}
