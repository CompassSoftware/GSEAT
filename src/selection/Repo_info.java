/** Repo_info.java
 *
 * @author: Yuanboz
 *
 * @version: Sprint 3 version
 */
package selection;

import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.*;

public class Repo_Info {

    static String Url;
    static String repo_name;
    static String repo_url;
    static String org_name;

    /** Get user's repositories name
        @repo_name  all repo name
        @list_repo_name     a list where stored all repo name
        return list_repo_name
     */
    public static ArrayList get_repo_name() {
        ArrayList<String> list_repo_name = new ArrayList<String>();
        JSONArray jsonarray_1 = JSONArray.fromObject(url_connection_repo());
        if (jsonarray_1.size() > 0) {
            for (int i = 0; i < jsonarray_1.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonarray_1.get(i).toString());
                repo_name = jsonObject.getString("name");
                JSONObject owner = jsonObject.getJSONObject("owner");
                list_repo_name.add(repo_name);
            }
        }
        return list_repo_name;
    }

    /** Get user's repositories url link
        @repo_url   all repo url link
        @list_repo_url  a list stored all repo url link
        return list_repo_url
     */
    public static ArrayList get_repo_url() {
        ArrayList<String> list_repo_url = new ArrayList<String>();
        JSONArray jsonarray_1 = JSONArray.fromObject(url_connection_repo());
        if (jsonarray_1.size() > 0) {
            for (int i = 0; i < jsonarray_1.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonarray_1.get(i).toString());
                JSONObject owner = jsonObject.getJSONObject("owner");
                repo_url = jsonObject.getString("url");
                list_repo_url.add(repo_url);
            }
        }
        return list_repo_url;
    }


    public ArrayList get_org_name_withAuth() {
        ArrayList<String> list_org_name = new ArrayList<>();
        JSONArray jsonArray = JSONArray.fromObject(url_connection_withAuth());
        if (jsonArray.size() > 0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonArray.get(i).toString());
                org_name = jsonObject.getString("login");
                list_org_name.add(org_name);
            }
        }
        return list_org_name;
    }

    /** Api connection to git with Authorization
        @Url    url link
        return jsonObject1
     */
    public static JSONObject url_connection_withAuth() {
        JSONObject jsonObject1 = null;
        Url = ("https://api.github.com/orgs/JaysGitLab");
        try {
            URL url = new URL(Url);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }

            String tempToken = Get_Info.user_name + ":" + Get_Info.TOKEN;
            String authString = "Basic " + Base64.getEncoder().encode(tempToken.getBytes());
            connection.setRequestProperty("Authorization", authString);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String current;
            String urlString = "";
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            jsonObject1 = JSONObject.fromObject(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject1;
    }

    public static JSONArray url_connection_withAuth2() {
        JSONArray jsonObject1 = null;
        Url = ("https://api.github.com/orgs/JaysGitLab");
        try {
            URL url = new URL(Url);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }

            String tempToken = Get_Info.user_name + ":" + Get_Info.TOKEN;
            String authString = "Basic " + Base64.getEncoder().encode(tempToken.getBytes());
            connection.setRequestProperty("Authorization", authString);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String current;
            String urlString = "";
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            jsonObject1 = JSONArray.fromObject(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject1;
    }

    /** Api connection to git without Auth and return jsonObject for repo
        @Url    url link
        return jsonObject
     */
    public static JSONArray url_connection_repo () {
        JSONArray jsonObject = null;
        try {
            Url = ("https://api.github.com/users/" + Get_Info.user_name + "/repos");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
