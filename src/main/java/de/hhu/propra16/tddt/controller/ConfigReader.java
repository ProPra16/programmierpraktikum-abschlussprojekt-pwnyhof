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
	 * String type getter method
	 * @return task 
	 */
	public String getTask() {
		return task;
	}

	/**
	 * String type getter method
	 * @return filePathToTask
	 */
	public String getPath() {
		return filePathToTask;
	}

	/**
	 * String type getter method
	 * @return programName
	 */
	public String getProgramName() {
		String lineWithInfo = contentOfConfig.get(0);
		String programName = lineWithInfo.substring(13);
		return programName;
	}
/**
 * String type getter method
 * @return testName 
 */
	public String getTestName() {
		String lineWithInfo = contentOfConfig.get(1);
		String testName = lineWithInfo.substring(10);
		return testName;
	}
/**
 * Boolean type getter method 
 * @return Boolean.parseBoolean(babysteps)
 */
	public boolean withBabysteps() {
		String lineWithInfo = contentOfConfig.get(2);
		String babysteps = lineWithInfo.substring(11, 15);
		return Boolean.parseBoolean(babysteps);
	}
	
/**
 * Long type getter method
 * @return Long.parseLong(duration) 
 */
	public long timeOfBabysteps() {
		String lineWithInfo = contentOfConfig.get(3);
		String duration = lineWithInfo.substring(19);
		return Long.parseLong(duration);
	}

}
