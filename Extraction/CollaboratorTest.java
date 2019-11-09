/**
 * Collaborator Test
 *
 */
package extraction;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CollaboratorTest 
{
    Collaborator c1;
    Collaborator c2;

    @BeforeEach//Initialize two Collaborator objects for testing.
        public void init()
        { 
            c1 = new Collaborator(); 
            c2 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(c2.getFirstName(), "Nischinth");
            Assert.assertEquals(c2.getLastName(), "Murari");
            Assert.assertEquals(c2.getUserName(), "Nischinth-bot");
            Assert.assertEquals(c2.getID(), "i12849");
        }

    @Test 
        public void testSetters()
        {
            c1.setFirstName("Hari");
            Assert.assertEquals(c1.getFirstName(), "Hari");
            c1.setLastName("George");
            Assert.assertEquals(c1.getLastName(), "George");
            c1.setUserName("HariGeorgeTheFirst");
            Assert.assertEquals(c1.getUserName(), "HariGeorgeTheFirst");
        }

        @Test
    public void testRepository()
    {
        Extraction extract = new Extraction();
        Repository repo = new Repository();
        repo.addCommit(new Commit("henry", new Collaborator()));
        repo.addCollaborator(new Collaborator());
        extract.addRepo(repo);
        System.err.println("Result: PASSED\n");
    }

}
