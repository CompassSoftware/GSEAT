import java.util.*

/**
* A display class that gets displays the information returned by the analysis.
* @author gittinhubbed
* @version 1.0
*/

public class DisplayAnalysis {
    Analysis analysis = null; 
    public DisplayAnalysis(Repository repo) {
        this.analisys = new Analysis(repo);
    }

    private void displayIsssueComments() {
        int i = 0;
        System.out.println("Issue Comments: ");
        while (i < repo.countIssueComments()) {
            System.out.print("*");
        }
        System.out.println();
    }
        
}

