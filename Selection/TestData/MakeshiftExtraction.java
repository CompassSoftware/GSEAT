package TestData;

import java.util.ArrayList;

/**
* Repo.java is just a test data class until
* we have real data from Extraction team.
* @author Brooke Tibbet
* @author gittinhubbed
*/
public class MakeshiftExtraction {
    private String url; 
    private ArrayList<Issue> issues;

    /**
    * Repo constructor.
	*/
    public MakeshiftExtraction()
    {
        issues = new ArrayList<Issue>();
        
    }
    public MakeshiftExtraction(String url) {
        issues = new ArrayList<Issue>();
        this.url = url;
    }
    /**
    * Accessor for the URL,
    */
    public String getUrl() {
        return url;
    }

    /**
    * Mutator for the URL,
    */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
    * Run the curl ops.
    * 
    */
    public String runCurl() {
        return "Ran the curl on " + url;
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
