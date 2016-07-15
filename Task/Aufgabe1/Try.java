import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Try{
	
	@Test
	public void stringTest(){
		assertEquals("He0 World!", Code.greet());
	}
	
	@Test
	public void addTest(){

		assertEquals(15, Code.add());
	}
}
