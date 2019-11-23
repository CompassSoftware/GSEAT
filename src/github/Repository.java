package github;
import java.util.ArrayList;

/** 
 * Class repository is the top level of organization of a repo.
 * 
 * @author Henry "The Bold" Plaskonos
 * @version 1.0
 */
public class Repository {

    private ArrayList<Collaborator> collaborators;
    private ArrayList<Issue> issues;
    private ArrayList<Commit> commits;
    private ArrayList<Comment> comments; 

    /**
    * Constructor for repository object.
    */
    public Repository() {
        collaborators = new ArrayList<>();
        issues = new ArrayList<>();
        commits = new ArrayList<>();
        comments = new ArrayList<>();
    }

    /**
     * Adds new collab.  	
     * @param collab is a new collaborator 
     */
    public void addCollaborator(Collaborator collab) {
        collaborators.add(collab);
    }

    /**
     * Adds new issue.
     * @param issue is a new issue
     */
    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    /**
     * Adds new commit.
     * @param commit is a new commit
     */
    public void addCommit(Commit commit) {
        commits.add(commit);
    }

    /**
     * Adds new comment.
     * @param comment is a new comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Accesses collab field.	
     * @return collaborators field
     */
    public ArrayList<Collaborator> getCollaborators() {
        return collaborators;
    }

    /**
     * Accesses issues field.
     * @return issues field
     */
    public ArrayList<Issue> getIssues() {
        return issues;
    }

    /**
     * Accesses commits field.
     * @return commits field
     */
    public ArrayList<Commit> getCommits() {
        return commits;
    }

    /**
     * Accesses comments field.
     * @return comments field
     */
    public ArrayList<Comment> getComments() {
        return comments;
    } 
}
