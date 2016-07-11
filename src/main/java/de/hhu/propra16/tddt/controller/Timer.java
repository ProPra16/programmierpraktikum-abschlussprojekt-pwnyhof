package de.hhu.propra16.tddt.controller;

public class Timer {

	private long startTime;
	private long endTime;
	private boolean timerRuns;
	private MainScreenController controller;
	
	public Timer(MainScreenController con){
		this.controller = con;
		startTimer();
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run(){
				while(timerRuns){
					if(timePassed() >= 180000){
						timerRuns = false;
						controller.timerLapsed();
						
					}
				}
			}
		});
		t.start();
	}
	
	public void startTimer(){
		startTime = System.currentTimeMillis();
		timerRuns = true;
	}
	
	public long timePassed(){
		endTime = System.currentTimeMillis();
		try{
			long msec =  endTime - startTime;
			return msec;
		}
		catch(Exception e){
			System.out.println("Timer Error!");
		}
		return 0;
	}
	
	public void stopTimer(){
		timerRuns = false;
	}
	
	public void resetTimer(){
		startTime = 0;
		endTime = 0;
	}
}
