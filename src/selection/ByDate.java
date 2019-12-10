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

    public ByDate(Repository repo, Date start, Date end) {
        this.start = start;
        this.end = end;
        this.analysis = new Analysis(repo);
    }

    public void displayCommits(Date start, Date end) {
        System.out.print("Commits: ");
        for (int i = 0; i < analysis.countCommits(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayIssues(Date start, Date end) {
        System.out.print("Issues: ");
        for (int i = 0; i < analysis.countIssues(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayIssueComments(Date start, Date end) {
        System.out.print("Issue Comments: ");
        for (int i = 0; i < analysis.countIssuesComments(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }


    public void displayCommitsComments(Date start, Date end) {
        System.out.print("Comments on Commits: ");
        for (int i = 0; i < analysis.countCommitsComments(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void display() {
        displayIssues(start, end);
        displayCommits(start, end);
        displayIssueComments(start, end);
        displayCommitsComments(start, end);
    }
}
