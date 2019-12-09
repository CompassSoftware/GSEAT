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



}
