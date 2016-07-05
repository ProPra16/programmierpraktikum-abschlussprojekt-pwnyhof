package de.hhu.propra16.tddt.controller;

public class Timer {

	long startTime;
	long endTime;
	
	public Timer(){
	}
	
	public void startTimer(){
		startTime = System.currentTimeMillis();
	}
	
	public String timePassed(){
		try{
			long msec =  endTime - startTime;
			long sec = 0;
			long min = 0;
			if(msec >=  1000){
				sec = msec / 1000;
				msec = msec - sec * 1000;
				if(sec >= 60){
					min = sec/60;
					sec = sec - min * 60;
				}
			}
			String minute;
			String second;
			String milliSec;
			
			if(min < 10)
				minute = "0" +min;
			else
				minute = "" +min;
			
			if(sec < 10)
				second = "0" +sec;
			else
				second = "" +sec;
			
			if(msec < 100)
				milliSec = "0" +msec;
			else
				milliSec = "" +msec;
			
			if(msec < 10)
				milliSec = "00" +msec;
			
			return minute +":" +second +":" +milliSec;
		}
		catch(Exception e){
			return "Error";
		}
	}
	
	public void stopTimer(){
		endTime = System.currentTimeMillis();
	}
	
	public void resetTimer(){
		startTime = 0;
		endTime = 0;
	}
}
