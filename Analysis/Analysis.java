import github.Comment;
import github.Repository;
import github.Issue;
import github.Commit;
import github.Collaborator;
import java.util.ArrayList;

/**
 * Analysis.java.
 * @author Brooke Tibbett, Courtney Dixon, Val Lapensee-Rankine, Ethan Hahn
 * @version 11/4/19
 */
public class Analysis
{
    Repository repo;

    /**
     * Analysis constructor.
     *
     * @param r Repository object given by extraction
     */
    public Analysis(Repository r)
    {
        repo = r;
    }

    /**
     * countIssuesComments
     *
     * Counts the comments that each issue has for all
     *  issues in the repo.
     *
     * @return count of comments
     */
    public int countIssuesComments()
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                count++;
            }
        }
        return count;
    }

    /**
    * countCommentsByCollaborator
    * Counts the comments made by a collaborator.
    * 
    * @return count of comments
    */
    public int countCommentsByCollaborator(String username)
    {
        int count = 0;
        count += countIssueCommentsByCollaborator(username);
        count += countCommitCommentsByCollaborator(username);
        return count;
    }

    /**
    * countIssueCommentsByCollaborator
    * Counts issue comments made by colllaborator.
    *
    * @return count of comments
    */
    public int countIssueCommentsByCollaborator(String username)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if((c.getUserName()).equals(username))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countCommitCommentsByCollaborator
    * Counts commit comments made by collaborator.
    *
    * @return count of comments
    */
    public int countCommitCommentsByCollaborator(String username)
    {
        int count = 0;
        for(Commit i : repo.getCommits())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if((c.getUserName()).equals(username))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * countIssuesByCollaborator
     *
     * @param username of the Collaborator who's issues
     *  are being counted
     *
     * @return number of issues that the collaborator has
     */
    public int countIssuesByCollaborator(String username)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            if((i.getUserName()).equals(username))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Function to print something to the console screen.
     * @param args command line
     */
    public static void main(String[] args) 
    {
        // Creates 1 Repo with 2 issues and 2 commits.
        // Issue 1 (by collaborator 2) has 2 comments (both made by collaborator 1).
        // Issue 2 (by collaborator 1) has 1 comment (made by collaborator 2).
        // Commit 1 is by collaborator 1 with one comment by collab 2
        // Commit 2 is by collaborator 2 with one comment by collab 1
        // Calls countIssuesComments; should print '3'.
        // Calls countCommentsByCollaborator for collaborator 1; should print 2
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
        int issueComments = analysis.countIssuesComments();
        int collab1Comments = analysis.countCommentsByCollaborator("tester1");
        System.out.println("Number of issue comments: " + issueComments);
        System.out.println("Number of comments by collaborator 1: " + collab1Comments);
    }
}
