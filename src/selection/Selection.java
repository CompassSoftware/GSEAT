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

    private static String userName;
    private static String passWord;
    private static String repo;
    static Scanner sc = new Scanner(System.in);
   // static Cllection<User> users = new ArrayList<User>();

    public static String getUserName() {

        return userName;

    }

    public static String getPassWord() {

        return passWord;

    }
    public static String getRepo() {
        return repo;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String reponame = sc.nextLine();
        System.out.println("Please enter full username: ");
        System.out.println("Please enter the username: ");
        String username = sc.nextLine();
        System.out.println("Repo name: " + reponame + "\n" + "Username: " + username);
        MakeshiftExtraction ex = new MakeshiftExtraction(repo);
        System.out.println(ex.runCurl());
        
    }

}
