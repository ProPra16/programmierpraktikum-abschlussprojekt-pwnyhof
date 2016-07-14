import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Try{
	
	@Test
	public void stringTest(){
		assertEquals("He1234World!", Code.greet());
		
	}
	
	@Test
	public void addTest(){

		assertEquals(15, Code.add());
	}
}
