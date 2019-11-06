import java.util.*;
/**
 * Selection team: Zhou/ Luo/ Graber/ Dr.Fenwick
 * Selection.java 
 * @version 1.0
 * @author Yuanbo Zhou
 */

public class Selection {

    /** version 1.0
     * Prompt users for full repo name
     * @para sc     get user's input
     */

    private String userName;
    private String passWord;
    static Scanner sc = new Scanner(System.in);
   // static Cllection<User> users = new ArrayList<User>();

    public String getUserName() {

        return userName;

    }

    public String getPassWord() {

        return passWord;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter full repo name: ");
        String reponame = sc.nextLine();
        System.out.println("Please enter the username: ");
        String username = sc.nextLine();
        System.out.println("Repo name: " + reponame + "\n" + "Username: " + username);

    }

}
