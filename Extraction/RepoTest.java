/**
 * Repo Test
 *
 */
package extraction;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RepoTest 
{
    Repository repo;

    @BeforeEach
        public void init()
        { 
            repo = new Repository();
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
