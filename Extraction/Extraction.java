
import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

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
        String repoUrl = new String("https://api.github.com/repos/jacobmacfarland/FinanceCalc");

        try {
            URL url = new URL(repoUrl);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;

            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }
            else {
                  System.out.println("Please input the url address: ");
                  return;
             }
             BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             String current;
             String urlString = "";
             while((current = in.readLine()) != null) {
                 urlString += current;
             }

             /** Handle file with json type and seach for the info with name and html_url
              * @param repo_name        the name of user's each repo
              * @param url_name         the url of user's each repo
              */
             //System.out.println(urlString);
             JSONObject jsonObject = JSONObject.fromObject(urlString);
             String repoName = jsonObject.getString("description");
             String repoCollaboratorsURL = jsonObject.getString("collaborators_url");
             String repoCommitsURL = jsonObject.getString("commits_url");
             String repoCommentsURL = jsonObject.getString("comments_url");
             String repoIssuesURL = jsonObject.getString("issues_url");
             String repoIssueCommentsURL = jsonObject.getString("issue_comment_url");

             System.out.println("\n\nRepository name: " + repoName);
             System.out.println("\n\nRepository collaborators URL: " + repoCollaboratorsURL);
             System.out.println("\n\nRepository commits URL: " + repoCommitsURL);
             System.out.println("\n\nRepository comments URL: " + repoCommentsURL);
             System.out.println("\n\nRepository issues URL: " + repoIssuesURL);
             System.out.println("\n\nRepository issue comments URL: " + repoIssueCommentsURL);
             
             //JSONObject owner = jsonObject.getJSONObject("owner");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
