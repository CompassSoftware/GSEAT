import java.time.LocalDate;
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
     * countCommitsComments
     *
     * Counts the comments that each commit has for all
     * issues in the repo.
     *
     * @return count of comments
     */
    public int countCommitsComments()
    {
        int count = 0;
        for (Commit j : repo.getCommits())
        {
            ArrayList<Comment> comments = j.getComments();
            for (Comment w : comments)
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
    * @param username of collaborator
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
	* @param username of collaborator
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
                if ((c.getUserName()).equals(username))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countIssueCommentsByCollaborator
    * Counts issue comments made by colllaborator.
    *
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countIssueCommentsByCollaborator(String username, 
		LocalDate start, LocalDate end)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username) 
					&& (start.compareTo(c.getDateCreated()) <= 0) 
					&& (end.compareTo(c.getDateCreated()) >= 0))
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
	* @param username of collaborator
    * @return count of comments
    */
    public int countCommitCommentsByCollaborator(String username)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username))
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
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countCommitCommentsByCollaborator(String username, 
		LocalDate start, LocalDate end)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username) 
					&& (start.compareTo(c.getDateCreated()) <= 0) 
					&& (end.compareTo(c.getDateCreated()) >= 0))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countCommentsByCollaborator
    * Counts the comments made by a collaborator through dates.
    * 
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countCommentsByCollaborator(String username, 
		LocalDate start, LocalDate end)
    {
        int count = 0;
        count += countIssueCommentsByCollaborator(username, start, end);
        count += countCommitCommentsByCollaborator(username, start, end);
        return count;
    }

    /**
     * countIssuesByCollaborator.
     *
     * Count the number of issues each collaborator has
     * created in the whole time of the project.
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
            if ((i.getUserName()).equals(username))
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * countIssuesByCollaborator
     *
     * Count the number of issues each collaborator has
     * created within the dates.
     * 
     * @param username of the Collaborator who's issues
     *  are being counted
     *
     * @return : number of issues that the collaborator has
     *  within the dates
     *         : -1 if start > end
     * @param start - The start date.
     * @param end - The end date.
     */
    public int countIssuesByCollaborator(String username, LocalDate start, 
            LocalDate end)
    {
        if (start.isAfter(end))
        {
            return -1;
        }
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            if ((i.getUserName()).equals(username)
                && i.getDateCreated().compareTo(start) >= 0
                && i.getDateCreated().compareTo(end) <= 0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * countCollaboratorCommits
     *
     * Count the number of commits made by certain
     * collaborator.
     * 
     * @param username of the Collaborator who's issues
     *  are being counted
     *
     * @return : number of commits made by a collaborator
     */
    public int countCollaboratorCommits(String username)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            if (i.getUserName().equals(username)) 
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
        int collab1Comments = analysis.countCommentsByCollaborator("tester1");
        int collab1CommentsByDate = analysis
			.countCommentsByCollaborator("tester1",
			LocalDate.now().minusDays(5), LocalDate.now());
        int collab1Issues = analysis.countIssuesByCollaborator("tester1");
        int commitComments = analysis.countCommitsComments();
        int collab1IssuesDatesWrong = 
            analysis.countIssuesByCollaborator("tester1",
                LocalDate.now().plusDays(1), i2.getDateCreated());        
        int collab1IssuesDates = analysis.countIssuesByCollaborator("tester1",
                i2.getDateCreated(), LocalDate.now());     
        int collaborator1Commits = analysis.countCollaboratorCommits("tester1");
        
        System.out.println("Number of issue comments: " + issueComments);

        System.out.println("Number of comments by collaborator 1: " 
			+ collab1Comments);
        System.out.println("Number of comments by collaborator 1 " 
			+ "in the last 5 days: " + collab1CommentsByDate);
        System.out.println("Number of isues by collaborator 1: " 
			+ collab1Issues);
        System.out.println("Number of commits by collaborator 1: "
                + collaborator1Commits);
        System.out.println("Number of commit comments: " + commitComments);

        System.out.println("Total number of issues by collaborator 1 with "
                + "wrong start and end dates: " + collab1IssuesDatesWrong);
        System.out.println("Total number of issues by collaborator 1 with "
                + "correct start and end dates: " + collab1IssuesDates);

    }
}
