package de.hhu.propra16.tddt.controller;

/**
 * The Timer Class from TDDT project
 * 
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
	private volatile boolean timerRuns = true;
	private MainScreenController controller;
	private Thread t;
	private long timePassed;
	private final long babystepDuration;

	/**
	 * as long as timerRuns is true and timePassed is below 15000(milliseconds)
	 * the current Thread doesn't get interrupted. when timePassed got >= 15000
	 * timerRuns switches to false. with the execution of timerLapsed() the
	 * actual textarea from the controller gets locked and the other textarea
	 * gets unlocked Then the current Thread is interrupted then the Thread
	 * starts again.
	 * 
	 * @param con
	 *            is a new MainScreenController aka. a new GUI window from TDDT
	 */
	public Timer(MainScreenController con, long babystepDuration) {
		this.controller = con;
		this.babystepDuration = babystepDuration;
		startTimer();

		t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (timerRuns) {
					if (timePassed() >= babystepDuration) {
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
	 * startTime gets the value of current time in milliseconds starts the timer
	 * by setting timerRuns 'true'
	 * 
	 */
	public long startTimer() {
		startTime = System.currentTimeMillis();
		timerRuns = true;
		return startTime;
	}

	/**
	 * function to simply calculate the passed time
	 * 
	 * @return this.timePassed: passed time as it's the difference between
	 *         endTime & 0: if something went wrong
	 */
	public long timePassed() {
		endTime = System.currentTimeMillis();
		try {
			this.timePassed = endTime - startTime;
			return this.timePassed;
		} catch (Exception e) {
			System.out.println("Timer Error!");
		}
		return 0;
	}

	/**
	 * stops the timer by changing value of timerRuns
	 */
	public boolean stopTimer() {
		timerRuns = false;
		return timerRuns;
	}

	/**
	 * resets the Timer for next use by switching both values of startTime &
	 * endTime to 0
	 */
	public long resetTimer() {
		startTime = 0;
		endTime = 0;
		return endTime + startTime;
	}

	/**
	 * setter to work with time
	 * 
	 * @param timePassed
	 *            is a value in milliseconds you want to set the timer to
	 * @return the now changed value of timePassed
	 */
	public long setTime(long timePassed) {
		this.timePassed = timePassed;
		return timePassed;
	}

	/**
	 * getter function
	 * 
	 * @return the value of timePassed
	 */
	public long getTime() {
		return timePassed;
	}
}
