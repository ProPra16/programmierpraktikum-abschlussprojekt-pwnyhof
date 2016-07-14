package de.hhu.propra16.tddt.controller;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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

	@FXML
	public void handleButton(ActionEvent e) throws IOException {
		if (e.getSource() == test) {
			counter = 0;	//default werte
			TASwitch = true;
			CodeTestSwitch = true;
			TALeft.setText("");
			TARight.setText("");
		}

		if (e.getSource() == code) {
			counter = 0;	//default werte
			TASwitch = true;
			CodeTestSwitch = false;
			TALeft.setText("");
			TARight.setText("");
		}

		if (e.getSource() == next) {
			if (!CodeTestSwitch) {
				if (counter < main.MyProgress.getCodeSize()) {
					if (!TARight.getText().isEmpty()) {
						TALeft.setText(TARight.getText());
						TARight.setText(main.MyProgress.getCode(counter));
						counter = counter + 1;
					} else {
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
				}
			}
			if (CodeTestSwitch) {
				if (counter < main.MyProgress.getTestSize()) {
					if (counter > 1) {
						TALeft.setText(TARight.getText());
						TARight.setText(main.MyProgress.getTest(counter));
						counter = counter + 1;
					} else {
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
		}

		if (e.getSource() == back) {
			if (!CodeTestSwitch && counter > 0) {
				if (counter == main.MyProgress.getCodeSize()) {
					counter = counter - 2;
				}
				else {
					counter = counter -1;
				}
				TARight.setText(TALeft.getText());
				TALeft.setText(main.MyProgress.getCode(counter));
			}
			if (CodeTestSwitch && counter > 0) {
				if (counter == main.MyProgress.getCodeSize()) {
					counter = counter - 2;
				}
				else {
					counter = counter - 1;
				}
				TARight.setText(TALeft.getText());
				TALeft.setText(main.MyProgress.getCode(counter));
			}
		}
	}
}
