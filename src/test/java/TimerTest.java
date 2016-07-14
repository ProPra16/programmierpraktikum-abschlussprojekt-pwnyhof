import static org.junit.Assert.*;

import org.junit.Test;

import de.hhu.propra16.tddt.controller.MainScreenController;
import de.hhu.propra16.tddt.controller.Timer;

public class TimerTest {
	@Test
	public void resetTimer() {

		MainScreenController con = new MainScreenController();
		long babystepDuration = 15;
		Timer testTimer = new Timer(con, babystepDuration);
		testTimer.setTime(100);
		long reset = testTimer.resetTimer();

		assertEquals(0, reset);
	}

	@Test
	public void startTimer() {

		MainScreenController con = new MainScreenController();
		long babystepDuration = 15;
		Timer testTimer = new Timer(con, babystepDuration);
		long start = System.currentTimeMillis();
		testTimer.startTimer();

		assertEquals(testTimer.startTimer(), start);
	}
	
	@Test
	public void stopTimer(){
		MainScreenController con = new MainScreenController();
		long babystepDuration = 15;
		Timer testTimer = new Timer(con, babystepDuration);
		
		
		assertEquals(false, testTimer.stopTimer());
	}
	@Test
	public void timePassed() throws InterruptedException{
		MainScreenController con = new MainScreenController();
		long babystepDuration = 15;
		Timer testTimer = new Timer(con, babystepDuration);
		
		testTimer.startTimer();
		Thread.sleep(2000);
		testTimer.stopTimer();
		assertEquals(2000, testTimer.timePassed());
		
	}
	@Test
	public void setAndGetTime(){
		MainScreenController con = new MainScreenController();
		long babystepDuration = 15;
		Timer testTimer = new Timer(con, babystepDuration);
		
		testTimer.setTime(5000);
		assertEquals(5000, testTimer.getTime());
	}
}
