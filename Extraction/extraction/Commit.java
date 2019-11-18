package extraction;
import java.time.LocalDate;

public class Commit
{
    String info;
    String userName;
    LocalDate dateCreated;
    LocalDate dateUpdated;

    /*
     * Constructor that take a Collaborator object and a String for info about the inital commit. 
     */
    public Commit(String info, Collaborator C)
    {
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
}
