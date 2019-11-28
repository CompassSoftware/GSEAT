package github;

import java.util.Date;
import java.util.ArrayList;
import java.text.*;

 /**
 * Commit class.
 * @author Nischinth Murari
 * @version 1.0
 */
public class Commit {
    private String info;
    private Collaborator collaborator;
    private Date dateCreated;
    private Date dateUpdated;
    private ArrayList<Comment> comments;

    /**
    * Constructor for commit object.
    * @param info - Info text of the commit.
    * @param c - Collaborator/Creator of the commit.
    */
    public Commit(String info, Collaborator c) {
        this.collaborator = c;
        this.info = info;
        this.dateCreated = new Date();
        this.dateUpdated = new Date();
        this.comments = new ArrayList<>();
    }

    /**
     * Setter for info.
     * @param info - Info text of the commit.
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Setter for userName.
     * @param c - the commit creator.
     */
    public void setCollaborator(Collaborator c) {
        this.collaborator = c;
    }

    /**
     * Setter for dateCreated.
     * @param dateCreated - Date of the creation of the commit.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Setter for dateUpdated.
     * @param dateUpdated - Date of the update of the commit.
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * Setter for comments.
     * @param comments - ArrayList of the comments of the commit.
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Getter for info.
     * @return Info text of the commit.
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * Getter for userName.
     * @return the commit creator.
     */
    public Collaborator getCollaborator() {
        return this.collaborator;
    }

    /**
     * Getter for dateCreated.
     * @return Date of the creation of the commit.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Getter for dateUpdated.
     * @return Date of the update of the commit.
     */
    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Getter for comments.
     * @return ArrayList of comments of the commit.
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    /**
     * Adds new comment to the ArrayList of comments.
     * @param New comment that should be added to the ArrayList.
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
