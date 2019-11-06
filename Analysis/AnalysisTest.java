import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import github.Repository;
import github.Comment;
import github.Issue;
import github.Collaborator;
import github.Commit;

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

    /**
     * Tests constructor.
     */
    @Test
    public void testConstructor() {
        assertTrue((new Analysis(new Repository())) instanceof Analysis);
    }

    /**
     * Tests countIssuesComments.
     */
    @Test
    public void testCountIssuesComments1() {
        Collaborator collab = new Collaborator("person","test","person","4");

        Issue i1 = new Issue("issue1", collab);
        i1.addComment(new Comment("another thing", collab, "issue"));
        i1.addComment(new Comment("a thing", collab, "issue"));
        i1.addComment(new Comment("things", collab, "issue"));
        Issue i2 = new Issue("issue2", collab);
        i2.addComment(new Comment("more things", collab, "issue"));
        i2.addComment(new Comment("more more things", collab, "issue"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);

        Analysis analysis = new Analysis(repo);

        int expected = 5;
        int actual = analysis.countIssuesComments();

        assertEquals(expected, actual);
    }
    
    /**
     * Tests countIssuesComments.
     */
    @Test
    public void testCountIssuesComments2() {
        Collaborator collab1 = new Collaborator("test","test2","test22","9");
        Collaborator collab2 = new Collaborator("test1","test3","test3434","934");

        Issue i1 = new Issue("issue1", collab1);
        i1.addComment(new Comment("thing", collab1, "issue"));

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("thing2", collab2, "issue"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);

        Analysis analysis = new Analysis(repo);

        int expected = 2;
        int actual = analysis.countIssuesComments();

        assertEquals(expected, actual);
    }
    
    /**
     * Tests countIssuesComments.
     */
    @Test
    public void testCountIssuesComments3() {
        Collaborator collab1 = new Collaborator("test","test","tester","343");
        Collaborator collab2 = new Collaborator("test2","test2","tester2","3243");
        Issue i1 = new Issue("issue1", collab1);
        i1.addComment(new Comment("comment", collab1, "issue"));
        i1.addComment(new Comment("comment2", collab2, "issue"));
        i1.addComment(new Comment("comment3", collab1, "issue"));

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);

        Analysis analysis = new Analysis(repo);

        int expected = 5;
        int actual = analysis.countIssuesComments();

        assertEquals(expected, actual);
    }
}

