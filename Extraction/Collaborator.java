/**
 * @author: Nischinth Murari
 * Version 1.00
 * Collaborator class for use in Extraction.java.
 */

public class Collaborator
{
    String firstName;
    String lastName;
    String userName;
    String id;

    /**
     * No args constructor. 
     */
    public Collaborator()
    {
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.id = "";
    }

    /**
     * Constructor with fields.
     */
    public Collaborator(String firstName, 
            String lastName, String userName, String id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.id = id;
    }

    /**
     * firstName mutator. Sets the firstName field.
     * @param: firstName - First name of the Collaborator
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * lastName mutator. Sets the lastName field.
     * @param: lastName - Last name of the Collaborator
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    
    /**
     * userName mutator. Sets the userName field.
     * @param: userName - Github username of the Collaborator
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * id mutator. Sets the id field.
     * @param: lastName - Github id of the Collaborator
     */
    public void setID(String id)
    {
        this.id = id;
    }

    /**
     * Getter for the firstName field.
     * @return: The first name of the Collaborator.
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Getter for the lastName field.
     * @return: The last name of the Collaborator.
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Getter for the userName field.
     * @return: The Github user name of the Collaborator.
     */
    public String getUserName()
    {

        return this.userName;
    }

    /**
     * Getter for the id field.
     * @return: The Github id of the Collaborator.
     */
    public String getID()
    {
        return this.id;
    }
}
