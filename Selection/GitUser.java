/** GitUser.java
 * 
 * Selection team
 *
 * Print a list of user's repo URL
 *
 * @author Zack
 *
 * @version 1.a
 */

import java.io.*;
import java.util.*;
import java.net.*;
import org.json.*;

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
        System.out.println("url address: " + Url);
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
             String a = urlString;
             String urlString1 = a.replaceAll("[\\[\\]]","");
             JSONObject jo = new JSONObject(urlString1);
             String url_name = jo.getString("html_url");
             String repo_name = jo.getString("name");
             System.out.println("Repo_name: " + repo_name + " " + url_name);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

