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
			try {

				String test = rightTA.getText();

				File testFile = new File("./Test/Test.java");

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

				File codeFile = new File("./Code/Code.java");

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
	public void handleButton(ActionEvent e) {
		if (e.getSource() == runCode) {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("javac  ./Code.java");
				rt.exec("java  ./Code/Code");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == runTest) {

		}

	}

}
