package selection;

import java.util.*;
import analysis.*;
import extraction.*;
import github.*;


/**
* A display class that gets displays the information returned by the analysis.
* @author gittinhubbed
* @version 1.0
*/

public class ByRepo implements Display{
    Analysis analysis = null;

    /**
    * Constructor builds a new anlaysis object with repo.
    * @param repo
    */
    public ByRepo(Repository repo) {
        this.analysis = new Analysis(repo);
    }
    /**
    * Displays the number of commits as a row of asterisks.
    */
    public void displayCommits() {
        System.out.print("Commits: ");
        int var = analysis.countCommits();
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of issues in the repository as a row of asterisks.
    */
    public void displayIssues() {
        System.out.print("Issues: ");
        int var = analysis.countIssues();
        for (int i = 0; i < var; i++){
            System.out.print("*");
        }
        System.out.println();
    }
        /**
        * Displays the number of comments on the issues in the repository as a row of asterisks.
        */
    public void displayComments() {
        System.out.print("Comments: ");
        int var = analysis.countComments();
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

        /**
        * Displays the number of comments on the Commits in the repository as a row of asterisks.
        */
    public void displayCommitsComments() {
        System.out.print("Commit Comments: ");
        int var = analysis.countCommitsComments();
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of comments on issues.
    */
    public void displayIssuesComments() {
        System.out.printf("Issue comments: " );
        int var = analysis.countComments();
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }



    /**
    * Calls the methods of the ByRepo class.
    */
    public void display() {
        displayIssues();
        displayCommits();
        displayComments();
        displayCommitsComments();
        displayIssuesComments();
    }
}
