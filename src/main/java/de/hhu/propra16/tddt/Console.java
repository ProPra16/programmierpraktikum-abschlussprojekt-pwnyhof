package de.hhu.propra16.tddt;

import java.io.IOException;
import java.io.OutputStream;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Console extends OutputStream {

	        private TextArea txtArea;

	        public Console(TextArea txtArea) {
	            this.txtArea = txtArea;
	        }
	        
	        
	

	        @Override
	        public void write(int b) throws IOException {
	            txtArea.appendText(String.valueOf((char) b));
	        }

	    }

