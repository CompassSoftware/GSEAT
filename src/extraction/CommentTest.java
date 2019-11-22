/**
 * Comment Test
 *
 */
package extraction;
import github.Comment;
import github.Collaborator;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CommentTest 
{
    Comment comment;
    Collaborator c1;
    @BeforeEach//Initialize Collaborator object for testing.
        public void init()
        {
             
            c1 = new Collaborator("Nischinth", "Murari", "Nischinth-bot", "i12849");
            comment = new Comment("Initial Comment", c1, "issue");
        }
    @Test
        public void testGetters()
        {
            Assert.assertEquals(comment.getUserName(), "Nischinth-bot");
            Assert.assertEquals(comment.getCommentText(), "Initial Comment");
            Assert.assertEquals(comment.getCommentType(), "issue");
            Assert.assertEquals(comment.getDateCreated(), LocalDate.now());
            Assert.assertEquals(comment.getDateUpdated(), LocalDate.now());
        }

    @Test 
        public void testSetters()
        {
            comment.setUserName("Heironymous-bot");
            Assert.assertEquals(comment.getUserName(), "Heironymous-bot");
            comment.setCommentText("2nd Comment");
            Assert.assertEquals(comment.getCommentText(), "2nd Comment");
            comment.setCommentType("repo");
            Assert.assertEquals(comment.getCommentType(), "repo");
        }

}
