package github;
/**
 * Collaborator Test
 *
 */
import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CommitTest 
{
    Commit cc;
    Collaborator c1;
    Date d;
    @BeforeEach//Initialize two Collaborator objects for testing.
        public void init()
        {
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            cc = new Commit("Initial Commit", c1);
            d = new Date();
            cc.setDateCreated(d);
        }
        
    @Test
        public void testGetters()
        {
            Assert.assertEquals(cc.getCollaborator().getUserName(), "Nischinth-bot");
            Assert.assertEquals(cc.getInfo(), "Initial Commit");
            Assert.assertEquals(cc.getDateCreated(), d);
            Assert.assertEquals(cc.getDateUpdated(), d);
        }

    @Test 
        public void testSetters()
        {
            cc.setCollaborator(c1);
            Assert.assertEquals(cc.getCollaborator().getUserName(), "Heironymous-bot");
            cc.setInfo("2nd Commit");
            Assert.assertEquals(cc.getInfo(), "2nd Commit"); 
        }

}
