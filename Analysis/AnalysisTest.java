import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
* AnalysisTest.java
* @author Brooke Tibbett, Courtney Dixon, Val Lapensee-Rankine, Ethan Hahn
* @version 11/4/19
*/
public class AnalysisTest 
{
	/**
	* Tests if Analysis Class Exists.
	*/
	@Test
	public void testClassExists()
	{
		Class c;
		try
		{
			c = Class.forName("Analysis");
		} 
		catch (Exception e)
		{
			fail("Did you name the class correctly? " + e);
		}

	}
}
