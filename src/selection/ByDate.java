package selection;

import java.util.*;
import analysis.*;
import extraction.*;
import github.*;
import java.time.LocalDate;
import java.util.Date;

/**
* A display class that gets displays the information returned by the analysis based on the dates that are
* given.
* @author gittinhubbed
* @version 1.0
*/
 public class ByDate implements Display {
    Analysis analysis = null;
    Date start;
    Date end;

    /**
    * Constructor creates a new Analysis object with the repo.
    * Sets the start and end dates.
    * @param repo
    * @param start
    * @param end
    */
    public ByDate(Repository repo, Date start, Date end) {
        this.start = start;
        this.end = end;
        this.analysis = new Analysis(repo);
    }

    /**
    * Displays the number of commits to the repo in the date range
    * @param start
    * @param end
    */
    public void displayCommits(Date start, Date end) {
        System.out.print("Commits: ");
        for (int i = 0; i < analysis.countCommits(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of issues added to the repo in the date range
    * @param start
    * @param end
    */
    public void displayIssues(Date start, Date end) {
        System.out.print("Issues: ");
        for (int i = 0; i < analysis.countIssues(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of comments made in the date range
    * @param start
    * @param end
    */
    public void displayComments(Date start, Date end) {
        System.out.print("Comments: ");
        for (int i = 0; i < analysis.countComments(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of comments made in the issues in the date range
    * @param start
    * @param end
    */
    public void displayIssueComments(Date start, Date end) {
        System.out.print("Issue Comments: ");
        for (int i = 0; i < analysis.countIssuesComments(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number ofcomments made on commits in the date range
    * @param start
    * @param end
    */
    public void displayCommitsComments(Date start, Date end) {
        System.out.print("Commit Comments: ");
        for (int i = 0; i < analysis.countCommitsComments(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    /**
    * Calls the methods in the ByDate class.
    */
    public void display() {
        displayIssues(start, end);
        displayCommits(start, end);
        displayComments(start, end);
        displayIssueComments(start, end);
        displayCommitsComments(start, end);
    }
}
