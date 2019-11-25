package github;

import java.util.Date;

 /**
 * Comment class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Comment {
    private String commentText;
    private String commentType;
    private String userName;
    private Date dateCreated;
    private Date dateUpdated;

    /**
    * Constructor for comment object.
    * @param commentText - Text of the comment.
    * @param c - Collaborator/Creator of the commit.
    * @param commentType - Type of the comment ("repo", "commit", "issue", 
    *                      etc.).
    * @param dateCreated - Date of the creation of the comment.
    * @param dateUpdated - Date of the update of the comment.
    */
    public Comment(String commentText, Collaborator c, String commentType,
                   Date dateCreated, Date dateUpdated) {
        this.userName = c.getUserName();
        this.commentText = commentText;
        this.commentType = commentType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
    * Constructor for comment object.
    * @param commentText - Text of the comment.
    * @param c - Collaborator/Creator of the commit.
    * @param commentType - Type of the comment ("repo", "commit", "issue", 
    *                      etc.).
    */
    public Comment(String commentText, Collaborator c, String commentType) {
        this(commentText, c, commentType, new Date(), new Date());
    }

    /**
     * Setter for comment text.
     * @param commentText - Text of the comment.
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
    /**
     * Setter for comment type.
     * @param commentType - Type of the comment ("repo", "commit", "issue", 
     *                      etc.).
     */
    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    /**
     * Setter for userName.
     * @param userName - User name of the comment creator.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Setter for dateCreated.
     * @param dateCreated - Date of the creation of the comment.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Setter for dateUpdated.
     * @param dateUpdated - Date of the update of the comment.
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * Getter for comment text.
     * @return Text of the comment.
     */
    public String getCommentText() {
        return this.commentText;
    }

    /**
     * Getter for comment type.
     * @return Comment type of the comment.
     */    
    public String getCommentType() {
        return this.commentType;
    }

    /**
     * Getter for userName.
     * @return User name of the comment creator.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Getter for dateCreated.
     * @return Date of the creation of the comment.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Getter for dateUpdated.
     * @return Date of the update of the comment.
     */
    public Date getDateUpdated() {
        return this.dateUpdated;
    }
}
