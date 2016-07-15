package de.hhu.propra16.tddt.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * @author group pwnyhof
 *
 */
public class ConfigReader {
	private String task;
	private List<String> contentOfConfig;
	private String filePathToTask;

	/**
	 * 
	 * @param task is a string type variable which contains the name of the
	 *             folder in which your config.txt should exist. If it's not
	 *             there you will get an Error.
	 */
	public ConfigReader(String task) {
		this.task = task;
		filePathToTask = "./Task/" + task + "/";
		Path filePathToConfig = Paths.get("./Task/" + task + "/" + "config.txt");

		try {
			contentOfConfig = Files.readAllLines(filePathToConfig);

		} catch (IOException e) {
			System.out.println("ERROR: Config.txt Not Found!");
		}
	}

	/**
	 * getter to
	 * @return the actual task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * getter to
	 * @return the file path from the task
	 */
	public String getPath() {
		return filePathToTask;
	}

	/**
	 * getter to
	 * @return programName
	 */
	public String getProgramName() {
		String lineWithInfo = contentOfConfig.get(0);
		String programName = lineWithInfo.substring(13);
		return programName;
	}
/**
 * getter to
 * @return testName 
 */
	public String getTestName() {
		String lineWithInfo = contentOfConfig.get(1);
		String testName = lineWithInfo.substring(10);
		return testName;
	}
/**
 * getter to 
 * @return parsed boolean value of babysteps
 */
	public boolean withBabysteps() {
		String lineWithInfo = contentOfConfig.get(2);
		String babysteps = lineWithInfo.substring(11, 15);
		return Boolean.parseBoolean(babysteps);
	}
	
	
	public boolean withoutBabysteps() {
		String lineWithInfo = contentOfConfig.get(2);
		String babysteps = lineWithInfo.substring(11, 15);
		return Boolean.parseBoolean(babysteps);
	}
/**
 * method to
 * @return duration parsed as long type 
 */
	public long timeOfBabysteps() {
		String lineWithInfo = contentOfConfig.get(3);
		String duration = lineWithInfo.substring(19);
		return Long.parseLong(duration);
	}

}
