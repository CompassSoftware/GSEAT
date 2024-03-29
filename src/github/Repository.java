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
        this.collaborators = new ArrayList<>();
        this.issues = new ArrayList<>();
        this.commits = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    /**
     * Adds new collab.  	
     * @param collab is a new collaborator 
     */
    public void addCollaborator(Collaborator collab) {
        this.collaborators.add(collab);
    }

    /**
     * Adds new issue.
     * @param issue is a new issue
     */
    public void addIssue(Issue issue) {
        this.issues.add(issue);
        // Add issue to a collaborators list
        for (int i = 0; i < this.collaborators.size(); i++) {
            Collaborator currentCollaborator = this.collaborators.get(i);
            String collabUserName = currentCollaborator.getUserName();
            String issueUserName = issue.getCollaborator().getUserName();
            if (collabUserName.toLowerCase().equals(
                issueUserName.toLowerCase())) {
                currentCollaborator.addIssue(issue);
            }
        }
    }

    /**
     * Adds new commit.
     * @param commit is a new commit
     */
    public void addCommit(Commit commit) {
        this.commits.add(commit);
        // Add issue to a collaborators list
        for (int i = 0; i < this.collaborators.size(); i++) {
            Collaborator currentCollaborator = this.collaborators.get(i);
            String collabUserName = currentCollaborator.getUserName();
            String commitUserName = commit.getCollaborator().getUserName();
            if (collabUserName.toLowerCase().equals(
                commitUserName.toLowerCase())) {
                currentCollaborator.addCommit(commit);
            }
        }
    }

    /**
     * Adds new comment.
     * @param comment is a new comment
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
        for (int i = 0; i < this.collaborators.size(); i++) {
            Collaborator currentCollaborator = this.collaborators.get(i);
            String collabUserName = currentCollaborator.getUserName();
            String commentUserName = comment.getCollaborator().getUserName();
            if (collabUserName.toLowerCase().equals(
                commentUserName.toLowerCase())) {
                currentCollaborator.addComment(comment);
            }
        }
    }

    /**
     * Accesses collab field.	
     * @return collaborators field
     */
    public ArrayList<Collaborator> getCollaborators() {
        return this.collaborators;
    }

    /**
     * Accesses issues field.
     * @return issues field
     */
    public ArrayList<Issue> getIssues() {
        return this.issues;
    }

    /**
     * Accesses commits field.
     * @return commits field
     */
    public ArrayList<Commit> getCommits() {
        return this.commits;
    }

    /**
     * Accesses comments field.
     * @return comments field
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    } 
}
