/** Demo.java
 *
 * @author:Yuanboz
 *
 * @version: Sprint 3 version
 *
 * This Demo can separate user's repositories in many page. User can set how many repositories in one page,
 * and can switch the page by input the number.
 */

import selection.*;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        int e = 0;  //initial the element in one page
        int page = 1;   //initial the page
        int stop = 1;   //check if user wants to stop or not
        Get_Info g = new Get_Info();
        System.out.println("Please input your Username: ");
        g.setUser_name();   //get user_name
        System.out.println("Please input TOKEN: ");
        g.setTOKEN();   //get user's TOKEN

        System.out.println("Number of Repositories in one page: ");
        e = Get_Info.scan_input_int();  // set the capacity of one page
        List<String> list_repo_name = new ArrayList<String>();
        ListOutput.addInput(list_repo_name, Repo_Info.get_repo_name());
        ListOutput<String> pm = new ListOutput<String>(list_repo_name, e);
        List<String> sublist = pm.getObjects(page);

        /** page 1 as the default */
        pm.description();
        for (int i = 0; i < sublist.size(); i++) {
            System.out.println(sublist.get(i));
        }

        /** Page operation */
        while (stop!= 111) {
            System.out.print("Enter the page: ");
            page = g.scan_input_int();
            stop = page;
            sublist = pm.getObjects(page);
            pm.description();
            for (int i = 0; i < sublist.size(); i++) {
                System.out.println(sublist.get(i));
            }
            System.out.println("Press 111 to stop the program.");
        }
    }
}
