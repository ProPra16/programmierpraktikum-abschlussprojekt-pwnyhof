package de.hhu.propra16.tddt.controller;
/**
 * 
 * @author group pwnyhof
 *
 */
public class Information {

	private String testName;
	private String codeName;
	private String filePath;
	/**
	 * Stores deliverd Strings
	 * @param testName
	 * @param codeName
	 * @param filePath
	 */
	public Information(String testName, String codeName, String filePath){
		this.testName = testName;
		this.codeName = codeName;
		this.filePath = filePath;
	}
	/**
	 * String type getter Method
	 * @return testName
	 */
	public String getTestFileName(){
		return testName;
	}
	/**
	 * String type getter Method
	 * @return codeName
	 */
	public String getCodeFileName(){
		return codeName;
	}
	/**
	 * String type getter Method
	 * @return filePath
	 */
	public String getPathToFiles(){
		return filePath;
	}
}
