package github;

import java.util.Date;
import java.util.ArrayList;

 /**
 * Issue class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Issue {
    private String issueText;
    private String userName;
    private Date dateCreated;
    private Date dateUpdated;
    private ArrayList<Comment> comments;

    /**
    * Constructor for issue object.
    * @param issueText - Text of the issue.
    * @param c - Collaborator/Creator of the issue.
    * @param dateCreated - Date of the creation of the issue.
    * @param dateUpdated - Date of the update of the issue.
    * @param comments - ArrayList of the comments of the issue.
    */
    public Issue(String issueText, Collaborator c, Date dateCreated, 
                 Date dateUpdated, ArrayList<Comment> comments) {
        this.issueText = issueText;
        this.userName = c.getUserName();
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.comments = comments;
    }

    /**
    * Constructor for issue object.
    * @param issueText - Text of the issue.
    * @param c - Collaborator/Creator of the issue.
    */
    public Issue(String issueText, Collaborator c) {
        this(issueText, c, new Date(), new Date(), new ArrayList<Comment>());
    } 

    /**
     * Setter for issue text.
     * @param issueText - Text of the issue.
     */
    public void setIssueText(String issueText) {
        this.issueText = issueText;
    }

    /**
     * Setter for userName.
     * @param userName - User name of the issue creator.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Setter for dateCreated.
     * @param dateCreated - Date of the creation of the issue.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Setter for dateUpdated.
     * @param dateUpdated - Date of the update of the issue.
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * Setter for comments.
     * @param comments - ArrayList of the comments of the issue.
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Getter for issue text.
     * @return Text of the issue.
     */
    public String getIssueText() {
        return this.issueText;
    }

    /**
     * Getter for userName.
     * @return User name of the issue creator.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Getter for dateCreated.
     * @return Date of the creation of the issue.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Getter for dateUpdated.
     * @return Date of the update of the issue.
     */
    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Getter for comments.
     * @return ArrayList of comments of the issue.
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
