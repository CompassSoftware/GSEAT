package github;

import java.util.ArrayList;
import java.time.LocalDate;

public class Issue
{
    String issueText;
    String userName;
    LocalDate dateCreated;
    LocalDate dateUpdated;
    ArrayList<Comment> comments;

    /*
     * Constructor that takes a Collaborator object and a String for info about the issue. 
     */
    public Issue(String issueText, Collaborator C)
    {
        this.comments = new ArrayList<Comment>();
        this.userName = C.getUserName();
        this.issueText = issueText;
        this.dateCreated = LocalDate.now();
        this.dateUpdated = LocalDate.now();
    }

    public void setIssueText(String issueText)
    {
        this.issueText = issueText;
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

    public String getIssueText()
    {
        return this.issueText;
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

    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }

    public ArrayList<Comment> getComments()
    {
        return comments;
    }
}
