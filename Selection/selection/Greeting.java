/** Greeting.java
 *
 * Slection team
 *
 * Greeting_UI
 *
 * @author Zack
 *
 * @version 1.0
 */

package selection;

import java.util.Scanner;

public class Greeting {

    static Scanner sc = new Scanner(System.in);
    static String user_name;
    static String input;

    /** Greeting_UI. Prompt for user's username
     * @user_name       user's name
     */
    public void greeting() {
        System.out.println("Please input your userName: ");
        user_name = scan_input();
        System.out.println("Welcome, " + user_name + "!");
    }

    /** Scan user's input
     * @input       user's input
     * @return      input
     */
    public static String scan_input() {
        input = sc.nextLine();
        return input;
    }
}

