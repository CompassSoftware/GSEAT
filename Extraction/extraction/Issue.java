package extraction;
import java.util.ArrayList;
import java.util.Date;

 /**
 * Issue class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Issue {
    String issueText;
    String userName;
    ArrayList<Comment> comments;
    Date dateCreated;
    Date dateUpdated;

    /**
    * Constructor for issue object.
    * @param issueText - Text of the issue.
    * @param c - Collaborator/Creator of the issue.
    */
    public Issue(String issueText, Collaborator c) {
        this.comments = new ArrayList<Comment>();
        this.userName = c.getUserName();
        this.issueText = issueText;
        this.dateCreated = null;
        this.dateUpdated = null;
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
}
