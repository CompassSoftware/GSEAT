/** GitUser.java
 * 
 * Selection team
 *
 * Print a list of user's repo URL
 *
 * @author Zack
 *
 * @version 1.c: separate the code in main to different methods
 */

import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class GitUser {

    static String Url;
    static String repo_name;
    static String repo_url;
    static Scanner sc = new Scanner(System.in);
    static String input;
    private static GitUser gu;

    /** Scan user's input.
     * @input           user's input
     * @return input    user's input
     */

    public static String scan_input() {

        input = sc.nextLine(); 
        return input;

    }

    /** Prompt user;s for full username. Call scan_input method to get user's input. Set URL connection with the user's input.
     *  Store the information in the urlstring.
     *  @Url            user's git url address
     *  @current        param to make sure read all the api file           
     *  @urlstring      store repo_name and repo_url with Json type
     */

    public static String url_connection() throws IOException {

        System.out.println("Please input your username: ");
        gu.scan_input();
        Url = ("https://api.github.com/users/" + input + "/repos");
        URL url = new URL(Url);
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
                repo_url = jsonObject.getString("url");
                //System.out.println("Which Info do you want to display?" + "\n" + "Press 1 to show more about Repository" + "   " + "Press 2 to show more about owner" ); not available for now

                System.out.println("Repository: " + repo_name + "   " + repo_url);
            }
        }
        return repo_name;
    }

    public static void main(String[] args) throws IOException {

        gu.json_analysis();

    }
}
