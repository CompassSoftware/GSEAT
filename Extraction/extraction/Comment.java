package extraction;
import java.util.Date;

public class Comment
{
    String commentText;
    String commentType;
    String userName;
    Date dateCreated;
    Date dateUpdated;

    /*
     * Constructor that takes a Collaborator object, a String that is the text of the comment,
     * and a String that is the commentType ("repo", "commit", "issue", etc...). 
     */
    public Comment(String commentText, Collaborator C, String commentType)
    {
        this.userName = C.getUserName();
        this.commentText = commentText;
        this.commentType = commentType;
        this.dateCreated = null;
        this.dateUpdated = null;
    }

    public void setCommentText(String commentText)
    {
        this.commentText = commentText;
    }
    
    public void setCommentType(String commentType)
    {
        this.commentType = commentType;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setdateCreated(Date d)
    {
        this.dateCreated = d;
    }

    public void setDateUpdated(Date d)
    {
        this.dateUpdated = d;
    }

    public String getCommentText()
    {
        return this.commentText;
    }
    
    public String getCommentType()
    {
        return this.commentType;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public Date getDateCreated()
    {
        return this.dateCreated;
    }

    public Date getDateUpdated()
    {
        return this.dateUpdated;
    }
}
