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

	public void setMain(MainScreenController main){
		this.main = main;
        
	}
	
	@FXML
	public void handleButton(ActionEvent e) throws IOException {
		if(e.getSource() == next){
			TALeft.setText(main.MyProgress.getTest(0));
        	TARight.setText(main.MyProgress.getTest(1));
		}
	}
}
