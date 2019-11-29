package github;
/**
 * Repository Test
 *
 */
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RepositoryTest 
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
            Repository repo = new Repository();
            repo.addCommit(new Commit("henry", new Collaborator()));
            repo.addCollaborator(new Collaborator());
            System.err.println("Result: PASSED\n");
        }

}
