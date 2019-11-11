
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
      JSONObject repo = extractor.getJsonFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc", "9b944e41c18ee7783a83270dc65f5f2a8b20a826");
            
      String repoName = repo.getString("description");
      String repoCollaboratorsURL = repo.getString("collaborators_url");
      String repoCommitsURL = repo.getString("commits_url");
      String repoCommentsURL = repo.getString("comments_url");
      String repoIssuesURL = repo.getString("issues_url");
      String repoIssueCommentsURL = repo.getString("issue_comment_url");

      /*System.out.println("\n\nRepository name: " + repoName);
      System.out.println("\n\nRepository collaborators URL: " + repoCollaboratorsURL);
      System.out.println("\n\nRepository commits URL: " + repoCommitsURL);
      System.out.println("\n\nRepository comments URL: " + repoCommentsURL);
      System.out.println("\n\nRepository issues URL: " + repoIssuesURL);
      System.out.println("\n\nRepository issue comments URL: " + repoIssueCommentsURL);*/
      
      JSONArray issues = extractor.getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/issues", "9b944e41c18ee7783a83270dc65f5f2a8b20a826");
      
      for (int i = 0; i < issues.size(); i++) {
          JSONObject issue = JSONObject.fromObject(issues.get(i).toString());
          System.out.println("Issue " + (i + 1) + ": ");
          System.out.println("     Title: " + issue.getString("title"));
          System.out.println("     Body: " + issue.getString("body")); 
          System.out.println("     Created at: " + issue.getString("created_at"));
          System.out.println("     Updated at : " + issue.getString("updated_at"));
      }
      
      JSONArray comments = extractor.getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/comments", "9b944e41c18ee7783a83270dc65f5f2a8b20a826");
      
      JSONArray commits = extractor.getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/commits", "9b944e41c18ee7783a83270dc65f5f2a8b20a826");
      
    
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
    
    
    
    
    
    
    
    
    public JSONArray getJsonArrayFromUrlWithAuth(String repoUrl, String token) {
      JSONArray jsonObject = null;
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
        
        token = "jacobmacfarland:" + token;
        String authString = "Basic " + Base64.getEncoder().encode(token.getBytes());
        connection.setRequestProperty("Authorization", authString); 
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String current;
        String urlString = "";
        while((current = in.readLine()) != null) {
            urlString += current;
        }
        System.out.println("\n\n\n\n\n\n" + urlString + "\n\n\n\n\n\n\n");
        jsonObject = JSONArray.fromObject(urlString);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return jsonObject;
    }

}
