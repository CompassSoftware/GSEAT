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
import org.junit.jupiter.api.BeforeEach;
import java.util.*;

import github.Repository;
import github.Comment;
import github.Issue;
import github.Collaborator;
import github.Commit;

public class ExtractionTest {
	// TODO: Can't get tests to compile properly. Uncomment below lines to see error.
	/*Extraction extractor;
	Repository repo;
	Collaborator collab1;
	
	@BeforeEach
	public void init() {
		extractor = new Extraction("jacobmacfarland", "FinanceCalc", "Token");
		repo = extractor.extract();
		collab1 = repo.getCollaborators().get(0);
	}
	
	@Test
	public void testExtractIssuesFromCollaborator() {
		Assert.assertEquals(collab1.getIssues().size(), 2);
	}

	@Test
	public void testExtractCommitsFromCollaborator() {
		Assert.assertEquals(collab1.getCommits().size(), 10);
	}
	
	@Test
	public void testExtractCommentsFromCollaboratorIssues() {
		Assert.assertEquals(collab1.getIssues().get(0).getComments().size(), 2);
	}
	
	@Test
	public void testExtractCommentsFromCollaboratorCommits() {
		Assert.assertEquals(collab1.getCommits().get(0).getComments().size(), 1);
	}
	
	@Test
	public void testExtractCollaborators() {
		Assert.assertEquals(repo.getCollaborators().size(), 2);
	}
	
	@Test
	public void testExtractCommentsFromCollaborator() {
		Assert.assertEquals(collab1.getComments().size(), 5);
	}*/


}
