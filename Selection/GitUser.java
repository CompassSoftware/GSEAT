/** GitUser.java
 * 
 * Selection team
 *
 * Print a list of user's repo URL
 *
 * @author Zack
 *
 * @version 1.b: realize get repo url function
 */

import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class GitUser {

    static String username;
    static String Url;
    static String full_name;
    static String url_name;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        /** Prompt user for username
         * @username    user's input
         * @Url         user's main page url
         * @urlString   user's full information
         * @url_name    user's repo url
         * @repo_name   user's repo name
         */

        System.out.println("Please input your username: ");
        String username = sc.nextLine();
        String Url = new String("https://api.github.com/users/" + username +"/repos") ;
        System.out.println("User_name: " + username + " " + Url);

        try {
            URL url = new URL(Url);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
             if(urlConnection instanceof HttpURLConnection) {
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

             JSONArray jsonarray = JSONArray.fromObject(urlString);
             if (jsonarray.size() > 0) {
                 for (int i = 0; i < jsonarray.size(); i++) {
                     JSONObject jsonObject = JSONObject.fromObject(jsonarray.get(i).toString());
                     String repo_name = jsonObject.getString("name");   //name of target of the first layer
                     // JSONObject owner = jsonObject.getJSONObject("owner"); not useful now
                     String url_name = jsonObject.getString("html_url");     //html_url in the owner layer
                     System.out.println("Repo_name: " + repo_name + "   " + url_name);
                 }
             }
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

