import java.util.ArrayList;

/**
* Repo.java is just a test data class until
* we have real data from Extraction team.
* @author Brooke Tibbett
*/
public class Repo
{
    private ArrayList<Issue> issues;

    /**
    * Repo constructor.
	*/
    public Repo()
    {
        issues = new ArrayList<Issue>();
    }

	/**
	* Accessor for issues.
	* @return arraylist of issues
	*/
    public ArrayList<Issue> getIssues()
    {
        return issues;
    }

    /**
     * Mutator for issues just for testing purposes.
     * @param issues arraylist
     */
    public void setIssues(ArrayList<Issue> issues)
    {
        this.issues = issues;
    }
}
