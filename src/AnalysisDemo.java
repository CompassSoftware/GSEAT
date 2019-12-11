import analysis.*;
import github.*;
import java.util.Date;
import java.time.LocalDate;
import github.Comment;
import github.Repository;
import github.Issue;
import github.Commit;
import github.Collaborator;
import java.util.ArrayList;

/**
 * Demo class demonstrates the use of Analysis.java.
 *
 * @author Ethan Hahn, Brooke Tibbett, Courtney Dixon,
 *  Val Lapensée-Rankine
 * @version 11-12-2019
 */
public class AnalysisDemo 
{    
    /**
     * Function to print something to the console screen.
     * @param args command line
     */
    public static void main(String[] args) 
    {
        Collaborator coll1 = new Collaborator("mister", "test", "tester1", "2");
        Collaborator coll2 = new Collaborator("misses", "test", "tester2", "3");
        
        ArrayList<Comment> comments1 = new ArrayList<Comment>();
        comments1.add(new Comment("commit comment 1", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(1)),
            AnalysisDemo.convert(LocalDate.now().minusDays(1))));
	    comments1.add(new Comment("commit comment 2", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(4)),
            AnalysisDemo.convert(LocalDate.now().minusDays(4))));

        ArrayList<Comment> comments2 = new ArrayList<Comment>();
        comments1.add(new Comment("commit comment 3", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(6)),
            AnalysisDemo.convert(LocalDate.now().minusDays(6))));
	    comments1.add(new Comment("commit comment 4", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(9)),
            AnalysisDemo.convert(LocalDate.now().minusDays(9))));
	    comments1.add(new Comment("commit comment 5", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(2)),
            AnalysisDemo.convert(LocalDate.now().minusDays(2))));

        ArrayList<Comment> comments3 = new ArrayList<Comment>();
        comments1.add(new Comment("commit comment 6", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(10)),
            AnalysisDemo.convert(LocalDate.now().minusDays(10))));

        ArrayList<Comment> comments4 = new ArrayList<Comment>();

        ArrayList<Comment> comments5 = new ArrayList<Comment>();
        comments1.add(new Comment("commit comment 7", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(14)),
            AnalysisDemo.convert(LocalDate.now().minusDays(14))));
	    comments1.add(new Comment("commit comment 8", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(3)),
            AnalysisDemo.convert(LocalDate.now().minusDays(3))));
	    comments1.add(new Comment("commit comment 9", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(2)),
            AnalysisDemo.convert(LocalDate.now().minusDays(2))));
	    comments1.add(new Comment("commit comment 10", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(8)),
            AnalysisDemo.convert(LocalDate.now().minusDays(8))));
	    comments1.add(new Comment("commit comment 11", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(11)),
            AnalysisDemo.convert(LocalDate.now().minusDays(11))));
	    comments1.add(new Comment("commit comment 12", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(4)),
            AnalysisDemo.convert(LocalDate.now().minusDays(4))));
	    comments1.add(new Comment("commit comment 13", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(4)),
            AnalysisDemo.convert(LocalDate.now().minusDays(4))));

        ArrayList<Comment> comments6 = new ArrayList<Comment>();
        comments1.add(new Comment("commit comment 14", coll1, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(3)),
            AnalysisDemo.convert(LocalDate.now().minusDays(3))));
	    comments1.add(new Comment("commit comment 15", coll2, "commit",
            AnalysisDemo.convert(LocalDate.now().minusDays(1)),
            AnalysisDemo.convert(LocalDate.now().minusDays(1))));

        ArrayList<Comment> comments7 = new ArrayList<Comment>();
        comments1.add(new Comment("issue comment 1", coll1, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(4)),
            AnalysisDemo.convert(LocalDate.now().minusDays(4))));

        ArrayList<Comment> comments8 = new ArrayList<Comment>();
        comments1.add(new Comment("issue comment 2", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(19)),
            AnalysisDemo.convert(LocalDate.now().minusDays(19))));
	    comments1.add(new Comment("issue comment 3", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(25)),
            AnalysisDemo.convert(LocalDate.now().minusDays(25))));
	    comments1.add(new Comment("issue comment 4", coll1, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(1)),
            AnalysisDemo.convert(LocalDate.now().minusDays(1))));

        ArrayList<Comment> comments9 = new ArrayList<Comment>();

        ArrayList<Comment> comments10 = new ArrayList<Comment>();
        comments1.add(new Comment("issue comment 5", coll1, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(17)),
            AnalysisDemo.convert(LocalDate.now().minusDays(17))));
	    comments1.add(new Comment("issue comment 6", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(2)),
            AnalysisDemo.convert(LocalDate.now().minusDays(2))));
	    comments1.add(new Comment("issue comment 7", coll1, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(3)),
            AnalysisDemo.convert(LocalDate.now().minusDays(3))));
	    comments1.add(new Comment("issue comment 8", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(6)),
            AnalysisDemo.convert(LocalDate.now().minusDays(6))));
	    comments1.add(new Comment("issue comment 9", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(9)),
            AnalysisDemo.convert(LocalDate.now().minusDays(9))));

        ArrayList<Comment> comments11 = new ArrayList<Comment>();
        comments1.add(new Comment("issue comment 10", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(1)),
            AnalysisDemo.convert(LocalDate.now().minusDays(1))));
	    comments1.add(new Comment("issue comment 11", coll2, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(8)),
            AnalysisDemo.convert(LocalDate.now().minusDays(8))));
	    comments1.add(new Comment("issue comment 12", coll1, "issue",
            AnalysisDemo.convert(LocalDate.now().minusDays(9)),
            AnalysisDemo.convert(LocalDate.now().minusDays(9))));

        Repository repo = new Repository();
	    repo.addCommit(new Commit("fixed things", coll1, 
            AnalysisDemo.convert(LocalDate.now().minusDays(13)), comments1));
	    repo.addCommit(new Commit("fixed things 2", coll1, 
            AnalysisDemo.convert(LocalDate.now().minusDays(2)), comments2));
	    repo.addCommit(new Commit("fixed more things", coll1,
            AnalysisDemo.convert(LocalDate.now().minusDays(3)), comments3));
    	repo.addCommit(new Commit("fixed even more things", coll1,
            AnalysisDemo.convert(LocalDate.now().minusDays(11)), comments4));
	    repo.addCommit(new Commit("added a thing", coll2,
            AnalysisDemo.convert(LocalDate.now().minusDays(1)), comments5));
	    repo.addCommit(new Commit("added function", coll2,
            AnalysisDemo.convert(LocalDate.now().minusDays(8)), comments6));
        repo.addIssue(new Issue("issue1", coll1,
            AnalysisDemo.convert(LocalDate.now().minusDays(6)),
            AnalysisDemo.convert(LocalDate.now().minusDays(6)),
            comments7));
        repo.addIssue(new Issue("issue2", coll2,
            AnalysisDemo.convert(LocalDate.now().minusDays(1)),
            AnalysisDemo.convert(LocalDate.now().minusDays(1)),
            comments8));
        repo.addIssue(new Issue("issue3", coll2,
            AnalysisDemo.convert(LocalDate.now().minusDays(2)),
            AnalysisDemo.convert(LocalDate.now().minusDays(2)),
            comments9));
        repo.addIssue(new Issue("issue4", coll2,
            AnalysisDemo.convert(LocalDate.now().minusDays(7)),
            AnalysisDemo.convert(LocalDate.now().minusDays(7)),
            comments10));
        repo.addIssue(new Issue("issue5", coll1,
            AnalysisDemo.convert(LocalDate.now().minusDays(3)),
            AnalysisDemo.convert(LocalDate.now().minusDays(3)),
            comments11));

        Analysis analysis = new Analysis(repo);
        
        int countCommits = analysis.countCommits();
        int countIssues = analysis.countIssues();
        int countCommitsDate = analysis.countCommits(
	    AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countIssuesDate = analysis.countIssues(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countIssuesComments = analysis.countIssuesComments();
        int countIssuesCommentsDate = analysis.countIssuesComments(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countCommitsComments = analysis.countCommitsComments();
        int countCommitsCommentsDate = analysis.countCommitsComments(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countRepoComments = analysis.countRepoComments();
        int countRepoCommentsDate = analysis.countRepoComments(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countComments = analysis.countComments();
        int countCommentsDate = analysis.countComments(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countCommentsByCollaborator = analysis.countCommentsByCollaborator("tester1");
        int countCommentsByCollaboratorDate = analysis.countCommentsByCollaborator("tester1",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countIssueCommentsByCollaborator = analysis.countIssueCommentsByCollaborator("tester2");
        int countIssueCommentsByCollaboratorDate = analysis.countIssueCommentsByCollaborator("tester2",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countCommitCommentsByCollaborator = analysis.countCommitCommentsByCollaborator("tester2");
        int countCommitCommentsByCollaboratorDate = analysis.countCommitCommentsByCollaborator("tester2",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countRepoCommentsByCollaborator = analysis.countRepoCommentsByCollaborator("tester1");
        int countRepoCommentsByCollaboratorDate = analysis.countRepoCommentsByCollaborator("tester1",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countIssuesByCollaborator = analysis.countIssuesByCollaborator("tester1");
        int countIssuesByCollaboratorDate = analysis.countIssuesByCollaborator("tester1",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countCollaboratorCommits = analysis.countCollaboratorCommits("tester2");
        int countCollaboratorCommitsDate = analysis.countCollaboratorCommits("tester2",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countContributionsByCollaboratorDate = analysis.countContributionsByCollaborator("tester2",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        int countContributionsByCollaborator = analysis.countContributionsByCollaborator("tester2");
        int countContributions = analysis.countContributions();
        int countContributionsBetweenDates = analysis.countContributionsBetweenDates(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        String contributionBreakdownByCollaborator = analysis.contributionBreakdownByCollaborator("tester1");
        String contributionBreakdownByCollaboratorDate = analysis.contributionBreakdownByCollaborator("tester2",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        double percentContributionsByCollaboratorDate = analysis.percentContributionsByCollaborator("tester2",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        String contributionBreakdown = analysis.contributionBreakdown();
        String contributionBreakdownDate = analysis.contributionBreakdown(
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        String toString = analysis.toString("tester1");
        String toStringDate = analysis.toString("tester1",
            AnalysisDemo.convert(LocalDate.now().minusDays(5)),
            new Date());
        
        System.out.println("Number of Commits: " + countCommits);
        System.out.println("Number of Commits in last 5 days: " + countCommitsDate);
        System.out.println("Number of Issues: " + countIssues);
        System.out.println("Number of Issues in last 5 days: " + countIssuesDate);
        System.out.println("Number of Issue Comments: " + countIssuesComments);
        System.out.println("Number of Issue Comments in last 5 days: " + countIssuesCommentsDate);
        System.out.println("Number of Commit Comments " + countCommitsComments);
        System.out.println("Number of Commit Comments in last 5 days: " + countCommitsCommentsDate);
        System.out.println("Number of Repo Comments: " + countRepoComments);
        System.out.println("Number of Repo Comments in last 5 days: " + countRepoCommentsDate);
        System.out.println("Number of Comments: " + countComments);
        System.out.println("Number of Comments in last 5 days: " + countCommentsDate);
        System.out.println("Number of Comments By Tester1: " + countCommentsByCollaborator);
        System.out.println("Number of Comments By Tester1 in last 5 days: " + countCommentsByCollaboratorDate);
        System.out.println("Number of Issue Comments By Tester2: " + countIssueCommentsByCollaborator);
        System.out.println("Number of Issue Comments By Tester2 in last 5 days: " + countIssueCommentsByCollaboratorDate);
        System.out.println("Number of Commit Comments By Tester2: " + countCommitCommentsByCollaborator);
        System.out.println("Number of Commit Comments By Tester2 in last 5 days: " + countCommitCommentsByCollaboratorDate);
        System.out.println("Number of Repo Comments By Tester1: " + countRepoComments);
        System.out.println("Number of Repo Comments By Tester1 in last 5 days: " + countRepoCommentsDate);
        System.out.println("Number of Issues By Tester1: " + countIssuesByCollaborator);
        System.out.println("Number of Issues By Tester1 in last 5 days: " + countIssuesByCollaboratorDate);
        System.out.println("Number of Commits By Tester2: " + countCollaboratorCommits);
        System.out.println("Number of Commits By Tester2 in last 5 days: " + countCollaboratorCommitsDate);
        System.out.println("Number of Contributions By Tester2: " + countContributionsByCollaborator);
        System.out.println("Number of Contributions By Tester2 in last 5 days: " + countContributionsByCollaboratorDate);
        System.out.println("Number of Contributions: " + countContributions);
        System.out.println("Number of Contributions in last 5 days: " + countContributionsBetweenDates);
        System.out.println("Contribution Breakdown for Tester1: " + contributionBreakdownByCollaborator);
        System.out.println("Contribution Breakdown for Tester1 in last 5 days: " + contributionBreakdownByCollaboratorDate);
        System.out.println("Percent Contributions for Tester2 in last 5 days: " + percentContributionsByCollaboratorDate);
        System.out.println("Contribution Breakdown: " + contributionBreakdown);
        System.out.println("Contribution Breakdown in last 5 days: " + contributionBreakdownDate);
        System.out.println("Collaborator info: " + toString);
        System.out.println("Colaborator info in last 5 days: " + toStringDate);


    }

    public static Date convert(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }
}
