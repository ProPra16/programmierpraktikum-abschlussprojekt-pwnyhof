package de.hhu.propra16.tddt.controller;

import java.io.IOException;
import java.io.OutputStream;

import javafx.scene.control.TextArea;
/**
 * 
 * @author group pwnyhof
 *
 */
public class Console extends OutputStream {

	private TextArea txtArea = null;
	/**
	 * is called with
	 * @param txtArea (from MainScreenController)
	 * sets this.txtArea to the delivered parameter.
	 */
	public Console(TextArea txtArea) {
		this.txtArea = txtArea;
	}

	@Override
	public void write(int b) throws IOException {

		txtArea.appendText(String.valueOf((char) b));

	}

}
