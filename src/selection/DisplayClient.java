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
        while (true) {
            System.out.println("##########################################################################");
            Scanner kb = new Scanner(System.in);
            Repository repo = new Repository();
            repo = makeRepo(repo);
            System.out.println("Select how to display: \n 1: By repo \n 2: By User \n 3: By Date \n 0: Quit");
            int var = kb.nextInt();
            kb.nextLine();
            Display disp;
            switch (var) {
                case 0: {
                    System.exit(0);
                }
                case 1: {
                    disp = new ByRepo(repo);
                    disp.display();
                    break;
                }
                case 2: {
                    System.out.println("Enter User: ");
                    String user = kb.nextLine();
                    // String buff = kb.nextLine();
                    disp = new ByUser(repo, user);
                    disp.display();
                    break;
                }
                case 3: {
                    Date d1 = null;
                    while (d1 == null) {
                        System.out.println("Enter the dates in the format YYYY-DD-MM");
                        String dateString1 = kb.nextLine();
                        d1 = toDate(dateString1);
                        if (d1 == null) {
                            System.out.println("Wrong date format for start date.");
                        }
                    }
                    // kb.nextLine();
                    Date d2 = null;
                    while (d2 == null) {
                        String dateString2 = kb.nextLine();
                        // System.out.println("I done goofed and didn't figure out the date System that was used in the Extraction package in this sprint. We'll get 'em next time. '");
                        d2 = toDate(dateString2);
                        if (d2 == null) {
                            System.out.println("Wrong date format for end date.");
                            System.out.println("Enter end date again with the format YYYY-DD-MM");
                        }
                    }
                    disp = new ByDate(repo, d1, d2);
                    disp.display();

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
    }
    public static Date toDate(String dateString){
        SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd");
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
