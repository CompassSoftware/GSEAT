
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

             System.out.println(urlString);

             /** Handle file with json type and seach for the info with name and html_url
              * @param repo_name        the name of user's each repo
              * @param url_name         the url of user's each repo
              */

             /*JSONArray jsonarray = JSONArray.fromObject(urlString);
             if (jsonarray.size() > 0) {
                 for (int i = 0; i < jsonarray.size(); i++) {
                     JSONObject jsonObject = JSONObject.fromObject(jsonarray.get(i).toString());
                     String repo_name = jsonObject.getString("name");   //name of target of the first layer
                     JSONObject owner = jsonObject.getJSONObject("owner");
                     String url_name = owner.getString("html_url");     //html_url in the owner layer
                     System.out.println("Repo_name: " + repo_name + "   " + url_name);
                 }
             } */

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
