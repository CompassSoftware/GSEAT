/** GitUser.java
 * 
 * Selection team
 *
 * Print a list of user's repo URL
 *
 * @author Zack
 *
 * @version 1.c: seperate the code in main to different methods
 */

import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class GitUser {

    static String username;
    static String Url;
    static String repo_name;
    static String repo_url;
    static Scanner sc = new Scanner(System.in);

    /** Promopt user for full username. Scan user's input.
     * @username        user's input
     * @Url             user's url
     * @return url      api for connecion
     */

    public static String scan_input() {

        System.out.println("Please input your username: ");
        username = sc.nextLine(); 
        Url = ("https://api.github.com/users/" + username + "/repos");
        System.out.println("URL address: " + Url + "\n");
        return Url;

    }

    /** Set URL connection with the user's input.
     *  Store the information in the urlstring.
     *  @current        param to make sure read all the api file           
     *  @urlstring      store repo_name and repo_url with Json type
     */

    public static String url_connection() throws IOException {

        URL url = new URL(scan_input());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = null;
        if (urlConnection instanceof HttpURLConnection) {
            
            connection = (HttpURLConnection) urlConnection;
            
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String current;
        String urlstring = "";
        while ((current = in.readLine()) != null) {

            urlstring += current;

        }
        return urlstring;
    }

    /** Analysis the json type file to fetch repo_name and repo_url
     * @repo_name       name of user's repo
     * @repo_url        url of user's repo
     */

    public static String json_analysis() throws IOException {

        JSONArray jsonarray = JSONArray.fromObject(url_connection());
        if(jsonarray.size() > 0) {

            for(int i = 0; i < jsonarray.size(); i++) {

                JSONObject jsonObject = JSONObject.fromObject(jsonarray.get(i).toString());
                repo_name = jsonObject.getString("name");
              //JSONObject owner = jsonObject.getJSONObject("owner"); not available for now
                repo_url = jsonObject.getString("html_url");
                System.out.println("Repository: " + repo_name + "   " + repo_url);
            }
        }
        return repo_name;
    }

    public static void main(String[] args) throws IOException {

        GitUser gu = new GitUser();
        gu.json_analysis();

    }
}
