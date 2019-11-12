import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.time.LocalDate;

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

    /**
     * Tests countCommitsComments.
     */
    @Test
    public void testCountCommitsComments() {
        Collaborator collab1 = new Collaborator("test","test","tester","343");
        Collaborator collab2 = new Collaborator("test2","test2","tester2","3243");
        Commit cmt1 = new Commit("commit1", collab1);
        cmt1.addComment(new Comment("comment1", collab1, "commit"));
        cmt1.addComment(new Comment("comment2", collab2, "commit"));
        cmt1.addComment(new Comment("comment3", collab1, "commit"));

        Commit cmt2 = new Commit("commit2", collab2);
        cmt2.addComment(new Comment("comment1", collab2, "commit"));
        cmt2.addComment(new Comment("comment2", collab1, "commit"));

        Commit cmt3 = new Commit("commit3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);

        Analysis analysis = new Analysis(repo);

        int expected = 5;
        int actual = analysis.countCommitsComments();

        assertEquals(expected, actual);
    }

	/**
	* Tests countCommentsByCollaborator.
	*/
	@Test
	public void testCountCommentsByCollaborator() {
		Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");
        
        Issue i1 = new Issue("issue 1", coll2);
        i1.addComment(new Comment("this is good", coll1, "type1")); 
        i1.addComment(new Comment("this is bad", coll1, "type1"));

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));
        
        Commit com1 = new Commit("commit 1", coll1);
        com1.addComment(new Comment("cool", coll2, "type2"));

        Commit com2 = new Commit ("commit 2", coll2);
        com2.addComment(new Comment("cool2", coll1, "type2"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countCommentsByCollaborator("tester1");
		int expected = 3;
		assertEquals(expected, actual);
	}

    /**
	* Tests countCommentsByCollaborator.
	*/
	@Test
	public void testCountCommentsByCollaboratorDate() {
		Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");
        
        Issue i1 = new Issue("issue 1", coll2);
        Comment comm1 = new Comment("this is good", coll1, "type1");
        comm1.setdateCreated(LocalDate.now().minusDays(4));
        i1.addComment(comm1);
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        comm2.setdateCreated(LocalDate.now().minusDays(13));
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        Comment comm3 = new Comment("this is okay", coll2, "type2");
        comm3.setdateCreated(LocalDate.now().minusDays(2));
        i2.addComment(comm3);
        
        Commit com1 = new Commit("commit 1", coll1);
        Comment comm4 = new Comment("cool", coll2, "type2");
        comm4.setdateCreated(LocalDate.now().minusDays(1));
        com1.addComment(comm4);

        Commit com2 = new Commit ("commit 2", coll2);
        Comment comm5 = new Comment("cool2", coll1, "type2");
        comm5.setdateCreated(LocalDate.now().minusDays(3));
        com2.addComment(comm5);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countCommentsByCollaborator("tester1", LocalDate.now().minusDays(5), LocalDate.now());
		int expected = 2;
		assertEquals(expected, actual);
	}
    
    /**
	* Tests countIssuesByCollaborator.
	*/
	@Test
	public void testCountIssuesByCollaborator() {
		Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");
        
        Issue i1 = new Issue("issue 1", coll2);
        i1.addComment(new Comment("this is good", coll1, "type1")); 
        i1.addComment(new Comment("this is bad", coll1, "type1"));

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));
        
        Commit com1 = new Commit("commit 1", coll1);
        com1.addComment(new Comment("cool", coll2, "type2"));

        Commit com2 = new Commit ("commit 2", coll2);
        com2.addComment(new Comment("cool2", coll1, "type2"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countIssuesByCollaborator("tester1");
		int expected = 1;
		assertEquals(expected, actual);
	}

    /**
	* Tests countIssuesByCollaborator with dates in wrong order.
	*/
	@Test
	public void testCountIssuesByCollaboratorDatesWrong() {
		Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");
        
        Issue i1 = new Issue("issue 1", coll2);
        i1.addComment(new Comment("this is good", coll1, "type1")); 
        i1.addComment(new Comment("this is bad", coll1, "type1"));

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));
        
        Commit com1 = new Commit("commit 1", coll1);
        com1.addComment(new Comment("cool", coll2, "type2"));

        Commit com2 = new Commit ("commit 2", coll2);
        com2.addComment(new Comment("cool2", coll1, "type2"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countIssuesByCollaborator("tester1",
            LocalDate.now().plusDays(1), i2.getDateCreated());
		int expected = -1;
		assertEquals(expected, actual);
	}
    
    /**
	* Tests countIssuesByCollaborator with dates in correct order.
	*/
	@Test
	public void testCountIssuesByCollaboratorDates() {
		Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");
        
        Issue i1 = new Issue("issue 1", coll2);
        i1.addComment(new Comment("this is good", coll1, "type1")); 
        i1.addComment(new Comment("this is bad", coll1, "type1"));

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));
        
        Commit com1 = new Commit("commit 1", coll1);
        com1.addComment(new Comment("cool", coll2, "type2"));

        Commit com2 = new Commit ("commit 2", coll2);
        com2.addComment(new Comment("cool2", coll1, "type2"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countIssuesByCollaborator("tester1",
            i2.getDateCreated(), LocalDate.now());
		int expected = 1;
		assertEquals(expected, actual);
	}
}

