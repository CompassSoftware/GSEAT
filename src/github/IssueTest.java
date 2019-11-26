package github;
/**
 * Issue Test
 *
 */
import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class IssueTest 
{
    Issue issue;
    Collaborator c1;
    Date d;
    @BeforeEach//Initialize Collaborator object for testing.
        public void init()
        {
             
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            issue = new Issue("Initial Issue", c1);
            d = new Date();
            issue.setDateCreated(d);
            issue.setDateUpdated(d);
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(issue.getCollaborator().getUserName(), "Nischinth-bot");
            Assert.assertEquals(issue.getIssueText(), "Initial Issue");
            Assert.assertEquals(issue.getDateCreated(), d);
            Assert.assertEquals(issue.getDateUpdated(), d);
        }

    @Test 
        public void testSetters()
        {
            issue.setCollaborator(c1);
            Assert.assertEquals(issue.getUserName(), "Nischinth-bot");
            issue.setIssueText("2nd Issue");
            Assert.assertEquals(issue.getIssueText(), "2nd Issue");
        }

}
