package extraction;

//import github.*;
import github.Repository;
import github.Commit;
import github.Comment;
import github.Collaborator;
import github.Issue;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;


/**
 * Extraction class.
 * @author Thomas Neumayr
 * @version 1.0
 */
public class Extraction {
    static String baseUrl;
    static Scanner sc = new Scanner(System.in);
    static String token;
    private Repository repo;

    /**
    * Constructor for extraction object.
    * @param userName - a user name to include in the URL
    * @param userRepository - a user's repository to include in the URL
    * @param tok - a token to authorize URL requests to github API.
    */
    public Extraction(String userName, String userRepository, String tok) {
        baseUrl = "https://api.github.com/repos/" + userName + "/" 
            + userRepository;
        token = tok;
        repo = new Repository();
    }

    /**
    * Aggregate method to add issues, commits, comments, and return a repository
    * object.
    * @return a repository object that contains data for specified repository
    */
    public Repository extract() {
        addCollaboratorsToRepo();
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
        SimpleDateFormat formatter = 
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    * Adds all issues found in the repository API call to the issues arraylist
    * in a repository object.
    */
    public void addIssuesToRepo() {

        JSONArray issues = getJsonArrayFromUrlWithAuth(baseUrl + "/issues");
        ArrayList<Issue> issuesArrayList = new ArrayList<Issue>();

        for (int i = 0; i < issues.size(); i++) {
            JSONObject jsonIssue = 
                JSONObject.fromObject(issues.get(i).toString());

            JSONObject assignee = jsonIssue.getJSONObject("assignee");
            String userName = assignee.getString("login");
            String issueText = jsonIssue.getString("title");
            String dateCreatedString = jsonIssue.getString("created_at");
            String dateUpdatedString = jsonIssue.getString("updated_at");
            String commentURL = jsonIssue.getString("comments_url");

            Date dateCreated = githubDateStringToDate(dateCreatedString);
            Date dateUpdated = githubDateStringToDate(dateUpdatedString);
            
            Collaborator collab = new Collaborator("", "", userName, "");
            Issue issue = new Issue(issueText, collab);

            issue.setIssueText(issueText);
            issue.setDateCreated(dateCreated);
            issue.setDateUpdated(dateUpdated);
            
            // Add comments on issue to issue object
            // TODO: Refactor into another method if time permits
            JSONArray comments = getJsonArrayFromUrlWithAuth(commentURL);
            ArrayList<Comment> commentsArrayList = new ArrayList<Comment>();

            for (int j = 0; j < comments.size(); j++) {
                JSONObject jsonComment = 
                    JSONObject.fromObject(comments.get(j).toString());
                JSONObject commentUser = jsonComment.getJSONObject("user");
                String commentUserName = commentUser.getString("login");
                String commentBody = jsonComment.getString("body");
                String commentDateCreatedString = jsonComment.getString("created_at");
                String commentDateUpdatedString = jsonComment.getString("updated_at");

                Date commentDateCreated = githubDateStringToDate(commentDateCreatedString);
                Date commentDateUpdated = githubDateStringToDate(commentDateUpdatedString);

                Collaborator commentCollab = new Collaborator("", "", commentUserName, "");
                Comment comment = new Comment("", commentCollab, "");

                comment.setCommentText(commentBody);
                comment.setDateCreated(commentDateCreated);
                comment.setDateUpdated(commentDateUpdated);

                issue.addComment(comment);

            }

            repo.addIssue(issue);
        }
    }

    /**
    * Adds all commits found in the repository API call to the commits arraylist
    * in a repository object.
    */
    public void addCommitsToRepo() {
      
        JSONArray commits = getJsonArrayFromUrlWithAuth(baseUrl + "/commits");
        ArrayList<Commit> commitsArrayList = new ArrayList<Commit>();
      
        for (int i = 0; i < commits.size(); i++) {

            JSONObject jsonCommitInfo = 
                JSONObject.fromObject(commits.get(i).toString());
            String commentURL = jsonCommitInfo.getString("comments_url");
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
            JSONObject outerCommitter = 
                jsonCommitInfo.getJSONObject("committer");
            String userName = outerCommitter.getString("login");

            Collaborator collab = new Collaborator("", "", userName, "");
            Commit commit = new Commit(message, collab);
            commit.setDateCreated(dateCreated);
            
            // Get comments from commits
            JSONArray comments = getJsonArrayFromUrlWithAuth(commentURL);
            ArrayList<Comment> commentsArrayList = new ArrayList<Comment>();

            for (int j = 0; j < comments.size(); j++) {
                JSONObject jsonComment = 
                    JSONObject.fromObject(comments.get(j).toString());
                JSONObject commentUser = jsonComment.getJSONObject("user");
                String commentUserName = commentUser.getString("login");
                String commentBody = jsonComment.getString("body");
                String commentDateCreatedString = jsonComment.getString("created_at");
                String commentDateUpdatedString = jsonComment.getString("updated_at");

                Date commentDateCreated = githubDateStringToDate(commentDateCreatedString);
                Date commentDateUpdated = githubDateStringToDate(commentDateUpdatedString);

                Collaborator commentCollab = new Collaborator("", "", commentUserName, "");
                Comment comment = new Comment("", commentCollab, "");

                comment.setCommentText(commentBody);
                comment.setDateCreated(commentDateCreated);
                comment.setDateUpdated(commentDateUpdated);

                commit.addComment(comment);

            }


            repo.addCommit(commit);

        }

    }

    /**
    * Adds all comments found in the repository API call to the comments 
    * arraylist in a repository object.
    */
    public void addCommentsToRepo() {
        JSONArray comments = getJsonArrayFromUrlWithAuth(baseUrl + "/comments");
        ArrayList<Comment> commentsArrayList = new ArrayList<Comment>();

        for (int i = 0; i < comments.size(); i++) {
            JSONObject jsonComment = 
                JSONObject.fromObject(comments.get(i).toString());
            JSONObject user = jsonComment.getJSONObject("user");
            String userName = user.getString("login");
            String body = jsonComment.getString("body");
            String dateCreatedString = jsonComment.getString("created_at");
            String dateUpdatedString = jsonComment.getString("updated_at");

            Date dateCreated = githubDateStringToDate(dateCreatedString);
            Date dateUpdated = githubDateStringToDate(dateUpdatedString);

            Collaborator collab = new Collaborator("", "", userName, "");
            Comment comment = new Comment("", collab, "");

            comment.setCommentText(body);
            comment.setDateCreated(dateCreated);
            comment.setDateUpdated(dateUpdated);

            repo.addComment(comment);

        }

    }
    
    /**
    * Adds all collaborators found in the repository API call to commits
    * // TODO: Collaborator url couldn't be followed due to 
    *          authentication error, so pulling some collab
    *          info from commit URL.
    */
    public void addCollaboratorsToRepo() {
        JSONArray commits = getJsonArrayFromUrlWithAuth(baseUrl + "/commits");
        ArrayList<Commit> commitsArrayList = new ArrayList<Commit>();
      
        for (int i = 0; i < commits.size(); i++) {

            JSONObject jsonCommitInfo = 
                JSONObject.fromObject(commits.get(i).toString());
            JSONObject jsonCommit = jsonCommitInfo.getJSONObject("commit");
            String message = jsonCommit.getString("message");
            
            // The github API has two "committer" dictionary keys. 
            // The first committer will be called innerCommitter, 
            // which is a "committer" key inside of a "commit" dictionary
            JSONObject innerCommitter = jsonCommit.getJSONObject("committer");
            String dateCreatedString = innerCommitter.getString("date");
            String[] committerName = innerCommitter.getString("name").split("\\s+");
            String firstName = "";
            String lastName = "";
            if (committerName.length == 2) {
                firstName = committerName[0];
                lastName = committerName[1];
            } else firstName = committerName[0];
            Date dateCreated = githubDateStringToDate(dateCreatedString);

            // The github API has two "committer" dictionary keys. 
            // The second committer will be called outerCommitter, 
            // which is a "committer" key not nested in any dictionaries.
            JSONObject outerCommitter = 
                jsonCommitInfo.getJSONObject("committer");
            String userName = outerCommitter.getString("login");
            String userID = outerCommitter.getString("id");

            Collaborator collab = new Collaborator(firstName, lastName, userName, userID);

            repo.addCollaborator(collab);
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

            String tempToken = token + ":x-oauth-basic";
            String authString = "Basic " 
                + Base64.getEncoder().encode(tempToken.getBytes());
            connection.setRequestProperty("Authorization", authString); 

            BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
            String current;
            String urlString = "";
            while ((current = in.readLine()) != null) {
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

            String tempToken = token + ":x-oauth-basic";
            String authString = "Basic " + Base64.getEncoder().encode(
                tempToken.getBytes());
            connection.setRequestProperty("Authorization", authString); 

            BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
            String current;
            String urlString = "";
            while ((current = in.readLine()) != null) {
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
