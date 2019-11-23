/** Repo_info.java
 *
 *  API connection to get Json file. Fetch name and url of repository.
 *
 * @author Zack
 *
 * @version 1.0
 */

package selection;

import java.io.*;
import java.util.*;
import java.net.*;
import net.sf.json.*;

public class Repo_info {

    static String Url;
    static String repo_name;
    static String repo_url;
    
    public ArrayList get_repo_name() {
        ArrayList<String> list_repo_name = new ArrayList<String>();
        JSONArray jsonarray_1 = JSONArray.fromObject(url_connection());
        if (jsonarray_1.size() > 0 ) {
            for (int i = 0; i < jsonarray_1.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonarray_1.get(i).toString());
                repo_name = jsonObject.getString("name");
                list_repo_name.add(repo_name);
            }
            System.out.println(list_repo_name);
        }
        return list_repo_name;
    }

    public ArrayList get_repo_url() {
        ArrayList<String> list_repo_url = new ArrayList<String>();
        JSONArray jsonarray_1 = JSONArray.fromObject(url_connection());
        if (jsonarray_1.size() > 0 ) {
            for (int i = 0; i < jsonarray_1.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonarray_1.get(i).toString());
                repo_url = jsonObject.getString("url");
                list_repo_url.add(repo_url);
            }
            System.out.println(list_repo_url);
        }
        return list_repo_url;
    }

    public static JSONArray url_connection() {
        JSONArray jsonObject = null;
        try {
            Url = ("https://api.github.com/users/" + Greeting.user_name + "/repos");
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
}
