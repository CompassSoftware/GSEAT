package extraction;
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
import java.util.*;

public class ExtractionTest {
	
	Extraction extractor;
	Repository repo;
	
	@BeforeEach
	public void init() {
		extractor = new Extraction("jacobmacfarland", "FinanceCalc", "Token");
		repo = extractor.extract();
	}
	
	@Test
	public void testExtractIssuesFromCollaborator() {
		ArrayList<Collaborator> collaborators
		for (int i = 0; i < repo.getCollaborators().getSize(); i++)
		if ()
		Collaborator collab = 
		Assert.assertEquals(repo.getIssues().getSize(), );
	}

	@Test
	public void testExtractCommitsFromCollaborator() {
		
	}
	
	@Test
	public void testExtractCommentsFromCollaboratorIssues() {
		
	}
	
	@Test
	public void testExtractCommentsFromCollaboratorCommits() {
		
	}
	
	@Test
	public void testExtractCollaborators() {
		
	}


}
