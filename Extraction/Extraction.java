
import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Extraction class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Extraction
{

  	private Repository repo;
  	/**
  	* Constructor for extraction
  	* Sets repo arraylist
  	*/
  	public Extraction()
  	{
  		repo = new Repository();
  	}

    /**
    * Function to print the string "Hello, world!" to the console screen.
    * @param args Unused arguments.
    */
    public static void main(String[] args) 
    {
      
      Extraction extractor = new Extraction();
      ArrayList<Issue> issues = new ArrayList<Issue>();
      
    
      // JSONObject repo = extractor.getJsonObjectFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc", "640ad6f855705e36988a125ebe79a123dc213136");
      // JSONArray collaborators = extractor.getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/collaborators", "640ad6f855705e36988a125ebe79a123dc213136");
            
      /*String repoName = repo.getString("description");
      String repoCollaboratorsURL = repo.getString("collaborators_url");
      String repoCommitsURL = repo.getString("commits_url");
      String repoCommentsURL = repo.getString("comments_url");
      String repoIssuesURL = repo.getString("issues_url");
      String repoIssueCommentsURL = repo.getString("issue_comment_url");*/
      
    
    }
    
    public static Date githubDateStringToDate(String dateString) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date;
      try {
        dateString = dateString.replace('T', ' ');
        dateString = dateString.replace('Z', ' ');
        date = formatter.parse(dateString);
        System.out.println(date);
      }
      catch (ParseException e) {
        e.printStackTrace();
        return null;
      }
      return date;
      
    }
    
    public void addIssuesToRepo() {
      
      JSONArray issues = getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/issues", "640ad6f855705e36988a125ebe79a123dc213136");
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
    
    public void addCommitsToRepo() {
      
      JSONArray commits = getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/commits", "640ad6f855705e36988a125ebe79a123dc213136");
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
    
    public void AddCommentsToRepo() {
      JSONArray comments = getJsonArrayFromUrlWithAuth("https://api.github.com/repos/jacobmacfarland/FinanceCalc/comments", "640ad6f855705e36988a125ebe79a123dc213136");
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
    
    
    
    
    
    public JSONObject getJsonObjectFromUrlWithAuth(String repoUrl, String token) {
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
    
    public static JSONArray getJsonArrayFromUrlWithAuth(String repoUrl, String token) {
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
        //System.out.println("\n\n\n\n\n\n" + urlString + "\n\n\n\n\n\n\n");
        jsonObject = JSONArray.fromObject(urlString);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return jsonObject;
    }

}
