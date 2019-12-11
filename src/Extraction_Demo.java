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
			System.out.println("     Username: " + issue.getCollaborator().getUserName());
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
					System.out.println("     Username: " + commit.getCollaborator().getUserName());
					System.out.println("     Commit text: " + commit.getInfo());
					System.out.println("     Date Created: " + commit.getDateCreated());
		}
		
		System.out.println("------------------------------------------------------------------------");

		System.out.println("All Comments in Repository: ");
		
		System.out.println("------------------------------------------------------------------------");
		
		ArrayList<Comment> comments = repo.getComments();
		for (int i = 0; i < comments.size(); i++) {
					Comment comment = comments.get(i);
					System.out.println("Comment " + (i + 1) + ": ");
					System.out.println("     Username: " + comment.getCollaborator().getUserName());
					System.out.println("     Comment text: " + comment.getCommentText());
					System.out.println("     Date Created: " + comment.getDateCreated());
					System.out.println("     Date Updated: " + comment.getDateUpdated());
		}
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------\n\n\n\n\n\n\n");
		
		System.out.println("COLLABORATORS SECTION:");
		
		System.out.println("------------------------------------------------------------------------\n\n");

		ArrayList<Collaborator> collaborators = repo.getCollaborators();
		for (int i = 0; i < collaborators.size(); i++) {
			
			Collaborator collab = collaborators.get(i);
			
			ArrayList<Issue> collabIssues = collab.getIssues();
			ArrayList<Commit> collabCommits = collab.getCommits();
			ArrayList<Comment> collabComments = collab.getComments();
			
			System.out.println("\n\n");
			
			System.out.println("------------------------------------------------------------------------");
			
			System.out.println("Collaborator: " + collab.getFirstName() + 
			" " + collab.getLastName() + ", ID: " + collab.getID() 
			+ ", UserName: " + collab.getUserName());
			
			System.out.println("------------------------------------------------------------------------");

			System.out.println("Issues for Collaborator:");
			
			System.out.println("------------------------------------------------------------------------");
			
			for (int j = 0; j < collabIssues.size(); j++) {
				Issue issue = collabIssues.get(j);
				System.out.println("    Issue " + (j + 1) + ": ");
				System.out.println("        Username: " + issue.getCollaborator().getUserName());
				System.out.println("        Issue text: " + issue.getIssueText());
				System.out.println("        Date Created: " + issue.getDateCreated());
				System.out.println("        Date Updated: " + issue.getDateUpdated());
				
				
				for (int k = 0; k < issue.getComments().size(); k++) {
					Comment comment = issue.getComments().get(k);
					System.out.println("            Comment " + (k + 1) + ": ");
					System.out.println("                Username: " + comment.getCollaborator().getUserName());
					System.out.println("                Comment text: " + comment.getCommentText());
					System.out.println("                Date Created: " + comment.getDateCreated());
					System.out.println("                Date Updated: " + comment.getDateUpdated());
				}
			}
			
			System.out.println("------------------------------------------------------------------------");

			System.out.println("Commits for Collaborator:");
			
			System.out.println("------------------------------------------------------------------------");
			
			for (int j = 0; j < collabCommits.size(); j++) {
				Commit commit = collabCommits.get(j);
				System.out.println("    Commit " + (j + 1) + ": ");
				System.out.println("        Username: " + commit.getCollaborator().getUserName());
				System.out.println("        Commit text: " + commit.getInfo());
				System.out.println("        Date Created: " + commit.getDateCreated());
				
				for (int k = 0; k < commit.getComments().size(); k++) {
					Comment comment = commit.getComments().get(k);
					System.out.println("            Comment " + (k + 1) + ": ");
					System.out.println("                Username: " + comment.getCollaborator().getUserName());
					System.out.println("                Comment text: " + comment.getCommentText());
					System.out.println("                Date Created: " + comment.getDateCreated());
					System.out.println("                Date Updated: " + comment.getDateUpdated());
				}
			}
			
			System.out.println("------------------------------------------------------------------------");

			System.out.println("Comments for Collaborator:");
			
			System.out.println("------------------------------------------------------------------------");
			
			
			for (int j = 0; j < collabComments.size(); j++) {
				Comment comment = collabComments.get(j);
				System.out.println("    Comment " + (j + 1) + ": ");
				System.out.println("        Username: " + comment.getCollaborator().getUserName());
				System.out.println("        Comment text: " + comment.getCommentText());
				System.out.println("        Date Created: " + comment.getDateCreated());
				System.out.println("        Date Updated: " + comment.getDateUpdated());
			}
			
		}
		
	}

}
