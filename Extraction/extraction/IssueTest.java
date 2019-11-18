package extraction;
/**
 * Issue Test
 *
 */
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class IssueTest 
{
    Issue issue;
    Collaborator c1;
    @BeforeEach//Initialize Collaborator object for testing.
        public void init()
        {
             
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            issue = new Issue("Initial Issue", c1);
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(issue.getUserName(), "Nischinth-bot");
            Assert.assertEquals(issue.getIssueText(), "Initial Issue");
            Assert.assertEquals(issue.getDateCreated(), LocalDate.now());
            Assert.assertEquals(issue.getDateUpdated(), LocalDate.now());
        }

    @Test 
        public void testSetters()
        {
            issue.setUserName("Heironymous-bot");
            Assert.assertEquals(issue.getUserName(), "Heironymous-bot");
            issue.setIssueText("2nd Issue");
            Assert.assertEquals(issue.getIssueText(), "2nd Issue");
        }

}
