import java.util.ArrayList;
import java.util.Date;

public class Issue
{
    String issueText;
    String userName;
    ArrayList<Comment> comments;
    Date dateCreated;
    Date dateUpdated;

    /*
     * Constructor that takes a Collaborator object and a String for info about the issue. 
     */
    public Issue(String issueText, Collaborator C)
    {
        this.comments = new ArrayList<Comment>();
        this.userName = C.getUserName();
        this.issueText = issueText;
        this.dateCreated = null;
        this.dateUpdated = null;
    }

    public void setIssueText(String issueText)
    {
        this.issueText = issueText;
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

    public String getIssueText()
    {
        return this.issueText;
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
