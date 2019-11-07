package lt.rieske.skeleton;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DropwizardExtensionsSupport.class)
class SkeletonServiceTest {

    private static final DropwizardAppExtension<ServiceConfiguration> DROPWIZARD =
            new DropwizardAppExtension<>(SkeletonService.class, "src/test/resources/test.yml");

    @Test
    void applicationStarts() {
        var client = new JerseyClientBuilder(DROPWIZARD.getEnvironment()).build("test client");

        var response = client.target(String.format("http://localhost:%d/ping", DROPWIZARD.getAdminPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }

}
