import extraction.*;
import github.*;
import java.util.*;

public class Extraction_Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter user name: ");
		String userName = sc.nextLine();
		
		System.out.println("Enter repository name: ");
		String repository = sc.nextLine();
		
		System.out.println("Enter token: ");
		String token = sc.nextLine();
		
		Extraction extractor = new Extraction(userName, repository, token);
		Repository repo = extractor.extract();
		
		System.out.println("------------------------------------------------------------------------");

		System.out.println("All Issues in Repository:");
		
		System.out.println("------------------------------------------------------------------------");
		
		ArrayList<Issue> issues = repo.getIssues();
		for (int i = 0; i < issues.size(); i++) {
			Issue issue = issues.get(i);
			System.out.println("Issue " + (i + 1) + ": ");
			System.out.println("     Username: " + issue.getUserName());
			System.out.println("     Issue text: " + issue.getIssueText());
			System.out.println("     Date Created: " + issue.getDateCreated());
			System.out.println("     Date Updated: " + issue.getDateUpdated());
		}
		
		System.out.println("------------------------------------------------------------------------");

		System.out.println("All Commits in Repository: ");
		
		System.out.println("------------------------------------------------------------------------");
		
		ArrayList<Commit> commits = repo.getCommits();
		for (int i = 0; i < commits.size(); i++) {
					Commit commit = commits.get(i);
					System.out.println("Commit " + (i + 1) + ": ");
					System.out.println("     Username: " + commit.getUserName());
					System.out.println("     Commit text: " + commit.getInfo());
					System.out.println("     Date Created: " + commit.getDateCreated());
					System.out.println("     Date Updated: " + commit.getDateUpdated());
		}
		
		System.out.println("------------------------------------------------------------------------");

		System.out.println("All Comments in Repository: ");
		
		System.out.println("------------------------------------------------------------------------");
		
		ArrayList<Comment> comments = repo.getComments();
		for (int i = 0; i < comments.size(); i++) {
					Comment comment = comments.get(i);
					System.out.println("Comment " + (i + 1) + ": ");
					System.out.println("     Username: " + comment.getUserName());
					System.out.println("     Comment text: " + comment.getCommentText());
					System.out.println("     Date Created: " + comment.getDateCreated());
					System.out.println("     Date Updated: " + comment.getDateUpdated());
		}
		
		System.out.println("------------------------------------------------------------------------");
		
	}

}
