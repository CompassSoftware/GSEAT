package github;
/**
 * Collaborator Test
 *
 */
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;

public class CollaboratorTest 
{
    Collaborator c1;
    Collaborator c2;
    Issue issue1;
    Commit commit1;
    Comment comment1;
    ArrayList<Commit> commits;
    ArrayList<Issue> issues;
    ArrayList<Comment> comments;

    @BeforeEach//Initialize two Collaborator objects for testing.
        public void init()
        { 
            c1 = new Collaborator(); 
            c2 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            
            commit1 = new Commit("A commit message body.", c2);
            issue1 = new Issue("An issue description.", c2);
            comment1 = new Comment("Comment text.", c2, "Issue");
            
            commits = new ArrayList<Commit>();
            issues = new ArrayList<Issue>();
            comments = new ArrayList<Comment>();
            
            commits.add(commit1);
            issues.add(issue1);
            comments.add(comment1);
            
            c2.addIssue(issue1);
            c2.addCommit(commit1);
            c2.addComment(comment1);
            
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(c2.getFirstName(), "Nischinth");
            Assert.assertEquals(c2.getLastName(), "Murari");
            Assert.assertEquals(c2.getUserName(), "Nischinth-bot");
            Assert.assertEquals(c2.getID(), "i12849");
            Assert.assertEquals(c2.getIssues().get(0), issue1);
            Assert.assertEquals(c2.getCommits().get(0), commit1);
            Assert.assertEquals(c2.getComments().get(0), comment1);
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

}
