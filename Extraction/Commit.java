import java.util.Date;

public class Commit
{
    String info;
    String userName;
    Date dateCreated;
    Date dateUpdated;

    /*
     * Constructor that take a Collaborator object and a String for info about the inital commit. 
     */
    public Commit(String info, Collaborator C)
    {
        this.userName = C.getUserName();
        this.info = info;
        this.dateCreated = null;
        this.dateUpdated = null;
    }

    public void setInfo(String info)
    {
        this.info = info;
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

    public String getInfo()
    {
        return this.info;
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
