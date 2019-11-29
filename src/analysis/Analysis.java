package analysis;

import java.util.Date;
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
     * @return count of issues
     */
    public int countIssues()
    {
        return repo.getIssues().size();
    }

     /**
     * countCommitsWithDates.
     *
     * Counts repo commits
     *
     * @param start start date
     * @param end end date
     * @return count of commits
     */
    public int countCommits(Date start, Date end)
    {
        int count = 0;
        for (Commit c : repo.getCommits())
        {
            if ((start.compareTo(c.getDateCreated()) <= 0) 
					&& (end.compareTo(c.getDateCreated()) >= 0))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * countIssuesWithDates.
     *
     * Counts repo issues
     *
     * @param start start date
     * @param end end date
     * @return count of issues
     */
    public int countIssues(Date start, Date end)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            if ((start.compareTo(i.getDateCreated()) <= 0) 
					&& (end.compareTo(i.getDateCreated()) >= 0))
            {
                count++;
            }
        }
        return count;
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
     * countIssuesComments.
     *
     * Counts the comments that each issue has for all
     * issues in the repo for the desired dates.
     * 
     * @param start - the earliest date that comments will
     *  be counted from.
     * @param end - the latest date that comments will be counted to.
     *
     * @return count of comments
     */
    public int countIssuesComments(Date start, Date end)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((start.compareTo(c.getDateCreated()) <= 0) 
					&& (end.compareTo(c.getDateCreated()) >= 0))
                {
                    count++;
                } 
            }
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
     * countCommitsComments
     *
     * Counts the comments that each commit has for all
     * issues in the repo.
     *
     * @param start - the earliest date that comments will
     *  be counted from.
     * @param end - the latest date that comments will be counted to.
     *
     * @return count of comments
     */
    public int countCommitsComments(Date start, Date end)
    {
        int count = 0;
        for (Commit j : repo.getCommits())
        {
            ArrayList<Comment> comments = j.getComments();
            for (Comment w : comments)
            {
                if (w.getDateCreated().compareTo(start) >= 0
                    && w.getDateCreated().compareTo(end) <= 0)
                {
                    count++;
                }
            }
        }
        return count;
    }

     /**
     * countRepoComments
     *
     * Counts the comments that each commit has for repo.
     *
     * @return count of comments
     */
    public int countRepoComments()
    {
        return repo.getComments().size();
    }
   
    /**
     * countRepoComments
     *
     * Counts the comments that each commit has for the repo
	 * between 2 dates.
     *
     * @param start - the earliest date that comments will
     *  be counted from.
     * @param end - the latest date that comments will be counted to.
     *
     * @return count of comments
     */
    public int countRepoComments(Date start, Date end)
    {
        int count = 0;
        for (Comment w : repo.getComments())
        {
            if (w.getDateCreated().compareTo(start) >= 0
                && w.getDateCreated().compareTo(end) <= 0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * countComments
     * Counts the total number of comments in the repository.
     *
     * @return number of comments in the repository.
     */
    public int countComments()
    {
        int total = countIssuesComments();
        total += countCommitsComments();
		total += countRepoComments();
        return total;
    }
    
    /**
     * countComments
     * Counts the total number of comments in the repository.
     *
     * @param start - the earliest date that comments will
     *  be counted from.
     * @param end - the latest date that comments will be counted to.
     *
     * @return number of comments in the repository between
     *  certain dates.
     */
    public int countComments(Date start, Date end)
    {
        int total = countIssuesComments(start, end);
        total += countCommitsComments(start, end);
		total += countRepoComments(start, end);
        return total;
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
		count += countRepoCommentsByCollaborator(username);
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
		Date start, Date end)
    {
        int count = 0;
        count += countIssueCommentsByCollaborator(username, start, end);
        count += countCommitCommentsByCollaborator(username, start, end);
		count += countRepoCommentsByCollaborator(username, start, end);
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
                if ((c.getCollaborator().getUserName()).equals(username))
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
		Date start, Date end)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getCollaborator().getUserName()).equals(username) 
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
                if ((c.getCollaborator().getUserName()).equals(username))
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
		Date start, Date end)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            ArrayList<Comment> comments = i.getComments();
            for (Comment c : comments)
            {
                if ((c.getCollaborator().getUserName()).equals(username) 
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
    * countRepoCommentsByCollaborator
    * Counts repo comments made by collaborator.
    *
	* @param username of collaborator
    * @return count of comments
    */
    public int countRepoCommentsByCollaborator(String username)
    {
        int count = 0;
        for (Comment c : repo.getComments())
        {
            if ((c.getCollaborator().getUserName()).equals(username))
            {
                count++;
            }
        }
        return count;
    }

    /**
    * countRepoCommentsByCollaborator
    * Counts repo comments made by collaborator.
    *
	* @param username of collaborator
	* @param start date
	* @param end date
    * @return count of comments
    */
    public int countRepoCommentsByCollaborator(String username, 
		Date start, Date end)
    {
        int count = 0;
        for (Comment c : repo.getComments())
        {
            if ((c.getCollaborator().getUserName()).equals(username) 
				&& (start.compareTo(c.getDateCreated()) <= 0) 
				&& (end.compareTo(c.getDateCreated()) >= 0))
            {
                count++;
            }
        }
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
            if ((i.getCollaborator().getUserName()).equals(username))
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
    public int countIssuesByCollaborator(String username, Date start, 
            Date end)
    {
        int count = 0;
        for (Issue i : repo.getIssues())
        {
            if ((i.getCollaborator().getUserName()).equals(username)
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
            if (i.getCollaborator().getUserName().equals(username)) 
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
    public int countCollaboratorCommits(String username, Date start, 
            Date end)
    {
        int count = 0;
        for (Commit i : repo.getCommits())
        {
            if ((i.getCollaborator().getUserName()).equals(username)
                && i.getDateCreated().compareTo(start) >= 0
                && i.getDateCreated().compareTo(end) <= 0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * countContributionsByCollaborator
     * Counts the total number of contributions(comments, issues,
     *  etc) in the repository by a specific collaborator, added
     *  during certain dates.
     *
     * @param username - the username of the collaborator
     * @param start - the earliest date to count contributions from
     * @param end - the latest date to count contributions to
     *
     * @return sum of issues, comments, commits, etc by specific
     *  collaborator during certain date range.
     */
    public int countContributionsByCollaborator(String username,
        Date start, Date end)
    {
        int total = countIssuesByCollaborator(username, start, end);
        total += countCollaboratorCommits(username, start, end);
        total += countCommentsByCollaborator(username, start, end);
        return total;
    }

    /**
     * Count the number of commits, comments, 
     * and issues for Repo between 2 dates.
     *
     * @param start start date
     * @param end end date
     *
     * @return total 
     *              total number of commits, comments, and issues
     *              between two specified dates
     */
    public int countContributionsBetweenDates(Date start, Date end)
    {
        int total = 0;
        //int[] totals = new int[4];        
        total += countCommits(start, end);
        //totals[0] = countCommits(start, end);
        total += countComments(start, end);
        //totals[1] = countComments(start, end);
        total += countIssues(start, end);
        //totals[2] = countIssues(start, end);
        //totals[3] = totals[0] + totals[1] + totals[2];
        //return totals
        return total;
    }
}

