import java.time.LocalDate;
import github.Comment;
import github.Repository;
import github.Issue;
import github.Commit;
import github.Collaborator;

/**
 * Demo class demonstrates the use of Analysis.java.
 *
 * @author Ethan Hahn, Brooke Tibbett, Courtney Dixon,
 *  Val Lapensée-Rankine
 * @version 11-12-2019
 */
public class Demo 
{    
    /**
     * Function to print something to the console screen.
     * @param args command line
     */
    public static void main(String[] args) 
    {
        // Creates 1 Repo with 2 issues and 2 commits.
        // Issue 1 (by collaborator 2) has 2 comments 
        // (both made by collaborator 1).
        // Issue 2 (by collaborator 1) has 1 comment 
        // (made by collaborator 2).
        // Commit 1 is by collaborator 1 with one comment by collab 2
        // Commit 2 is by collaborator 2 with one comment by collab 1
        // Calls countIssuesComments; should print '3'.
        // Calls countCommentsByCollaborator for collaborator 1; should print 2

        Collaborator coll1 = new Collaborator("mister", "test", "tester1", "2");
        Collaborator coll2 = new Collaborator("misses", "test", "tester2", "3");
        
        Issue i1 = new Issue("issue 1", coll2);
        Comment comm1 = new Comment("this is good", coll1, "type1");
        comm1.setdateCreated(LocalDate.now().minusDays(4));
        i1.addComment(comm1); 
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        comm2.setdateCreated(LocalDate.now());
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));
        
        Commit com1 = new Commit("commit 1", coll1);
        com1.addComment(new Comment("cool", coll2, "type2"));

        Commit com2 = new Commit("commit 2", coll2);
        Comment comm3 = new Comment("cool2", coll1, "type2");
        comm3.setdateCreated(LocalDate.now().minusDays(10));
        com2.addComment(comm3);

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        Analysis analysis = new Analysis(repo);

        int issueComments = analysis.countIssuesComments();
        int issueCommentsInLast5Days = analysis.countIssueComments(
            LocalDate.now().minusDays(5), LocalDate.now());    
        
        int commitComments = analysis.countCommitsComments();
        int commitCommentsByDate = analysis.countCommitsComments(
            LocalDate.now().minusDays(5), LocalDate.now());

        int collab1Comments = analysis.countCommentsByCollaborator("tester1");
        int collab1CommentsByDate = analysis
            .countCommentsByCollaborator("tester1",
            LocalDate.now().minusDays(5), LocalDate.now());
        
        int collab1Issues = analysis.countIssuesByCollaborator("tester1");      
        int collab1IssuesByDate = analysis.countIssuesByCollaborator("tester1",
            LocalDate.now().minusDays(5), LocalDate.now());     
        
        int collab1Commits = analysis.countCollaboratorCommits("tester1");
        int collab1CommitsByDate = analysis.countCollaboratorCommits("tester1", 
            LocalDate.now().minusDays(5), LocalDate.now());

        int commits = analysis.countCommits();
        int issues = analysis.countIssues();
        int commitsInLast5Days = analysis.countCommits(
                LocalDate.now().minusDays(5), LocalDate.now());
        int issuesInLast5Days = analysis.countIssues(
                LocalDate.now().minusDays(5), LocalDate.now());




        System.out.println("Number of issue comments: " + issueComments);
        System.out.println("Number of issue comments in the last 5 days: "
            + issueCommentsInLast5Days);

        System.out.println("Number of commit comments: " + commitComments);
        System.out.println("Number of commit comments in the last 5 days: "
            + commitCommentsByDate);

        System.out.println("Number of comments by collaborator 1: " 
            + collab1Comments);
        System.out.println("Number of comments by collaborator 1 " 
            + "in the last 5 days: " + collab1CommentsByDate);
        
        System.out.println("Number of isues by collaborator 1: " 
            + collab1Issues);
        System.out.println("Number of issues by collaborator 1 "
            + "in the last 5 days: " + collab1IssuesByDate);
        
        System.out.println("Number of commits by collaborator 1: "
            + collab1Commits);
        System.out.println("Number of commits by collaborator 1 "
            + "in the last 5 days: " + collab1CommitsByDate);
    }
}
