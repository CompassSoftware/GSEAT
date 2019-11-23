/* Demo.java
 *
 * Selection team
 *
 * @author Yuanbo Zhou
 *
 * @version: 1.0
 *
 */

import selection.*;

public class Demo_s {
    public static void main(String[] args) {
        Greeting g =new Greeting();
        g.greeting();
        Repo_info ri = new Repo_info();
        ri.get_repo_name();
        ri.get_repo_url();
    }
}
