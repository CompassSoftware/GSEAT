
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
      
      Extraction extractor = new Extraction();
    
      //JSONObject jsonObject = extractor.getJsonFromUrl("https://api.github.com/repos/jacobmacfarland/FinanceCalc");
      JSONObject jsonObject = extractor.getJsonFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc", "9b944e41c18ee7783a83270dc65f5f2a8b20a826");
      
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
             
    }
    
    public JSONObject getJsonFromUrl(String repoUrl) {
      JSONObject jsonObject = null;
      try {
        URL url = new URL(repoUrl);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = null;
        
        if (urlConnection instanceof HttpURLConnection) {
            connection = (HttpURLConnection) urlConnection;
        }
        else {
          System.out.println("Please input the url address: ");
          return null;
        }
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String current;
        String urlString = "";
        while((current = in.readLine()) != null) {
            urlString += current;
        }
        jsonObject = JSONObject.fromObject(urlString);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return jsonObject;
      
    }
    
    
    
    
    
    public JSONObject getJsonFromUrlWithAuth(String repoUrl, String token) {
      JSONObject jsonObject = null;
      try {
        URL url = new URL(repoUrl);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = null;
        
        if (urlConnection instanceof HttpURLConnection) {
            connection = (HttpURLConnection) urlConnection;
        }
        else {
          System.out.println("Please input the url address: ");
          return null;
        }
        
        
        token = token + ":x-oauth-basic";
        String authString = "Basic " + Base64.getEncoder().encode(token.getBytes());
        connection.setRequestProperty("Authorization", authString); 
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String current;
        String urlString = "";
        while((current = in.readLine()) != null) {
            urlString += current;
        }
        jsonObject = JSONObject.fromObject(urlString);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return jsonObject;
    }
    
    /*String newUrl = "https://" + url;
        System.out.println(newUrl);
        try {
          URL myURL = new URL(newUrl);
          URLConnection connection = myURL.openConnection();
          // token = token + ":x-oauth-basic";
          // String authString = "Basic " + Base64.encodeBase64String(token.getBytes());
          connection.setRequestProperty("Authorization", authString);
          InputStream crunchifyInStream = connection.getInputStream();
          System.out.println(crunchifyGetStringFromStream(crunchifyInStream));
        } catch (Exception e) {
          e.printStackTrace();
        }*/
}
