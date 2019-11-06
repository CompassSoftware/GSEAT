import TestData.Comment;
import TestData.Repo;
import TestData.Issue;
import java.util.ArrayList;

/**
 * Analysis.java.
 * @author Brooke Tibbett, Courtney Dixon, Val Lapensee-Rankine, Ethan Hahn
 * @version 11/4/19
 */
public class Analysis
{
    Repo repo;
    ArrayList<Issue> issues;

    /**
     * Analysis constructor.
     *
     * @param r Repository object given by extraction
     */
    public Analysis(Repo r)
    {
        repo = r;
        issues = r.getIssues();
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
        for (Issue i : issues)
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
        ArrayList<Comment> c1 = new ArrayList<Comment>();
        c1.add(new Comment());
        c1.add(new Comment());

        ArrayList<Comment> c2 = new ArrayList<Comment>();
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
        int x = analysis.countIssuesComments();
        System.out.println("Number of comments: " + x);
    }
}
