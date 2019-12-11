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
    public void testAddCommits()
    {
        Collaborator collab = new Collaborator("person", "test", "person", "4");
        repo.addCommit(new Commit("comm 1", collab));
        System.err.println("Result: PASSED\n");

    }

    @Test
    public void testAddCollaborator()
    {
        Collaborator collab = new Collaborator("person", "test", "person", "4");
        repo.addCollaborator(collab);
        System.err.println("Result: PASSED\n");
    }

    @Test
    public void testAddIssues()
    {
        Collaborator collab = new Collaborator("person", "test", "person", "4");
        repo.addIssue(new Issue("iss 1", collab));
        repo.addIssue(new Issue("iss 2", collab));
        System.err.println("Result: PASSED\n");
    }

    @Test
    public void testAddComments()
    {
        Collaborator collab = new Collaborator("person", "test", "person", "4");
        Comment comm5 = new Comment("cool2", collab, "type2");
        repo.addComment(comm5);
        System.err.println("Result: PASSED\n");
    }
}
