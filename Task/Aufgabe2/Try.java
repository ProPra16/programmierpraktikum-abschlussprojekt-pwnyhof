import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Try{
	
	@Test
	public void stringTest(){
		assertEquals("He3 World!", Test2.greet());
	}
	
	@Test
	public void addTest(){

		assertEquals(15, Test2.add());
	}
}
