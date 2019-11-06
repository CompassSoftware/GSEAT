
public class Repository {
    Collaborator[] collaborators;
    Commit[] commits;
    Comment[] comments;
    Issue[] issues;

    public Repository() {
        collaborators = new Collaborator[10];
        commits = new Commit[10];
        comments = new Comment[10];
        issues = new Issue[10];
    }

}
