import java.time.LocalDate;
import github.Comment;
import github.Repository;
import github.Issue;
import github.Commit;
import java.util.ArrayList;
//import github.Collaborator;

/**
 * Analysis.java.
 * @author Brooke Tibbett, Courtney Dixon, Val Lapensee-Rankine, Ethan Hahn
 * @version 11/4/19
 */
public class Analysis
{
    Repository repo;

    /**
     * Analysis constructor.
     *
     * @param r Repository object given by extraction
     */
    public Analysis(Repository r)
    {
        repo = r;
    }
    
    /**
     * countCommits.
     *
     * Counts repo commits
     *
     * @return count of commits
     */
    public int countCommits()
    {
        return repo.getCommits().size();
    }

    /**
     * countIssues.
     *
     * Counts repo issues
     */
    public int countIssues()
    {
        return repo.getIssues().size();
    }

    /**
     * countIssuesComments
     *
     * Counts the comments that each issue has for all
     *  issues in the repo.
     *
     * @return count of comments
     */
    public int countIssuesComments()
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            count += i.getComments().size();
        }
        return count;
    }

    /**
     * countCommitsComments
     *
     * Counts the comments that each commit has for all
     * issues in the repo.
     *
     * @return count of comments
     */
    public int countCommitsComments()
    {
        int count = 0;
        for (Commit j : repo.getCommits())
        {
            count += j.getComments().size();
        }
        return count;
    }
   
    
    /**
    * countCommentsByCollaborator
    * Counts the comments made by a collaborator.
    * 
    * @param username of collaborator
    * @return count of comments
    */
    public int countCommentsByCollaborator(String username)
    {
        int count = 0;
        count += countIssueCommentsByCollaborator(username);
        count += countCommitCommentsByCollaborator(username);
        return count;
    }

    /**
    * countIssueCommentsByCollaborator
    * Counts issue comments made by colllaborator.
    *
	* @param username of collaborator
    * @return count of comments
    */
    public int countIssueCommentsByCollaborator(String username)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countIssueCommentsByCollaborator
    * Counts issue comments made by colllaborator.
    *
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countIssueCommentsByCollaborator(String username, 
		LocalDate start, LocalDate end)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username) 
					&& (start.compareTo(c.getDateCreated()) <= 0) 
					&& (end.compareTo(c.getDateCreated()) >= 0))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countCommitCommentsByCollaborator
    * Counts commit comments made by collaborator.
    *
	* @param username of collaborator
    * @return count of comments
    */
    public int countCommitCommentsByCollaborator(String username)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countCommitCommentsByCollaborator
    * Counts commit comments made by collaborator.
    *
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countCommitCommentsByCollaborator(String username, 
		LocalDate start, LocalDate end)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getUserName()).equals(username) 
					&& (start.compareTo(c.getDateCreated()) <= 0) 
					&& (end.compareTo(c.getDateCreated()) >= 0))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
    * countCommentsByCollaborator
    * Counts the comments made by a collaborator through dates.
    * 
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countCommentsByCollaborator(String username, 
		LocalDate start, LocalDate end)
    {
        int count = 0;
        count += countIssueCommentsByCollaborator(username, start, end);
        count += countCommitCommentsByCollaborator(username, start, end);
        return count;
    }

    /**
     * countIssuesByCollaborator.
     *
     * Count the number of issues each collaborator has
     * created in the whole time of the project.
     *
     * @param username of the Collaborator who's issues
     *  are being counted
     *
     * @return number of issues that the collaborator has
     */
    public int countIssuesByCollaborator(String username)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            if ((i.getUserName()).equals(username))
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * countIssuesByCollaborator
     *
     * Count the number of issues each collaborator has
     * created within the dates.
     * 
     * @param username of the Collaborator who's issues
     *  are being counted
     *
     * @return : number of issues that the collaborator has
     *  within the dates
     *         : -1 if start > end
     * @param start - The start date.
     * @param end - The end date.
     */
    public int countIssuesByCollaborator(String username, LocalDate start, 
            LocalDate end)
    {
        if (start.isAfter(end))
        {
            return -1;
        }
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            if ((i.getUserName()).equals(username)
                && i.getDateCreated().compareTo(start) >= 0
                && i.getDateCreated().compareTo(end) <= 0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * countCollaboratorCommits
     *
     * Count the number of commits made by certain
     * collaborator.
     * 
     * @param username of the Collaborator who's issues
     *  are being counted
     *
     * @return : number of commits made by a collaborator
     */
    public int countCollaboratorCommits(String username)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            if (i.getUserName().equals(username)) 
            {
                count++;
            }
        }
        return count;
    }

    /**
     * countCollaboratorCommits
     *
     * Count the number of commits each collaborator has
     * made within the dates.
     * 
     * @param username of the Collaborator whose commits
     *  are being counted
     *
     * @return : number of commits that the collaborator has
     *  within the dates
     *         : -1 if start > end
     * @param start - The start date.
     * @param end - The end date.
     */
    public int countCollaboratorCommits(String username, LocalDate start, 
            LocalDate end)
    {
        if (start.isAfter(end))
        {
            return -1;
        }
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            if ((i.getUserName()).equals(username)
                && i.getDateCreated().compareTo(start) >= 0
                && i.getDateCreated().compareTo(end) <= 0)
            {
                count++;
            }
        }
        return count;
    }
}

