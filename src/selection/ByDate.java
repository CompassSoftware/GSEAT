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

    public void displayCommits() {
        System.out.print("Commits: ");
        for (int i = 0; i < analysis.countCommits(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayIssues() {
        System.out.print("Issues: ");
        for (int i = 0; i < analysis.countIssues(); i++){
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayCommits(Date start, Date end) {
        System.out.print("Commits");
        for (int i = 0; i < analysis.countCommits(start, end); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayIssueComments() {
        System.out.print("Issue Comments: ");
        int var = analysis.countIssuesComments();
        for (int i = 0; i < analysis.countIssuesComments(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayCommitsComments() {
        System.out.print("Commit Comments: ");
        for (int i = 0; i < analysis.countCommitsComments(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayCommentsByCollaborator(String user) {
        System.out.printf("Comments by user: %s", user);
        for (int i = 0; i < analysis.countCommentsByCollaborator(user); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void displayIssueCommentsByCollaborator(String user) {
        System.out.printf("Issue comments by: %s\n", user);
        for (int i = 0; i < analysis.countCommentsByCollaborator(user); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void display() {
        displayIssues();
        displayCommits();
        displayIssueComments();
        displayCommitsComments();
    }
}
