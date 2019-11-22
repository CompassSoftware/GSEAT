package github;

import java.util.ArrayList;
import java.time.LocalDate;

public class Commit
{
    String info;
    String userName;
    LocalDate dateCreated;
    LocalDate dateUpdated;
    ArrayList<Comment> comments;

    /*
     * Constructor that take a Collaborator object and a String for info about the inital commit. 
     */
    public Commit(String info, Collaborator C)
    {
        this.comments = new ArrayList<Comment>();
        this.userName = C.getUserName();
        this.info = info;
        this.dateCreated = LocalDate.now();
        this.dateUpdated = LocalDate.now();
    }

    public void setInfo(String info)
    {
        this.info = info;
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

    public String getInfo()
    {
        return this.info;
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
