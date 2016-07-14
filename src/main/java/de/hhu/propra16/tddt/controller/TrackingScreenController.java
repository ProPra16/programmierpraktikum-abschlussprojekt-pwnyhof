package de.hhu.propra16.tddt.controller;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
/**
 * Controller for Tracking Tool
 * @author group pwnyhof
 *
 */
public class TrackingScreenController {

	private MainScreenController main;
	private boolean CodeTestSwitch = true; // code - 0, test - 1
	private boolean TASwitch = true; // rechts - 0, links - 1
	private int counter = 0;

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
 * @param e an ActionEvent
 * @throws IOException 
 * 
 * each if-statement with e.getSource() determines what should be done next
 * based on which button was clicked
 */
	@FXML
	public void handleButton(ActionEvent e) throws IOException {
		if (e.getSource() == test) {
			counter = 0;
			CodeTestSwitch = true;
			TALeft.setText("");
			TARight.setText("");
		}

		if (e.getSource() == code) {
			counter = 0;
			CodeTestSwitch = false;
			TALeft.setText("");
			TARight.setText("");
		}
		/**
		 * for e == next there are two possible cases to handle depending if CodeTestSwitch
		 * is true or not
		 */
		if (e.getSource() == next) {
			if (!CodeTestSwitch) {
				if (counter < main.MyProgress.getCodeSize()) {
					if (TASwitch) {
						TASwitch = !TASwitch;
						TALeft.setText(main.MyProgress.getCode(counter));
						counter = counter + 1;
					} else {
						TASwitch = !TASwitch;
						TARight.setText(main.MyProgress.getCode(counter));
						counter = counter + 1;
					}
				}

			} else if (CodeTestSwitch) {
				if (counter < main.MyProgress.getTestSize()) {
					if (TASwitch) {
						TASwitch = !TASwitch;
						TALeft.setText(main.MyProgress.getTest(counter));
						counter = counter + 1;
					} else {
						TASwitch = !TASwitch;
						TARight.setText(main.MyProgress.getTest(counter));
						counter = counter + 1;
					}
				}
			}
		}
		/**
		 * for e == back there are two possible cases to handle depending if CodeTestSwitch
		 * is true or not
		 */
		if (e.getSource() == back) {
			if (!CodeTestSwitch) {
				if (counter > 0) {
					if (TASwitch) {
						TASwitch = !TASwitch;
						counter = counter - 1;
						TALeft.setText(main.MyProgress.getCode(counter));
					} else {
						TASwitch = !TASwitch;
						counter = counter - 1;
						TARight.setText(main.MyProgress.getCode(counter));
					}
				}

			} else if (CodeTestSwitch) {
				if (counter > 0) {
					if (TASwitch) {
						TASwitch = !TASwitch;
						counter = counter - 1;
						TALeft.setText(main.MyProgress.getTest(counter));
					} else {
						TASwitch = !TASwitch;
						counter = counter - 1;
						TARight.setText(main.MyProgress.getTest(counter));
					}
				}
			}
		}
	}
}
