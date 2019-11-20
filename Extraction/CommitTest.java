/**
 * Collaborator Test
 *
 */

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CommitTest 
{
    Commit cc;
    Collaborator c1;
    @BeforeEach//Initialize two Collaborator objects for testing.
        public void init()
        {
             
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            cc = new Commit("Initial Commit", c1);
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(cc.getUserName(), "Nischinth-bot");
            Assert.assertEquals(cc.getInfo(), "Initial Commit");
            Assert.assertEquals(cc.getDateCreated(), null);
            Assert.assertEquals(cc.getDateUpdated(), null);
        }

    @Test 
        public void testSetters()
        {
            cc.setUserName("Heironymous-bot");
            Assert.assertEquals(cc.getUserName(), "Heironymous-bot");
            cc.setInfo("2nd Commit");
            Assert.assertEquals(cc.getInfo(), "2nd Commit"); 
        }

}
