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

public class ByUser implements Display{
    Analysis analysis = null;
    String userName;
    /**
    * Constructor that creates a new analysis object and sets the username to be used.
    * @param repo
    * @param userName
    */

    public ByUser(Repository repo, String userName) {
        this.analysis = new Analysis(repo);
        this.userName = userName;
    }

    /**
    * Displays the number of commits made by the user "user"
    * @param user
    */
    public void displayCommitsByCollaborator(String user) {
        System.out.print("Commits by " + user + ": ");
        int var = analysis.countCollaboratorCommits(user);
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of issues made by the user "user"
    * @param user
    */
    public void displayIssuesByCollaborator(String user) {
        System.out.print("Issues By " + user + ": ");
        int var = analysis.countIssuesByCollaborator(user);
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of comments made by the user "user"
    * @param user
    */
    public void displayCommentsByCollaborator(String user) {
        System.out.print("Comments by " + user + ": ");
        int var = analysis.countCommentsByCollaborator(user);
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of comments made by the user "user" on the commits
    * @param user
    */
    public void displayCommitsCommentsByCollaborator(String user) {
        System.out.print("Commit Comments by "+ user + ": ");
        int var = analysis.countCommitCommentsByCollaborator(user);
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Displays the number of comments made by the user "user" on the issues
    * @param user
    */
    public void displayIssueCommentsByCollaborator(String user) {
        System.out.printf("Issue comments by %s:", user);
        int var = analysis.countCommentsByCollaborator(user);
        for (int i = 0; i < var; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
    * Calls the methods of the ByUser class.
    */
    public void display() {
        displayIssuesByCollaborator(userName);
        displayCommitsByCollaborator(userName);
        displayCommentsByCollaborator(userName);
        displayCommitsCommentsByCollaborator(userName);
        displayIssueCommentsByCollaborator(userName);
    }
}
