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
    
}
