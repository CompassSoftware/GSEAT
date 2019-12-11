package analysis;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;

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
            c = Class.forName("analysis.Analysis");
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
     * Tests countCommits.
     */
    @Test
    public void countCommits() {
        Collaborator collab = new Collaborator("person", "test", "person", "4");
        Repository repo = new Repository();
        repo.addCommit(new Commit("comm 1", collab));
        repo.addCommit(new Commit("comm 2", collab));
        repo.addCommit(new Commit("comm 3", collab));

        Analysis analysis = new Analysis(repo);
        int actual = analysis.countCommits();
        int expected = 3;

        assertEquals(expected, actual);
    }

    /**
     * Tests countIssues.
     */
    @Test
    public void countIssues() {
        Collaborator collab = new Collaborator("person", "test", "person", "4");
        Repository repo = new Repository();
        repo.addIssue(new Issue("iss 1", collab));
        repo.addIssue(new Issue("iss 2", collab));
        repo.addIssue(new Issue("iss 3", collab));
        repo.addIssue(new Issue("iss 3", collab));

        Analysis analysis = new Analysis(repo);
        int actual = analysis.countIssues();
        int expected = 4;

        assertEquals(expected, actual);
    }
    /**
     * Tests countCommits with Dates.
     */
    @Test
    public void testCountCommitsDate() {
        Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");

        Issue i1 = new Issue("issue 1", coll2);
        Comment comm1 = new Comment("this is good", coll1, "type1");
        comm1.setDateCreated(convertToDate(LocalDate.now().minusDays(4)));
        i1.addComment(comm1);
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        comm2.setDateCreated(convertToDate(LocalDate.now().minusDays(13)));
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        Comment comm3 = new Comment("this is okay", coll2, "type2");
        comm3.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        i2.addComment(comm3);

        Commit com1 = new Commit("commit 1", coll1);
        com1.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        Comment comm4 = new Comment("cool", coll2, "type2");
        comm4.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));
        com1.addComment(comm4);

        Commit com2 = new Commit ("commit 2", coll2);
        com2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        Comment comm5 = new Comment("cool2", coll1, "type2");
        comm5.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        com2.addComment(comm5);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countCommits(convertToDate(LocalDate.now().minusDays(5)), convertToDate(LocalDate.now()));
        int expected = 1;
        assertEquals(expected, actual);
    }

    /**
     * Tests countIssues with Dates.
     */
    @Test
    public void testCountIssuesDate() {
        Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");

        Issue i1 = new Issue("issue 1", coll2);
        i1.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        Comment comm1 = new Comment("this is good", coll1, "type1");
        comm1.setDateCreated(convertToDate(LocalDate.now().minusDays(4)));
        i1.addComment(comm1);
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        comm2.setDateCreated(convertToDate(LocalDate.now().minusDays(13)));
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        i2.setDateCreated(convertToDate(LocalDate.now().minusDays(6)));
        Comment comm3 = new Comment("this is okay", coll2, "type2");
        comm3.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        i2.addComment(comm3);

        Commit com1 = new Commit("commit 1", coll1);
        com1.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        Comment comm4 = new Comment("cool", coll2, "type2");
        comm4.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));
        com1.addComment(comm4);

        Commit com2 = new Commit ("commit 2", coll2);
        com2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        Comment comm5 = new Comment("cool2", coll1, "type2");
        comm5.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        com2.addComment(comm5);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countIssues(convertToDate(LocalDate.now().minusDays(5)), convertToDate(LocalDate.now()));
        int expected = 1;
        assertEquals(expected, actual);
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
     * Tests countRepoComments.
     */
    @Test
    public void testCountRepoComments() {
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
        repo.addComment(new Comment("repo comm", collab, "repo"));
        repo.addComment(new Comment("repo comm 2", collab, "repo"));

        Analysis analysis = new Analysis(repo);

        int expected = 2;
        int actual = analysis.countRepoComments();

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
     * Tests countCommitsComments by date.
     */
    @Test
    public void testCountCommitsCommentsByDate() {
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
        int actual = analysis.countCommitsComments(
                convertToDate(LocalDate.now().minusDays(1)),
                new Date());

        assertEquals(expected, actual);
    }

    /**
     * Tests countRepoComments by date.
     */
    @Test
    public void testCountRepoCommentsByDate() {
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
        repo.addComment(new Comment("repo comments", collab1, "repo"));
        repo.addComment(new Comment("repo comments 2", collab1, "repo"));
        Comment comm1 = new Comment("repo comment3", collab1, "repo");
        comm1.setDateCreated(convertToDate(LocalDate.now().minusDays(4)));

        Analysis analysis = new Analysis(repo);

        int expected = 2;
        int actual = analysis.countRepoComments(
                convertToDate(LocalDate.now().minusDays(1)),
                new Date());

        assertEquals(expected, actual);
    }

    /**
     * Tests countComments.
     */
    @Test
    public void testCountComments() {
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

        Issue i1 = new Issue("issue1", collab1);
        i1.addComment(new Comment("comment", collab1, "issue"));
        i1.addComment(new Comment("comment2", collab2, "issue"));
        i1.addComment(new Comment("comment3", collab1, "issue"));

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);
        repo.addComment(new Comment("repo comment", collab2, "repo"));

        Analysis analysis = new Analysis(repo);

        int expected = 11;
        int actual = analysis.countComments();

        assertEquals(expected, actual);
    }

    /**
     * Tests countComments by date.
     */
    @Test
    public void testCountCommentsByDate() {
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

        Issue i1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment", collab1, "issue");
        Comment c2 = new Comment("comment2", collab2, "issue");
        Comment c3 = new Comment("comment3", collab1, "issue");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        i1.addComment(c1);
        i1.addComment(c2);
        i1.addComment(c3);

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);
        Comment c4 = new Comment("repo comment", collab1, "repo");
        c4.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        repo.addComment(c4);

        Analysis analysis = new Analysis(repo);

        int expected = 8;
        int actual = analysis.countComments(convertToDate(LocalDate.now().minusDays(5)), new Date());

        assertEquals(expected, actual);
    }

    /**
     * Tests countIssuesComments(LocalDate, LocalDate) method.
     * @author Courtney Dixon
     */
    @Test
    public void testCountIssuesCommentsWithDates()
    {
        Collaborator collab1 = new Collaborator("test","test","tester","343");
        Collaborator collab2 = new Collaborator("test2","test2","tester2","3243");
        Issue issue1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment1", collab1, "I have an issue");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        issue1.addComment(c1);
        issue1.addComment(new Comment("comment2", collab2, "I have an issue"));
        issue1.addComment(new Comment("comment3", collab1, "I have an issue"));

        Issue issue2 = new Issue("commit2", collab2);
        issue2.addComment(new Comment("comment1", collab2, "I have a bigger issue"));
        issue2.addComment(new Comment("comment2", collab1, "I have a bigger issue"));

        Issue issue3 = new Issue("commit3", collab2);

        Repository repo = new Repository();
        repo.addIssue(issue1);
        repo.addIssue(issue2);
        repo.addIssue(issue3);

        Analysis analysis = new Analysis(repo);

        int expected = 4;
        int actual = analysis.countIssuesComments(
                convertToDate(LocalDate.now().minusDays(2)),
                new Date());

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
        Comment c4 = new Comment("repo comment", coll1, "repo");
        c4.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        repo.addComment(c4);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countCommentsByCollaborator("tester1");
        int expected = 4;
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
        comm1.setDateCreated(convertToDate(LocalDate.now().minusDays(4)));
        i1.addComment(comm1);
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        comm2.setDateCreated(convertToDate(LocalDate.now().minusDays(13)));
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        Comment comm3 = new Comment("this is okay", coll2, "type2");
        comm3.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        i2.addComment(comm3);

        Commit com1 = new Commit("commit 1", coll1);
        Comment comm4 = new Comment("cool", coll2, "type2");
        comm4.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));
        com1.addComment(comm4);

        Commit com2 = new Commit ("commit 2", coll2);
        Comment comm5 = new Comment("cool2", coll1, "type2");
        comm5.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        com2.addComment(comm5);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);
        Comment c4 = new Comment("repo comment", coll1, "repo");
        c4.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        repo.addComment(c4);

        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countCommentsByCollaborator("tester1", convertToDate(LocalDate.now().minusDays(5)), convertToDate(LocalDate.now()));
        int expected = 3;
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
     * Tests countIssuesByCollaborator with dates.
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
                i2.getDateCreated(), new Date());
        int expected = 1;
        assertEquals(expected, actual);
    }

    /**
     * Tests countCollaboratorCommits(...)
     */
    @Test
    public void testCountCollaboratorCommits1() {
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

        Commit com3 = new Commit("commit 3", coll1);
        com3.addComment(new Comment("great job", coll1, "type3"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);
        repo.addCommit(com3);


        Analysis analysis = new Analysis(repo);        
        int actual = analysis.countCollaboratorCommits("tester1");
        int expected = 2;
        assertEquals(expected, actual);
    }

    /**
     * Tests countCommits with Dates.
     */
    @Test
    public void testCountCommitsByCollaboratorDate() {
        Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");

        Issue i1 = new Issue("issue 1", coll2);
        Comment comm1 = new Comment("this is good", coll1, "type1");
        comm1.setDateCreated(convertToDate(LocalDate.now().minusDays(4)));
        i1.addComment(comm1);
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        comm2.setDateCreated(convertToDate(LocalDate.now().minusDays(13)));
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        Comment comm3 = new Comment("this is okay", coll2, "type2");
        comm3.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        i2.addComment(comm3);

        Commit com1 = new Commit("commit 1", coll1);
        com1.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        Comment comm4 = new Comment("cool", coll2, "type2");
        comm4.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));
        com1.addComment(comm4);

        Commit com2 = new Commit ("commit 2", coll2);
        com2.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        Comment comm5 = new Comment("cool2", coll1, "type2");
        comm5.setDateCreated(convertToDate(LocalDate.now().minusDays(3)));
        com2.addComment(comm5);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);
        int actual = analysis.countCollaboratorCommits("tester1", convertToDate(LocalDate.now().minusDays(5)), convertToDate(LocalDate.now()));
        int expected = 1;
        assertEquals(expected, actual);
    }


    /**
     * Tests countContributionsByCollaborator by date.
     */
    @Test
    public void testCountContributionsByCollaboratorByDate() {
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

        Issue i1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment", collab1, "issue");
        Comment c2 = new Comment("comment2", collab2, "issue");
        Comment c3 = new Comment("comment3", collab1, "issue");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        i1.addComment(c1);
        i1.addComment(c2);
        i1.addComment(c3);

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);

        Analysis analysis = new Analysis(repo);

        int expected = 6;
        int actual = analysis.countContributionsByCollaborator(
                "tester", convertToDate(LocalDate.now().minusDays(5)), new Date());

        assertEquals(expected, actual);
    }

    /**
     * Tests countContributionsByCollaborator.
     */
    @Test
    public void testCountContributionsByCollaborator() {
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

        Issue i1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment", collab1, "issue");
        Comment c2 = new Comment("comment2", collab2, "issue");
        Comment c3 = new Comment("comment3", collab1, "issue");

        i1.addComment(c1);
        i1.addComment(c2);
        i1.addComment(c3);

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);

        Analysis analysis = new Analysis(repo);

        int expected = 8;
        int actual = analysis.countContributionsByCollaborator("tester");

        assertEquals(expected, actual);
    }

    /**
     * Tests countContributions(). 
     */
    @Test
    public void testCountContributions() {
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

        Issue i1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment", collab1, "issue");
        Comment c2 = new Comment("comment2", collab2, "issue");
        Comment c3 = new Comment("comment3", collab1, "issue");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        i1.addComment(c1);
        i1.addComment(c2);
        i1.addComment(c3);

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);

        Analysis analysis = new Analysis(repo);

        int expected = 16;
        int actual = analysis.countContributions();

        assertEquals(expected, actual); 
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    /*
     * Tests countContributionsBetweenDates().
     */
    @Test
    public void testCountContributionsBetweenDates()
    {
        Collaborator collab1 = new Collaborator("test","test","tester","343");
        Collaborator collab2 = new Collaborator("test2","test2","tester2","3243");

        // COMMENTS
        Comment comment1 = new Comment("I have a comment", collab1, "repo");
        Comment comment2 = new Comment("I have a comment", collab2, "repo");
        Comment comment3 = new Comment("I have a comment", collab1, "repo");
        comment1.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));
        comment2.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));
        comment3.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));

        // COMMITS
        Commit commit1 = new Commit("commit1", collab1);
        Commit commit2 = new Commit("commit2", collab2);
        commit1.addComment(new Comment("I'm making a commit", collab1, "commit"));
        commit1.addComment(new Comment("I'm making a commit", collab2, "commit"));
        commit1.addComment(new Comment("I'm making a commit", collab1, "commit"));
        commit2.addComment(new Comment("I'm making a commit", collab2, "commit"));
        commit2.addComment(new Comment("I'm making a commit", collab1, "commit"));
        commit1.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));
        commit2.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));

        // ISSUES
        Issue issue1 = new Issue("issue1", collab1);
        Issue issue2 = new Issue("commit2", collab2);
        issue1.addComment(new Comment("I have an issue", collab1, "issue"));
        issue1.addComment(new Comment("I have an issue", collab2, "issue"));
        issue1.addComment(new Comment("I have an issue", collab1, "issue"));
        issue2.addComment(new Comment("I have an issue", collab2, "issue"));
        issue2.addComment(new Comment("I have an issue", collab1, "issue"));
        issue1.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));
        issue2.setDateCreated(convertToDate(LocalDate.now().minusDays(7)));        

        Repository repo = new Repository();
        repo.addComment(comment1);
        repo.addComment(comment2);
        repo.addComment(comment3);
        repo.addCommit(commit1);
        repo.addCommit(commit2);
        repo.addIssue(issue1);
        repo.addIssue(issue2);

        Analysis analysis = new Analysis(repo);

        int expected = 17;
        int actual = analysis.countContributionsBetweenDates(
                convertToDate(LocalDate.now().minusDays(10)),
                new Date());

        assertEquals(expected, actual);
    }

    /**
     * Tests percentContributionsByCollaborator by date.
     */
    @Test
    public void testPercentContributionsByCollaboratorByDate() {
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

        Issue i1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment", collab1, "issue");
        Comment c2 = new Comment("comment2", collab2, "issue");
        Comment c3 = new Comment("comment3", collab1, "issue");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        i1.addComment(c1);
        i1.addComment(c2);
        i1.addComment(c3);

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);

        Analysis analysis = new Analysis(repo);

        double expected = 6.0 / 13.0;
        double actual = analysis.percentContributionsByCollaborator(
                "tester", convertToDate(LocalDate.now().minusDays(5)), new Date());

        assertEquals(expected, actual);
    }

    /**
     * Tests contributionBreakdown.
     */
    @Test
    public void testContributionBreakdown() {
        Collaborator collab1 = new Collaborator("test","test","tester","343");
        Collaborator collab2 = new Collaborator("test2","test2","tester2","3243");
        Commit cmt1 = new Commit("commit1", collab1);
        cmt1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        Comment c1 = new Comment("comment1", collab1, "commit");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(9)));
        Comment c2 = new Comment("comment2", collab2, "commit");
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(2)));
        Comment c3 = new Comment("comment3", collab1, "commit");
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));

        cmt1.addComment(c1);
        cmt1.addComment(c2);
        cmt1.addComment(c3);

        Repository repo = new Repository();
        repo.addCollaborator(collab1);
        repo.addCollaborator(collab2);
        repo.addCommit(cmt1);

        Analysis analysis = new Analysis(repo);

        Date daysAgo = new Date();
        daysAgo.setDate(daysAgo.getDate() - 10);

        Date today = new Date();
        Date middle = (Date) daysAgo.clone();
        middle.setDate(middle.getDate() + 7);

        Date end = (Date) middle.clone();
        end.setDate(end.getDate() + 7);

        String daysAgoString = (daysAgo.getYear() + 1900) + "-" + (daysAgo.getMonth() + 1) + "-" + daysAgo.getDate();
        String todayString = (today.getYear() + 1900) + "-" + (today.getMonth() + 1) + "-" + today.getDate();
        String middleString = (middle.getYear() + 1900) + "-" + (middle.getMonth() + 1) + "-" + middle.getDate();
        String endString = (end.getYear() + 1900) + "-" + (end.getMonth() + 1) + "-" + end.getDate();

        String expected = "\nContributions by tester"
            + "\nFrom: " + daysAgoString + " To: " + todayString + " in weekly increments:"
            + "\n"
            + "\n" + daysAgoString + " to " + middleString + ": 100.0%"
            + "\n" + middleString + " to " + endString + ": 50.0%"
            + "\n"
            + "\nContributions by tester2"
            + "\nFrom: " + daysAgoString + " To: " + todayString + " in weekly increments:"
            + "\n"
            + "\n" + daysAgoString + " to " + middleString + ": 0.0%"
            + "\n" + middleString + " to " + endString + ": 50.0%"
            + "\n";

        String actual = analysis.contributionBreakdown();

        assertEquals(expected, actual);
    }

    /**
     * Tests contributionBreakdownByCollaborator by dates.
     */
    @Test
    public void testContributionBreakdownByDate() {
        Collaborator collab1 = new Collaborator("test","test","tester","343");
        Collaborator collab2 = new Collaborator("test2","test2","tester2","3243");
        Commit cmt1 = new Commit("commit1", collab1);
        cmt1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        Comment c1 = new Comment("comment1", collab1, "commit");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(9)));
        Comment c2 = new Comment("comment2", collab2, "commit");
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));
        Comment c3 = new Comment("comment3", collab1, "commit");
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(1)));

        cmt1.addComment(c1);
        cmt1.addComment(c2);
        cmt1.addComment(c3);

        Repository repo = new Repository();
        repo.addCollaborator(collab1);
        repo.addCollaborator(collab2);
        repo.addCommit(cmt1);

        Analysis analysis = new Analysis(repo);

        Date daysAgo = new Date();
        daysAgo.setDate(daysAgo.getDate() - 10);

        Date today = new Date();
        Date middle = (Date) daysAgo.clone();
        middle.setDate(middle.getDate() + 7);

        String daysAgoString = (daysAgo.getYear() + 1900) + "-" + (daysAgo.getMonth() + 1) + "-" + daysAgo.getDate();
        String middleString = (middle.getYear() + 1900) + "-" + (middle.getMonth() + 1) + "-" + middle.getDate();

        String expected = "\nContributions by tester"
            + "\nFrom: " + daysAgoString + " To: " + middleString + " in weekly increments:"
            + "\n"
            + "\n" + daysAgoString + " to " + middleString + ": 100.0%"
            + "\n"
            + "\nContributions by tester2"
            + "\nFrom: " + daysAgoString + " To: " + middleString + " in weekly increments:"
            + "\n"
            + "\n" + daysAgoString + " to " + middleString + ": 0.0%"
            + "\n";

        String actual = analysis.contributionBreakdown(daysAgo, middle);

        assertEquals(expected, actual);
    }

    /**
     * Tests contributionBreakdownByCollaborator.
     */
    @Test
    public void contributionBreakdownByCollaborator() {
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

        Issue i1 = new Issue("issue1", collab1);
        Comment c1 = new Comment("comment", collab1, "issue");
        Comment c2 = new Comment("comment2", collab2, "issue");
        Comment c3 = new Comment("comment3", collab1, "issue");
        c1.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c2.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));
        c3.setDateCreated(convertToDate(LocalDate.now().minusDays(10)));

        i1.addComment(c1);
        i1.addComment(c2);
        i1.addComment(c3);

        Issue i2 = new Issue("issue2", collab2);
        i2.addComment(new Comment("comment1", collab2, "issue"));
        i2.addComment(new Comment("comment2", collab1, "issue"));

        Issue i3 = new Issue("issue3", collab2);

        Repository repo = new Repository();
        repo.addCommit(cmt1);
        repo.addCommit(cmt2);
        repo.addCommit(cmt3);
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addIssue(i3);

        Analysis analysis = new Analysis(repo);

        Date today = new Date();
        Date nextWeek = new Date(); 
        nextWeek.setDate(today.getDate() + 7);

        String expected = "\nAll-time Contributions by tester\n"
            + "From: " + today.toString() + " To: " + nextWeek.toString()
            + "\nin weekly increments:\n\n"
            + today.toString() + " to " + nextWeek.toString() 
            + " - " + "37.50\n";


        String actual = analysis.contributionBreakdownByCollaborator(
            "tester");

        assertEquals(expected, actual);
    }

}

