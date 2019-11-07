/**
 * ExtractionTest
 *
 */

// Stuff to redirect System.out for testing purposes.
import java.lang.IllegalArgumentException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

// Stuff needed for JUnit testing.
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class ExtractionTest {

    @Test
    public void testPrint() {

	// Prep for test
	// Actual and expected outputs
	String correctResult = "Hello, world!\n";
	String testOutput = null;
	String testFailed = null;

	// Save current System.out and set to new stream we can read.
	PrintStream origOut = System.out;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream newOut = new PrintStream(baos);
	System.setOut(newOut);

	// Conduct test of main method
	try {
	    String[] args = new String[0];
	    Extraction.main(args);
	}
	catch (Exception e) {
	    testFailed = "Exception thrown unexpectedly";
	}

	// Cleanup
	// Get all the stuff the method wrote to System.out, and reset it.
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	// Check results
	if (testOutput == null)
	    if (testFailed ==  null)
		testFailed = "output to System.out expected";
	    else
		testFailed += "; output to System.out expected";
	else if (testOutput.length() == 0)
	    if (testFailed ==  null)
		testFailed = "output to System.out expected";
	    else
		testFailed += "; output to System.out expected";
	else if (! correctResult.equals(testOutput)) {
	    if (testFailed ==  null)
		testFailed = "Incorrect output generated.";
	    else
		testFailed += "; incorrect output generated.";
	    testFailed += "\nExpected output: \"" + correctResult;
	    testFailed += "\nGenerated output: \"" + testOutput + "\n";
	}

	// Show results
	System.err.println("\nTest: \"java RazzleDazzle 1\" ");
	if (testFailed != null) {
	    System.err.println("Result: ERROR");
	    System.err.println("Feedback: " + testFailed);
	}
	else
	    System.err.println("Result: PASSED\n");

	assertEquals(testFailed, null);
    }


}
