import selection.*;

import java.util.ArrayList;
import java.util.List;

/* Demo.java for selection team
 *
 *@author: Yuanboz  Zhengyu Luo
 *
 *@version: 1.0 
 */

public class Demo {

    public static void main(String[] args) {

        Get_Info g = new Get_Info();
        System.out.println("Please input your Username: ");
        g.setUser_name();
        System.out.println("Please input TOKEN: ");
        g.setTOKEN();

        List<String> list = new ArrayList<String>();
        ListOutput.addInput(list, Repo_Info.get_repo_url());
        ListOutput<String> pm = new ListOutput<String>(list, 5);
        pm.description();
        while (true) {
            System.out.println("Enter the page: ");
            int page = Get_Info.scan_input_int();
            List<String> sublist = pm.getObjects(page);
            pm.description();
            for (int i = 0; i < sublist.size(); i++) {
                System.out.println(sublist.get(i));
            }
        }
    }
}
