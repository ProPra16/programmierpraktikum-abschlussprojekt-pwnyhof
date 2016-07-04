

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Try{
	
	@Test
	public void stringTest(){
		assertEquals("Hello Wo!", Code.greet());
		
	}
	
	@Test
	public void addTest(){
		assertEquals(10, Code.add());
	}
}