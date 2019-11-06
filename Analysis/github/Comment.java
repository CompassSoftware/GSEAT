package github;

import java.time.LocalDate;

public class Comment
{
    String commentText;
    String commentType;
    String userName;
    LocalDate dateCreated;
    LocalDate dateUpdated;

    /*
     * Constructor that takes a Collaborator object, a String that is the text of the comment,
     * and a String that is the commentType ("repo", "commit", "issue", etc...). 
     */
    public Comment(String commentText, Collaborator C, String commentType)
    {
        this.userName = C.getUserName();
        this.commentText = commentText;
        this.commentType = commentType;
        this.dateCreated = LocalDate.now();
        this.dateUpdated = LocalDate.now();
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

    public void setdateCreated(LocalDate d)
    {
        this.dateCreated = d;
    }

    public void setDateUpdated(LocalDate d)
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

    public LocalDate getDateCreated()
    {
        return this.dateCreated;
    }

    public LocalDate getDateUpdated()
    {
        return this.dateUpdated;
    }
}
