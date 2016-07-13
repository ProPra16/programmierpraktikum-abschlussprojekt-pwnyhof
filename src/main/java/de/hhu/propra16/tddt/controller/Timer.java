package de.hhu.propra16.tddt.controller;
/**
 * The Timer Class from TDDT project
 * @author group pwnyhof
 *
 */
public class Timer {
/**
 * some variables for time management (start & end time), the actual state
 * of the timer (runs or not), a new MainScreenController and also a Thread
 * to do stuff with
 */
	private long startTime;
	private long endTime;
	private volatile boolean timerRuns;
	private MainScreenController controller;
	private Thread t;
	/**
	 * as long as timerRuns is true and timePassed is below 15000(milliseconds)
	 * the current Thread doesn't get interrupted. when timePassed got >= 15000
	 * timerRuns switches to false. with the execution of timerLapsed() the actual
	 * textarea from the controller gets locked and the other textarea gets unlocked
	 * Then the current Thread is interrupted then the Thread starts again.
	 * @param con is a new MainScreenController aka. a new GUI window from TDDT
	 */
	public Timer(MainScreenController con) {
		this.controller = con;
		startTimer();

		t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (timerRuns) {
					if (timePassed() >= 15000) {
						timerRuns = false;
						controller.timerLapsed();
					}
				}
				Thread.currentThread().interrupt();
			}
		});
		t.start();
	}
/**
 * startTime gets the value of current time in milliseconds
 * starts the timer by setting timerRuns 'true'
 * 
 */
	public void startTimer() {
		startTime = System.currentTimeMillis();
		timerRuns = true;
	}
/**
 * 
 * @return msec: passed time as it's the difference between endTime & startTime
 * 			  0: if something went wrong
 */
	public long timePassed() {
		endTime = System.currentTimeMillis();
		try {
			long msec = endTime - startTime;
			return msec;
		} catch (Exception e) {
			System.out.println("Timer Error!");
		}
		return 0;
	}
/**
 * stops the timer by changing value of timerRuns
 */
	public void stopTimer() {
		timerRuns = false;
	}
/**
 * resets the Timer for next use by switching both values of startTime & endTime to 0
 */
	public void resetTimer() {
		startTime = 0;
		endTime = 0;
	}
}
