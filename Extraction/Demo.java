
public class Demo {
    public static void main(String[] args) {
        Repository repo = new Repository();
        Collaborator collab1 = new Collaborator("Jacob", "MacFarland", "jacobmacfarland", "12345");
        Collaborator collab2 = new Collaborator("Joe", "Smoe", "joesmoe", "67890"); 
        
        Issue issue1 = new Issue("Text for issue 1", collab1);
        Issue issue2 = new Issue("Text for issue 2", collab2);
        
        Comment comment1 = new Comment("This was a stupid way to impelemnt this code", collab1, "Commit");
        Comment comment2 = new Comment("This issue is ready to be closed", collab2, "Issue");

        Commit commit1 = new Commit("This is some info for commit 1", collab1);
        Commit commit2 = new Commit("This is some info for commit 2", collab2);
    
        repo.collaborators[0] = collab1;
        repo.collaborators[1] = collab2;
        
        repo.issues[0] = issue1;
        repo.issues[1] = issue2;
        
        repo.comments[0] = comment1;
        repo.comments[1] = comment2;

        repo.commits[0] = commit1;
        repo.commits[1] = commit2;

        System.out.println("---------------------------------------------");

        System.out.println("All collaborators in repository:\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("Collaborator " + (i + 1) 
                                + ": \n     First name - " + repo.collaborators[i].getFirstName()
                                + "  \n     Last name - " + repo.collaborators[i].getLastName()
                                + "  \n     Username - " + repo.collaborators[i].getUserName()
                                + "  \n     User ID - " + repo.collaborators[i].getID());
        }

        System.out.println("---------------------------------------------");

        System.out.println("All issues in repository:\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("Issue " + (i + 1)
                               + ": \n     Issue Text - " + repo.issues[i].getIssueText()
                               + "  \n     Username - " + repo.issues[i].getUserName()
                               + "  \n     Date Created - " + repo.issues[i].getDateCreated()
                               + "  \n     Date Updated - " + repo.issues[i].getDateUpdated());
        }


        System.out.println("---------------------------------------------");

        System.out.println("All comments in repository:\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("Comment " + (i + 1)
                               + ": \n     Comment text - " + repo.comments[i].getCommentText()
                               + "  \n     Username - " + repo.comments[i].getUserName()
                               + "  \n     Comment type - " + repo.comments[i].getCommentType()
                               + "  \n     Date Created - " + repo.comments[i].getDateCreated()
                               + "  \n     Date Updated - " + repo.comments[i].getDateUpdated());

        }
        
        System.out.println("---------------------------------------------");
        
        System.out.println("All commits in repository:\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("Commit " + (i + 1)
                               + ": \n     Commit Info - " + repo.commits[i].getInfo()
                               + "  \n     Username - " + repo.commits[i].getUserName()
                               + "  \n     Date Created - " + repo.commits[i].getDateCreated()
                               + "  \n     Date Updated - " + repo.commits[i].getDateUpdated());
        }


    }

}
