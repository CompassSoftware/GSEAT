package extraction;
import java.util.ArrayList;

import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.awt.*;

/**
 * Extraction class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Extraction
{
  	private Repository repo;
    static String baseUrl;
    static Scanner sc = new Scanner(System.in);
    static String TOKEN;

  	/**
  	* Constructor for extraction object.
  	* @param userName - a user name to include in the URL
    * @param userRepository - a user's repository to include in the URL
    * @param tok - a token to authorize URL requests to github API.
  	*/
  	public Extraction(String userName, String userRepository, String tok)
  	{
      baseUrl = "https://api.github.com/repos/" + userName + "/" + userRepository;
      TOKEN = tok;
  	  repo = new Repository();
  	}
    
    /**
    * Aggregate method to add issues, commits, comments, and return a repository object.
    * @return a repository object that contains data for specified repository
    */
    public Repository extract() {
      addIssuesToRepo();
      addCommitsToRepo();
      addCommentsToRepo();
      return repo;
    }
    
    /**
    * Converts a github date string to a Java date object.
    * @param dateString - a github date string to be converted
    * @return a Date java object
    */
    public static Date githubDateStringToDate(String dateString) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date;
      try {
        dateString = dateString.replace('T', ' ');
        dateString = dateString.replace('Z', ' ');
        date = formatter.parse(dateString);
      }
      catch (ParseException e) {
        e.printStackTrace();
        return null;
      }
      return date;
      
    }
    
    /**
    * Adds all issues found in the repository API call to the issues arraylist in a repository object.
    */
    public void addIssuesToRepo() {

      JSONArray issues = getJsonArrayFromUrlWithAuth(baseUrl + "/issues");
      ArrayList<Issue> issuesArrayList = new ArrayList<Issue>();
      
      for (int i = 0; i < issues.size(); i++) {
          JSONObject jsonIssue = JSONObject.fromObject(issues.get(i).toString());
          Issue issue = new Issue("", new Collaborator());
          
          JSONObject assignee = jsonIssue.getJSONObject("assignee");
          String userName = assignee.getString("login");
          String issueText = jsonIssue.getString("title");
          String dateCreatedString = jsonIssue.getString("created_at");
          String dateUpdatedString = jsonIssue.getString("updated_at");
          
          Date dateCreated = githubDateStringToDate(dateCreatedString);
          Date dateUpdated = githubDateStringToDate(dateUpdatedString);

          issue.setUserName(userName);
          issue.setIssueText(issueText);
          issue.setdateCreated(dateCreated);
          issue.setDateUpdated(dateUpdated);
          
          repo.addIssue(issue);
      }
    }
    
    /**
    * Adds all commits found in the repository API call to the commits arraylist in a repository object.
    */
    public void addCommitsToRepo() {
      
      JSONArray commits = getJsonArrayFromUrlWithAuth(baseUrl + "/commits");
      ArrayList<Commit> commitsArrayList = new ArrayList<Commit>();
      
      for (int i = 0; i < commits.size(); i++) {
        
        JSONObject jsonCommitInfo = JSONObject.fromObject(commits.get(i).toString());
        JSONObject jsonCommit = jsonCommitInfo.getJSONObject("commit");
        String message = jsonCommit.getString("message");
        // The github API has two "committer" dictionary keys. 
        // The first committer will be called innerCommitter, 
        // which is a "committer" key inside of a "commit" dictionary
        JSONObject innerCommitter = jsonCommit.getJSONObject("committer");
        String dateCreatedString = innerCommitter.getString("date");
        Date dateCreated = githubDateStringToDate(dateCreatedString);
        
        // The github API has two "committer" dictionary keys. 
        // The second committer will be called outerCommitter, 
        // which is a "committer" key not nested in any dictionaries.
        JSONObject outerCommitter = jsonCommitInfo.getJSONObject("committer");
        String userName = outerCommitter.getString("login");
        
        Commit commit = new Commit("", new Collaborator());
        
        commit.setInfo(message);
        commit.setUserName(userName);
        commit.setdateCreated(dateCreated);
        
        repo.addCommit(commit);
        
      }

    }
    
    /**
    * Adds all comments found in the repository API call to the comments arraylist in a repository object.
    */
    public void addCommentsToRepo() {
      JSONArray comments = getJsonArrayFromUrlWithAuth(baseUrl + "/comments");
      ArrayList<Comment> commentsArrayList = new ArrayList<Comment>();
      
      for (int i = 0; i < comments.size(); i++) {
        JSONObject jsonComment = JSONObject.fromObject(comments.get(i).toString());
        JSONObject user = jsonComment.getJSONObject("user");
        String userName = user.getString("login");
        String body = jsonComment.getString("body");
        String dateCreatedString = jsonComment.getString("created_at");
        String dateUpdatedString = jsonComment.getString("updated_at");
        
        Date dateCreated = githubDateStringToDate(dateCreatedString);
        Date dateUpdated = githubDateStringToDate(dateUpdatedString);
        
        Comment comment = new Comment("", new Collaborator(), "");
        
        comment.setCommentText(body);
        comment.setUserName(userName);
        comment.setdateCreated(dateCreated);
        comment.setDateUpdated(dateUpdated);
        
        repo.addComment(comment);

      }

    }
    
    /**
    * Get a single json object from a specified URL. 
    * @param repoUrl - a URL to retrieve github API data from
    * @return a json object representing the data retrieved from the URL 
    */
    public JSONObject getJsonObjectFromUrlWithAuth(String repoUrl) {
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
        
        String tempToken = TOKEN + ":x-oauth-basic";
        String authString = "Basic " + Base64.getEncoder().encode(tempToken.getBytes());
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
    
    /**
    * Get an array of JSON objects from the specified URL.
    * @param repoUrl - a URL to retrieve github API data from
    * @return a json array representing the data retrieved from the URL
    */
    public static JSONArray getJsonArrayFromUrlWithAuth(String repoUrl) {
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
        
        String tempToken = "jacobmacfarland:" + TOKEN;
        String authString = "Basic " + Base64.getEncoder().encode(tempToken.getBytes());
        connection.setRequestProperty("Authorization", authString); 
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String current;
        String urlString = "";
        while((current = in.readLine()) != null) {
            urlString += current;
        }
        jsonObject = JSONArray.fromObject(urlString);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return jsonObject;
    }

}
