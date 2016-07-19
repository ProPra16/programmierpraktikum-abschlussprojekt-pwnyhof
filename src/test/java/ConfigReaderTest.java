import java.io.File;

import org.junit.Test;

import de.hhu.propra16.tddt.controller.ConfigReader;
import de.hhu.propra16.tddt.controller.MainScreenController;
/*
 * Der Test hier war ein gescheiterter Versuch das bestehende
 * System darauf zu testen, was geschieht, wenn eine falsche
 * Directory angegeben wird. Hat aber nicht geklappt, da die
 * Methoden aus ConfigReader alle ohne Uebergabeparameter
 * aufgerufen werden und daher nicht mit beliebigen Pfaden
 * angesteuert werden koennen.
 */
public class ConfigReaderTest {

	/*@Test
	public void wrongDirectory() {
		File file = new File("C:\\Directory1");
		if (!file.exists()) {
			file.mkdir();
		}
		String test = file.getPath();

		MainScreenController main = new MainScreenController();
		ConfigReader testConfig = new ConfigReader(test);
		ConfigReader isConfig = main.config;
		main.loadMethod();
		
	

	}*/

}
