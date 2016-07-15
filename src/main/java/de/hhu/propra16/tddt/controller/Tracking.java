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
	
	private ArrayList<String> codeList = new ArrayList<String>();
	private ArrayList<String> testList = new ArrayList<String>();
	
	private ArrayList<Integer> codeTime = new ArrayList<Integer>();
	private ArrayList<Integer> testTime = new ArrayList<Integer>();
	
	public Tracking () {

	}
	
	/*
	private String compareSheets(String editedCode) {
		
		return "";
	}*/
	
	public void addToCodeTime(int time) {
		codeTime.add(time);
	}
	
	public void addToTestTime(int time) {
		testTime.add(time);
	}
	
	public int getCodeTime(int index) {
		return codeTime.get(index);
	}
	
	public int getTestTime(int index) {
		return testTime.get(index);
	}
	
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
