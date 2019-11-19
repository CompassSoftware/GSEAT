/** GitUser.java
 * 
 * Selection team
 *
 * Print a list of user's repo URL
 *
 * @author Zack
 *
 * @version 2.0: add greeting and selection.
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
    static String org_name;
    static String url_name;
    static Scanner sc = new Scanner(System.in);
    static String input;
    static String username;
    static String selection;
    static String TOKEN;
    private static GitUser gu = new GitUser();

    /** Scan user's input.
     * @input           user's input
     * @return input    user's input
     */

    public static String scan_input() {
        input = sc.nextLine(); 
        return input;
    }

    /** Greeting_UI. Promopt users to input their username.Then greeting to them.
     * @username        user's username
     */

    public void greeting() {
        System.out.println("Authorization: (Please input your username)");
        username = gu.scan_input();
        System.out.println("Welcome, " + username + "!");
    }

    /** Set URL connection with the user's username.
     ** Store the information in the urlstring.
     *  @Url            user's git url address
     *  @current        param to make sure read all the api file           
     *  @urlstring      store repo_name and repo_url with Json type
     */

    public static JSONArray url_connection() throws IOException {
        JSONArray jsonObject = null;
        try{
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
            jsonObject = JSONArray.fromObject(urlstring);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /** Analysis the json type file to fetch repo_name and repo_url.
     ** Selection for which Info to show.
     * @repo_name       name of user's repo
     * @repo_url        url of user's repo
     */

    public static void json_analysis() throws IOException {
        List<String> list_repo_name = new ArrayList<String>();
        List<String> list_repo_url = new ArrayList<String>();
        JSONArray jsonarray_1 = JSONArray.fromObject(url_connection());
        if(jsonarray_1.size() > 0) {
            for(int i = 0; i < jsonarray_1.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonarray_1.get(i).toString());
                repo_name = jsonObject.getString("name");
                JSONObject owner = jsonObject.getJSONObject("owner");
                repo_url = jsonObject.getString("url");
                list_repo_name.add(repo_name);
                list_repo_url.add(repo_url);
            }
            System.out.print("\n" + "Press 1 to see more about your repository." + "    " + "Press 2 to see more about organization. (Not available for now)" + "\n");
            selection = gu.scan_input();
            switch (Integer.parseInt(selection)) {
                case 1:
                    for (int i = 0; i < list_repo_name.size(); i++) {
                        System.out.println(i+1+ "." +  "Repository: " + list_repo_name.get(i) + "    " + list_repo_url.get(i));
                    }
                case 2:
                    System.out.println("Please input TOKEN: ");
                    TOKEN = sc.nextLine();
                    JSONObject jsonObject1 = null;
                    Url = ("https://api.github.com/orgs/JaysGitLab");
                    try {
                        URL url = new URL(Url);
                        URLConnection urlConnection = url.openConnection();
                        HttpURLConnection connection = null;

                        if (urlConnection instanceof HttpURLConnection) {
                            connection = (HttpURLConnection) urlConnection;
                        }

                        String tempToken = "yuanboz" + TOKEN;
                        String authString = "Basic " + Base64.getEncoder().encode(tempToken.getBytes());
                        connection.setRequestProperty("Authorization", authString);

                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String current;
                        String urlString = "";
                        while ((current = in.readLine()) != null) {
                            urlString += current;
                        }
                        //System.out.println(urlString);
                        jsonObject1 = JSONObject.fromObject(urlString);
                        org_name = jsonObject1.getString("login");
                        url_name = jsonObject1.getString("url");
                        System.out.println("Organization: " + org_name + "  " + url_name);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
        }
    }
}
    public static void main(String[] args) throws IOException {
        gu.greeting();
        gu.json_analysis();
    }
}
