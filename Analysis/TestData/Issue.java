import java.util.ArrayList;

/**
* Issue.java is just a test data class until
* we have real data from Extraction team.
* @author Brooke Tibbett
*/
public class Issue
{
    private ArrayList<Comment> comments;

    /**
    * Issue constructor.
	*/
    public Issue()
    {
        comments = new ArrayList<Comment>();
    }

	/**
	* Accessor for comments.
	* @return arraylist of commments
	*/
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
}
