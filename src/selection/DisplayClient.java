package selection;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import github.Repository;


public class DisplayClient {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Repository repo = new Repository();
        System.out.println("Select how to display: \n 1: By repo \n 2: By User \n 3: By Date");
        int var = kb.nextInt();
        ByRepo disp;
        switch (var) {
            case 1: {
                disp = new ByRepo(repo);
                break;
            }
            case 2: {
                System.out.println("Enter User: ");
                String buff = kb.nextLine();
                String user = kb.nextLine();
                disp = new ByRepo(repo);
                disp.display();
                break;
            }
            case 3: {
                System.out.println("Enter the dates in the format DD/MM/YYY ");
                String dateString1 = kb.nextLine();
                String dateString2 = kb.nextLine();
                Date date1 = dateStringToDate(dateString1);
                Date date2 = dateStringToDate(dateString2);
                disp = new ByRepo(repo);
                break;
                //Pass these dates to a ByDate class.
                //ByDate should extend the display class.
                //ByDate should handle the display.
            }
            default: {
                System.out.println("Please choose: ");
                break;
            }
        }
    }
    public static Date dateStringToDate(String dateString) {
        SimpleDateFormat formatter =
            new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            dateString = dateString.replace('T', ' ');
            dateString = dateString.replace('Z', ' ');
            date = formatter.parse(dateString);
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }
    public Repository makeRepo() {
        
    }
}
