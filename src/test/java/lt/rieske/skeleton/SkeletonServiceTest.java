package lt.rieske.skeleton;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class SkeletonServiceTest {

    @ClassRule
    public static final DropwizardAppRule<ServiceConfiguration> RULE =
            new DropwizardAppRule<>(SkeletonService.class,
                                    ResourceHelpers.resourceFilePath("test.yml"));


    @Test
    public void applicationStarts() {
        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");

        Response response = client.target(String.format("http://localhost:%d/ping", RULE.getAdminPort()))
                                  .request()
                                  .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }

}
