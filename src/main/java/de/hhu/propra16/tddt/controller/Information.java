package de.hhu.propra16.tddt.controller;

public class Information {

	private String testName;
	private String codeName;
	private String filePath;
	
	public Information(String testName, String codeName, String filePath){
		this.testName = testName;
		this.codeName = codeName;
		this.filePath = filePath;
	}
	
	public String getTestFileName(){
		return testName;
	}
	
	public String getCodeFileName(){
		return codeName;
	}
	
	public String getPathToFiles(){
		return filePath;
	}
}
