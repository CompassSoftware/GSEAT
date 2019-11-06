import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import TestData.Repo;
import TestData.Comment;
import TestData.Issue;

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
        assertTrue((new Analysis(new Repo())) instanceof Analysis);
    }

    /**
     * Tests countIssuesComments.
     */
    @Test
    public void testCountIssuesComments1() {
        ArrayList<Comment> c1 = new ArrayList<Comment>();
        c1.add(new Comment());
        c1.add(new Comment());
        c1.add(new Comment());

        ArrayList<Comment> c2 = new ArrayList<Comment>();
        c2.add(new Comment());
        c2.add(new Comment());

        Issue i1 = new Issue();
        i1.setComments(c1);
        Issue i2 = new Issue();
        i2.setComments(c2);
        ArrayList<Issue> i = new ArrayList<Issue>();
        i.add(i1);
        i.add(i2);

        Repo repo = new Repo();
        repo.setIssues(i);

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
        ArrayList<Comment> c1 = new ArrayList<Comment>();
        c1.add(new Comment());
        c1.add(new Comment());
        c1.add(new Comment());
        c1.remove(2);
        c1.remove(1);
        c1.remove(0);

        ArrayList<Comment> c2 = new ArrayList<Comment>();
        c2.add(new Comment());
        c2.add(new Comment());

        Issue i1 = new Issue();
        i1.setComments(c1);
        Issue i2 = new Issue();
        i2.setComments(c2);
        ArrayList<Issue> i = new ArrayList<Issue>();
        i.add(i1);
        i.add(i2);

        Repo repo = new Repo();
        repo.setIssues(i);

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
        ArrayList<Comment> c1 = new ArrayList<Comment>();
        c1.add(new Comment());
        c1.add(new Comment());
        c1.add(new Comment());

        ArrayList<Comment> c2 = new ArrayList<Comment>();
        c2.add(new Comment());
        c2.add(new Comment());

        Issue i1 = new Issue();
        i1.setComments(c1);
        Issue i2 = new Issue();
        i2.setComments(c2);
        Issue i3 = new Issue();
        ArrayList<Issue> i = new ArrayList<Issue>();
        i.add(i1);
        i.add(i2);
        i.add(i3);

        Repo repo = new Repo();
        repo.setIssues(i);

        Analysis analysis = new Analysis(repo);

        int expected = 5;
        int actual = analysis.countIssuesComments();

        assertEquals(expected, actual);
    }
}

