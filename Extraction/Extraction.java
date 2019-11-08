import java.util.ArrayList;

import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryId;

import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.Repository;

import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.client.GitHubClient;
import java.io.*;

/**
 * Extraction class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Extraction
{

	private ArrayList<Repository> repositories;
	/**
	* Constructor for extraction
	* Sets repo arraylist
	*/
	public Extraction()
	{
		repositories = new ArrayList<>();
	}


	public void addRepo(Repository repo)
	{
		repositories.add(repo);
	}

    /**
    * Function to print the string "Hello, world!" to the console screen.
    * @param args Unused arguments.
    */
    public static void main(String[] args) 
    {

        GitHubClient client = new GitHubClient();
        client.setCredentials("jacobmacfarland", "");

        RepositoryService service = new RepositoryService();
        service.getClient().setCredentials("jacobmacfarland", "");
        try {
            for (Repository repo : service.getRepositories("jacobmacfarland"))
                System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
