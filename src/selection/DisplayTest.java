package selection;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;

import github.Repository;
import github.Comment;
import github.Issue;
import github.Collaborator;
import github.Commit;

public class DisplayTest {


    @Test
    public void testDisplayConstructor() {
        assertTrue((new ByRepo(new Repository())) instanceof Display);
        assertTrue((new ByDate(new Repository(), new Date(), new Date())) instanceof Display);
        assertTrue((new ByUser(new Repository(), new String("Hello"))) instanceof Display);
    }

    // @Test
    // public void testByUser() {
    //     Collaborator collab = new Collaborator("person","test","person","4");
    //     Collaborator collab2 = new Collaborator("person2", "test1", "person2User", "5");
    //
    //     Issue i1 = new Issue("issue1", collab);
    //     i1.addComment(new Comment("another thing", collab, "issue"));
    //     i1.addComment(new Comment("a thing", collab, "issue"));
    //     i1.addComment(new Comment("things", collab, "issue"));
    //     Issue i2 = new Issue("issue2", collab);
    //     i2.addComment(new Comment("more things", collab, "issue"));
    //     i2.addComment(new Comment("more more things", collab, "issue"));
    //
    //     Repository repo = new Repository();
    //     repo.addIssue(i1);
    //     repo.addIssue(i2);
    //
    //     Analysis analysis = new Analysis(repo);
    //
    //     int expected = 5;
    //     int actual = analysis.countIssuesComments();
    //
    //     assertEquals(expected, actual);
    // }
}
