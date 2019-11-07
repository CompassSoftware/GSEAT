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
     * Function to print something to the console screen.
     * @param args command line
     */
    public static void main(String[] args) 
    {
        // Creates 1 Repo with 2 issues, 1 issue with one
        // comment and 1 with 2, then creates Analysis object
        // with that repo.
        // Calls countIssuesComments; should print '3'.
        Collaborator coll1 = new Collaborator("mister","test","tester1","2");
        Collaborator coll2 = new Collaborator("misses","test","tester2","3");
        
        Issue i1 = new Issue("issue 1", coll2);
        i1.addComment(new Comment("this is good", coll1, "type1")); 
        i1.addComment(new Comment("this is bad", coll1, "type1"));

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));

        Repository repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);

        Analysis analysis = new Analysis(repo);
        int x = analysis.countIssuesComments();
        System.out.println("Number of comments: " + x);
    }
}
