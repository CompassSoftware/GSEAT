package analysis;

import java.util.Date;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.lang.StringBuffer;
import github.Comment;
import github.Repository;
import github.Issue;
import github.Commit;
import java.util.ArrayList;
import github.Collaborator;

/**
 * Analysis.java.
 * @author Brooke Tibbett, Courtney Dixon, Val Lapensee-Rankine, Ethan Hahn
 * @version 11/4/19
 */
public class Analysis
{
    private static final long MILLISPERDAY = 86400000;
    private static final long DAYSPERPERIOD = 7;
    private static final long FRACTIONTOPERCENT = 100;
    private static final long CHECKBEFORE = 2;

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
     *
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
     * countContributionsByCollaborator
     *
     * Counts the total number of contributions(comments, issues,
     *  etc) in the repository by a specific collaborator.
     *
     * @param username - the username of the collaborator
     *
     * @return sum of issues, comments, commits, etc by specific
     *  collaborator during certain date range.
     */
    public int countContributionsByCollaborator(String username)
    {
        int total = countIssuesByCollaborator(username);
        total += countCollaboratorCommits(username);
        total += countCommentsByCollaborator(username);
        return total;
    }

    /**
     * countContributions
     *
     * Count the number of commits, comments, and
     * issues for Repo.
     *
     * @return total
     *              total number of commits, comments,
     *              and issues
     */
    public int countContributions() 
    {
        return countCommits() 
            + countComments() 
            + countIssues();
    }

    /**
     * countContributionsBetweenDates(...)
     *
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


    /**
     * contributionBreakdownByCollaborator(...)
     *
     * A method that returns a breakdown (string)
     * of what percentage of contributions for a
     * certain collaborator were done between each
     * 7 day period from the repo creation date to
     * the current date.
     *
     * @return info
     *             sentence containing contributions
     *             by collaborator through a set of
     *             7 day periods
     * @param username 
     *             the collaborator's username
     */
    public String contributionBreakdownByCollaborator(String username)
    {
        Date start = (Date) this.getRepoBeginDate();
        Date absoluteStart = (Date) start.clone();

        ArrayList<String> contributions = new ArrayList<>();

        Date current = new Date();
        Date end = ((Date) start.clone());
        end.setDate(start.getDate() + 7);

        DecimalFormat df = new DecimalFormat("###.00");

        String data = "";

        do {

            data = df.format(
                    ((double) (this.countContributionsByCollaborator(
                            username, start, end))
                     / (double) (this.countContributions()))
                    * FRACTIONTOPERCENT, new StringBuffer(),
                    new FieldPosition(0)).toString();

            contributions.add(start.toString() + " to " + end.toString() 
                    + " - " + data);

            start.setDate(start.getDate() + 7);

            end.setDate(start.getDate() + 7);

        } while (end.before(current));

        String message = "\nAll-time Contributions by " + username 
            + "\nFrom: " + absoluteStart.toString() + " To: " + start.toString()
            + "\nin weekly increments:\n\n";

        for (String s : contributions)
        {
            message += s + "\n";
        }

        return message;
    }

    /**
     * contributionBreakdownByCollaborator(...)
     *
     * A method that returns a breakdown (string)
     * of what percentage of contributions for a
     * certain collaborator were done between each
     * 7 day period from the specified start date
     * to the specified end date.
     *
     * @return info
     *             sentence containing contributions
     *             by collaborator through a set of
     *             7 day periods
     * @param username 
     *             the collaborator's username
     * @param s 
     *             the start date
     * @param e
     *             the end date
     */
    public String contributionBreakdownByCollaborator(String username,
            Date s, Date e)
    {
        Date start = (Date) s.clone();
        Date absoluteStart = (Date) start.clone();

        ArrayList<String> contributions = new ArrayList<>();

        Date current = (Date) e.clone();
        Date end = ((Date) start.clone());
        end.setDate(start.getDate() + 7);

        DecimalFormat df = new DecimalFormat("###.00");

        String data = "";

        do {

            data = df.format(
                    ((double) (this.countContributionsByCollaborator(
                            username, start, end))
                     / (double) (this.countContributions()))
                    * FRACTIONTOPERCENT, new StringBuffer(),
                    new FieldPosition(0)).toString();

            contributions.add(start.toString() + " to " + end.toString() 
                    + " - " + data);

            start.setDate(start.getDate() + 7);

            end.setDate(start.getDate() + 7);

        } while (end.before(current));

        String message = "\nAll-time Contributions by " + username 
            + "\nFrom: " + absoluteStart.toString() + " To: " + start.toString()
            + "\nin weekly increments:\n\n";

        for (String str : contributions)
        {
            message += str + "\n";
        }

        return message;
    }

    /**
     * percentContributionsByCollaborator(...)
     *
     * A method to return the percentage of all
     * contributions a certain collaborator made between dates.
     *
     * @param username - the collaborator
     * @param start - the start date
     * @param end - the end date
     * @return percentage of contributions
     */
    public double percentContributionsByCollaborator(String username, 
            Date start, Date end)
    {
        double contributions = countContributionsBetweenDates(start, end);
        if (contributions != 0.0)
        {
            return (double) countContributionsByCollaborator(username,
                    start, end) / contributions;
        }
        return 0.0;
    }

