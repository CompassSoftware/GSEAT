package selection;

import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import github.Repository;
import github.Commit;
import github.Comment;
import github.Issue;
import github.Collaborator;


public class DisplayClient {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Repository repo = new Repository();
        repo = makeRepo(repo);
        System.out.println("Select how to display: \n 1: By repo \n 2: By User \n 3: By Date");
        int var = kb.nextInt();
        Display disp;
        switch (var) {
            case 1: {
                disp = new ByRepo(repo);
                disp.display();
                break;
            }
            case 2: {
                System.out.println("Enter User: ");
                String buff = kb.nextLine();
                String user = kb.nextLine();
                disp = new ByUser(repo, user);
                disp.display();
                break;
            }
            case 3: {
                System.out.println("Enter the dates in the format DD/MM/YYYY");
                String dateString1 = kb.nextLine();
                kb.nextLine();
                String dateString2 = kb.nextLine();
                System.out.println("I done goofed and didn't figure out the date System that was used in the Extraction package in this sprint. We'll get 'em next time. '");
                // LocalDate date1 = dateStringToDate(dateString1);
                // LocalDate date2 = dateStringToDate(dateString2);
                // disp = new ByDate(repo, date1, date2);
                // disp.display();
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
    // public static LocalDate dateStringToDate(String dateString) {
    //     SimpleDateFormat formatter =
    //         new SimpleDateFormat("dd/MM/yyyy");
    //     LocalDate date;
    //     try {
    //         dateString = dateString.replace('T', ' ');
    //         dateString = dateString.replace('Z', ' ');
    //         date = formatter.parse(dateString);
    //     }
    //     catch (ParseException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    //     return date;
    // }
    public static Repository makeRepo(Repository repo) {
        Collaborator coll1 = new Collaborator("mister", "test", "tester1", "2");
        Collaborator coll2 = new Collaborator("misses", "test", "tester2", "3");

        Issue i1 = new Issue("issue 1", coll2);
        Comment comm1 = new Comment("this is good", coll1, "type1");
        // comm1.setdateCreated(LocalDate.now().minusDays(4));
        // i1.addComment(comm1);
        Comment comm2 = new Comment("this is bad", coll1, "type1");
        // comm2.setdateCreated(LocalDate.now());
        i1.addComment(comm2);

        Issue i2 = new Issue("issue 2", coll1);
        i2.addComment(new Comment("this is okay", coll2, "type2"));

        Commit com1 = new Commit("commit 1", coll1);
        com1.addComment(new Comment("cool", coll2, "type2"));

        Commit com2 = new Commit("commit 2", coll2);
        Comment comm3 = new Comment("cool2", coll1, "type2");
        // comm3.setdateCreated(LocalDate.now().minusDays(10));
        com2.addComment(comm3);

        Comment comm4 = new Comment("cool2", coll1, "type2");
        // comm3.setdateCreated(LocalDate.now().minusDays(10));
        com2.addComment(comm4);

        Comment comm5 = new Comment("cool2", coll1, "type2");
        // comm3.setdateCreated(LocalDate.now().minusDays(10));
        com2.addComment(comm5);
        repo = new Repository();
        repo.addIssue(i1);
        repo.addIssue(i2);
        repo.addCommit(com1);
        repo.addCommit(com2);

        return repo;
    }
}
