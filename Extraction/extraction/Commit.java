package extraction;
import java.util.Date;

 /**
 * Commit class.
 * @author Nischinth Murari
 * @version 1.0
 */
public class Commit {
    String info;
    String userName;
    Date dateCreated;
    Date dateUpdated;

    /**
    * Constructor for commit object.
    * @param info - Info text of the commit.
    * @param c - Collaborator/Creator of the commit.
    */
    public Commit(String info, Collaborator c) {
        this.userName = c.getUserName();
        this.info = info;
        this.dateCreated = null;
        this.dateUpdated = null;
    }

    /**
     * Setter for info.
     * @param info - Info text of the commit.
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Setter for userName.
     * @param userName - User name of the commit creator.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Setter for dateCreated.
     * @param dateCreated - Date of the creation of the commit.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Setter for dateUpdated.
     * @param dateUpdated - Date of the update of the commit.
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * Getter for info.
     * @return Info text of the commit.
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * Getter for userName.
     * @return User name of the commit creator.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Getter for dateCreated.
     * @return Date of the creation of the commit.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Getter for dateUpdated.
     * @return Date of the update of the commit.
     */
    public Date getDateUpdated() {
        return this.dateUpdated;
    }
}
