package github;
/**
 * Comment Test
 *
 */
import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CommentTest 
{
    Comment comment;
    Collaborator c1;
    Date d;
    @BeforeEach//Initialize Collaborator object for testing.
        public void init()
        {
             
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            comment = new Comment("Initial Comment", c1, "issue");
            d = new Date();
            comment.setDateCreated(d);
            comment.setDateUpdated(d);
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(comment.getCollaborator().getUserName(), "Nischinth-bot");
            Assert.assertEquals(comment.getCommentText(), "Initial Comment");
            Assert.assertEquals(comment.getCommentType(), "issue");
            Assert.assertEquals(comment.getDateCreated(), d);
            Assert.assertEquals(comment.getDateUpdated(), d);
        }

    @Test 
        public void testSetters()
        {
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            comment.setCollaborator(c1);
            Assert.assertEquals(comment.getCollaborator().getUserName(), "Nischinth-bot");
            comment.setCommentText("2nd Comment");
            Assert.assertEquals(comment.getCommentText(), "2nd Comment");
            comment.setCommentType("repo");
            Assert.assertEquals(comment.getCommentType(), "repo");
        }

}
