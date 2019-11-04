import java.util.ArrayList;

/**
* Analysis.java.
* @author Brooke Tibbett, Courtney Dixon, Val Lapensee-Rankine, Ethan Hahn
* @version 11/4/19
*/
public class Analysis
{
    /**
    * Function to print something to the console screen.
    * @param args command line
    */
    public static void main(String[] args) 
    {
        //System.out.println("Hello, world!");
        Repo repo = new Repo();
        Issue issue1 = new Issue();
        Issue issue2 = new Issue();
        Comment comment1 = new Comment(); 
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        comment1.setText("something");
        comment2.setText("something else");
        comment3.setText("something else else");
        ArrayList<Comment> commentsOne = new ArrayList<Comment>();
        ArrayList<Comment> commentsTwo = new ArrayList<Comment>();    
        commentsOne.add(comment1);
        commentsOne.add(comment2);
        commentsTwo.add(comment3);
        issue1.setComments(commentsOne);
        issue2.setComments(commentsTwo);
        ArrayList<Issue> issues = new ArrayList<Issue>();
        issues.add(issue1);
        issues.add(issue2);
        repo.setIssues(issues);
        
        //System.out.println(repo.countComments());        
    }
}
