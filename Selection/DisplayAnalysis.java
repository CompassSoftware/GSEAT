import java.util.*;

/**
* A display class that gets displays the information returned by the analysis.
* @author gittinhubbed
* @version 1.0
*/

public class DisplayAnalysis {
    Analysis analysis = null;
    public DisplayAnalysis(Repository repo) {
        this.analysis = new Analysis(repo);
    }

    public void displayIsssueComments() {
        int i = 0;
        System.out.println("Issue Comments: ");
        while (i < analysis.countIssueComments()) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    public void displayCommitsComments() {
        System.out.println("Commit Comments: ");
        for (int i = 0; i < analysis.countCommitsComments(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayIssueCommentsByCollaborator(String user) {
        for (int i = 0; i < analysis.countCommentsByCollaborator(user); i++) {
            
        }
        
    }
}