    /**
     * percentContributionsByCollaborator(...)
     *
     * A method to return the percentage of all
     * contributions a certain collaborator made between dates.
     *
     * @param username - the collaborator
     * @param start - the start date
     * @param end - the end date
     * @return percentage of contributions
     */
    public double percentContributionsByCollaborator(String username)
    {
        double contributions = countContributions();
        if (contributions != 0.0)
        {
            return (double) countContributionsByCollaborator(username) / contributions;
        }
        return 0.0;
    }

    /**
     * contributionBreakdown
     *
     * Returns a breakdown of percentage on contributions
     * of all collabortators were done between each 7 day
     * period from the repo creation date to the current date
     * 
     * @return String of percentage contributions for every
     * collaborator
     */
    public String contributionBreakdown() {
        ArrayList<Collaborator> collabs = repo.getCollaborators();
        String result = "";
        Date begin = getRepoBeginDate();
        Date start = getRepoBeginDate();
        Date end = (Date) start.clone();
        end.setDate(start.getDate() + 7);
        Date stop = new Date();

        String beginString = (begin.getYear() + 1900) + "-" + (begin.getMonth() + 1) + "-" + begin.getDate();
        String stopString = (stop.getYear() + 1900) + "-" + (stop.getMonth() + 1) + "-" + stop.getDate();


        for (Collaborator c: collabs) {
            result += "\nContributions by " + c.getUserName() 
                + "\nFrom: " + beginString + " To: " + stopString
                + " in weekly increments:\n\n";
            while (stop.after(start)) {
                String startString = (start.getYear() + 1900) + "-" + (start.getMonth() + 1) + "-" + start.getDate();
                String endString = (end.getYear() + 1900) + "-" + (end.getMonth() + 1) + "-" + end.getDate();

                result += startString + " to " + endString + ": ";
                result += ((double) countContributionsByCollaborator(c.getUserName(), start, end)
                        / (double) countContributionsBetweenDates(start, end)) * 100 + "%\n";
                start = end;
                end = (Date) start.clone();
                end.setDate(start.getDate() + 7);
            }
            start = getRepoBeginDate();
            end = (Date) start.clone();
            end.setDate(start.getDate() + 7);
        }
        return result;
    }    

    /**
     * contributionBreakdownByCollaborator
     *
     * Returns a breakdown of percentage on contributions
     * of all collabortators were done between each 7 day
     * period from the start date to the end date
     *
     * @param starting - the earliest date to count contributions from
     * @param ending - the latest date to count contributions to
     *
     * @return String of percentage contributions for every
     * collaborator
     */
    public String contributionBreakdown(Date starting, Date ending) {
        ArrayList<Collaborator> collabs = repo.getCollaborators();
        String result = "";
        Date begin = starting;
        Date start = starting;
        Date end = (Date) start.clone();
        end.setDate(start.getDate() + 7);
        Date stop = ending;

        String beginString = (begin.getYear() + 1900) + "-" + (begin.getMonth() + 1) + "-" + begin.getDate();
        String stopString = (stop.getYear() + 1900) + "-" + (stop.getMonth() + 1) + "-" + stop.getDate();


        for (Collaborator c: collabs) {
            result += "\nContributions by " + c.getUserName() 
                + "\nFrom: " + beginString + " To: " + stopString
                + " in weekly increments:\n\n";
            while (stop.after(start)) {
                String startString = (start.getYear() + 1900) + "-" + (start.getMonth() + 1) + "-" + start.getDate();
                String endString = (end.getYear() + 1900) + "-" + (end.getMonth() + 1) + "-" + end.getDate();

                result += startString + " to " + endString + ": ";
                result += ((double) countContributionsByCollaborator(c.getUserName(), start, end)
                        / (double) countContributionsBetweenDates(start, end)) * 100 + "%\n";
                start = end;
                end = (Date) start.clone();
                end.setDate(start.getDate() + 7);
            }
            start = starting;
            end = (Date) start.clone();
            end.setDate(start.getDate() + 7);
        }
        return result;
    }

    /** 
     * getRepoBeginDate(...)
     *
     * Loop through to figure out what the
     * beginning/start date of the repo is.
     *
     * @return start - the start date
     *                 of the repo
     */
    public Date getRepoBeginDate()
    {
        Date start = new Date();
        for (Issue i : repo.getIssues())
        {
            if (i.getDateCreated().before(start))
            {
                start = (Date) i.getDateCreated().clone();
            }
        }
        for (Commit c: repo.getCommits())
        {
            if (c.getDateCreated().before(start))
            {
                start = (Date) c.getDateCreated().clone();
            }
        }
        for (Comment c: repo.getComments())
        {
            if (c.getDateCreated().before(start))
            {
                start = (Date) c.getDateCreated().clone();
            }
        }

        return start;
    }

    /**
     * Returns a string representation of collaborator information.
     * 
     * @return i collaborator info as string
     */
    public String toString(String username)
    {
        String i = String.format("Collaborator %s made %d commits, %d issues, and %d comments.\n",
                username,
                countCollaboratorCommits(username),
                countIssuesByCollaborator(username),
                countCommentsByCollaborator(username));
        return i;
    }

    /**
     * Returns a string representation of collaborator information
     * using the date parameters.
     *
     * @return d collaborator info as string
     */
    public String toString(String username, Date start, Date end)
    {
        String d = String.format("Collaborator %s made %d commits, %d issues, and %d comments between %s and %s.\n", 
                username,
                countCollaboratorCommits(username,start,end),
                countIssuesByCollaborator(username,start,end),
                countCommentsByCollaborator(username,start,end),
                start.toString(),end.toString());
        return d;
    }
}

