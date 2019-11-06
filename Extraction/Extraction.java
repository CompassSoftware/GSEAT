/**
 * Extraction class.
 * @author Thomas Neumayr
 * @author Jacob MacFarland
 * @version 1.0
 */


import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryId;

import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.Repository;

import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.client.GitHubClient;
import java.io.*;

public class Extraction {
    public static void main(String[] args) {
        GitHubClient client = new GitHubClient();
        client.setCredentials("jacobmacfarland", "");

        RepositoryService service = new RepositoryService();
        service.getClient().setCredentials("jacobmacfarland", "");
        try {
            for (Repository repo : service.getRepositories("defunkt"))
                System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
