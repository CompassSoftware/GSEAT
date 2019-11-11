

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
            Repository repo = service.getRepository("jacobmacfarland", "FinanceCalc");
            System.out.println(repo.getDescription());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
