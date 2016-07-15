package de.hhu.propra16.tddt.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * Controller for Tracking Tool
 * 
 * @author group pwnyhof
 *
 */
public class TrackingScreenController {

	private MainScreenController main;
	private boolean CodeTestSwitch = true; // code - false, test - true
	private int counter = 1;

	@FXML
	public TextArea TALeft;

	@FXML
	public TextArea TARight;

	@FXML
	public Button code;

	@FXML
	public Button test;

	@FXML
	public Button back;

	@FXML
	public Button next;

	@FXML
	public Label timeLeft;

	@FXML
	public Label timeRight;

	public void setMain(MainScreenController main) {
		this.main = main;

	}

	/**
	 * method is called with
	 * 
	 * @param ActionEvent
	 * @throws IOException
	 * 
	 * each if-statement with e.getSource() determines what should
	 * be done next based on which button was clicked
	 */
	@FXML
	public void handleButton(ActionEvent e) throws IOException {

		if (e.getSource() == test) {
			defaultTest();
		}

		if (e.getSource() == code) {
			defaultCode();
		}
		/**
		 * for e == next there are two possible cases to handle depending if
		 * CodeTestSwitch is true or not
		 */
		if (e.getSource() == next) {
			try {
				if (MainScreenController.config.withBabysteps()) {
					long with = MainScreenController.getBabyStepDuration() / 1000;
					String withBSteps = String.valueOf(with);
					timeLeft.setText(withBSteps);
				}
				if (MainScreenController.config.withoutBabysteps()) {
					long without = MainScreenController.getBabyStepDuration() / 1000;
					String withBSteps = String.valueOf(without);
					timeLeft.setText(withBSteps);
				}
			} catch (NullPointerException eNull) {
			}

			if (!CodeTestSwitch) { // FALSE IST CODE
				if (counter < main.MyProgress.getCodeSize()) {
					counter++;
					TALeft.setText(TARight.getText());
					TARight.setText(main.MyProgress.getCode(counter));
					if (counter == main.MyProgress.getCodeSize() - 1) {
						counter--;
						next.setDisable(true);
					}
					back.setDisable(false);
				}
			}
			if (CodeTestSwitch) { // TRUE IST TEST
				if (counter < main.MyProgress.getTestSize()) {
					counter++;
					TALeft.setText(TARight.getText());
					TARight.setText(main.MyProgress.getTest(counter));
					if (counter == main.MyProgress.getTestSize() - 1) {
						counter--;
						next.setDisable(true);
					}
					back.setDisable(false);
				}
			}
		}
		/**
		 * for e == back there are two possible cases to handle depending if
		 * CodeTestSwitch is true or not
		 */
		if (e.getSource() == back) {
			if (!CodeTestSwitch && counter > 0) { // Code
				TARight.setText(main.MyProgress.getCode(counter));
				TALeft.setText(main.MyProgress.getCode(counter - 1));
				counter--;
				next.setDisable(false);
				if (counter == 0) {
					back.setDisable(true);
					counter++;
				}
			}
			if (CodeTestSwitch && counter > 0) { // Test
				TARight.setText(main.MyProgress.getTest(counter));
				TALeft.setText(main.MyProgress.getTest(counter - 1));
				counter--;
				next.setDisable(false);
				if (counter == 0) {
					back.setDisable(true);
					counter++;
				}
			}
		}
	}

	public void defaultTest() {
		counter = 1; // default werte
		CodeTestSwitch = true;
		TALeft.setText("");
		TARight.setText("");
		next.setDisable(false);

		try {
			TALeft.setText(main.MyProgress.getTest(0));
		} catch (IndexOutOfBoundsException e1) {
			System.out.println("Test[0] does not exist");
		}

		try {
			TARight.setText(main.MyProgress.getTest(1));
		} catch (IndexOutOfBoundsException e2) {
			System.out.println("Test[1] does not exist");
		}
	}

	public void defaultCode() {
		counter = 1; // default werte
		CodeTestSwitch = false;
		TALeft.setText("");
		TARight.setText("");
		next.setDisable(false);

		try {
			TALeft.setText(main.MyProgress.getCode(0));
		} catch (IndexOutOfBoundsException e1) {
			System.out.println("Code[0] does not exist");
		}

		try {
			TARight.setText(main.MyProgress.getCode(1));
		} catch (IndexOutOfBoundsException e2) {
			System.out.println("Code[1] does not exist");
		}
	}

}
