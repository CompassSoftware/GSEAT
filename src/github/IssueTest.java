package github;
/**
 * Issue Test
 *
 */
import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

public class IssueTest 
{
    Issue issue;
    Collaborator c1;
    Date d;
    ArrayList<Comment> comments;
    @BeforeEach//Initialize Collaborator object for testing.
        public void init()
        {

            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            d = new Date();
            comments = new ArrayList<Comment>();
            issue = new Issue("Initial Issue", c1,d,d,comments);     
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
            Assert.assertEquals(issue.getCollaborator().getUserName(), "Nischinth-bot");
            issue.setIssueText("2nd Issue");
            Assert.assertEquals(issue.getIssueText(), "2nd Issue");
        }

    @Test
        public void testAddComment()
        {
            Comment com = new Comment("This is number one", c1, "repo", d, d);
            issue.addComment(com);
            Assert.assertEquals(issue.getComments().get(0).getCommentText(), "This is number one");
            Assert.assertEquals(issue.getComments().get(0).getCollaborator().getUserName(), "Nischinth-bot");
            Assert.assertEquals(issue.getComments().get(0).getCommentType(), "repo");
            Assert.assertEquals(issue.getComments().get(0).getDateCreated(), d);
        }

    @Test
        public void testGetComments()
        {
            Comment com1 = new Comment("This is number one", c1, "repo", d, d); 
            Comment com2 = new Comment("This is number two", c1, "commit", d, d);
            Comment com3 = new Comment("This is number three", c1, "repo", d, d);
            Comment com4 = new Comment("This is number four", c1, "repo", d, d);
            Comment com5 = new Comment("This is number five", c1, "repo", d, d);
            ArrayList<Comment> cs = new ArrayList<Comment>();
            cs.add(com1);
            cs.add(com2);
            cs.add(com3);
            cs.add(com4);
            cs.add(com5);
            issue.addComment(com1);
            issue.addComment(com2);
            issue.addComment(com3);
            issue.addComment(com4);
            issue.addComment(com5);
            Assert.assertArrayEquals(cs.toArray(), issue.getComments().toArray());
        }
}
