/*Tracking startet mit dem Aufruf einer Uebung. Dabei werden Veraenderungen ab dem geladenem File aufgezeichnet.
 */

package de.hhu.propra16.tddt.controller;

import java.io.File;
import java.util.ArrayList;
/**
 * 
 * @author group pwnyhof
 *
 */
public class Tracking {
	private String codefile = "";
	private String testfile = "";
	private ArrayList<String> codeList = new ArrayList<String>();
	private ArrayList<String> testList = new ArrayList<String>();
	
	public Tracking () {
		codefile = this.codefile;
		testfile = this.testfile;
	}
	
	/*
	private String compareSheets(String editedCode) {
		
		return "";
	}*/
	
	public void addToCodeList(String codefile) {
		codeList.add(codefile);
	}
	
	public void addToTestList(String testfile) {
		testList.add(testfile);
	}
	
	public String getCode(int index) {
		return codeList.get(index);
	}
	
	public String getTest(int index) {
		return testList.get(index);
	}
	
	public void setCodefile(String codefile) {
		this.codefile = codefile;
	}
	
	public void setTestfile(String testfile) {
		this.testfile = testfile;
	}

	public int getTestSize() {
		return testList.size();
	}
	
	public int getCodeSize() {
		return codeList.size();
	}

	/**
	 * method to clear lists
	 */
	public void clearLists(){
		this.codeList.clear();
		this.testList.clear();
	}
}
