package selection;

import java.util.Scanner;

public class Get_Info {
    static Scanner sc = new Scanner(System.in);
    static String user_name;
    static String input;
    static String TOKEN;

    public void setUser_name() {
        this.user_name = scan_input();
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setTOKEN() {
        this.TOKEN = scan_input();
    }

    public String getTOKEN() {
        return this.TOKEN;
    }

    public static String scan_input() {
        input = sc.nextLine();
        return input;
    }

    public static int scan_input_int() {
        int input_int = sc.nextInt();
        return input_int;
    }
}
