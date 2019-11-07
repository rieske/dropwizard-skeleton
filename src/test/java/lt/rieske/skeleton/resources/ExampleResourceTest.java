package lt.rieske.skeleton.resources;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import lt.rieske.skeleton.api.Example;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.WebTarget;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(DropwizardExtensionsSupport.class)
class ExampleResourceTest {

    private static final int FOO = 123;

    private static final ResourceExtension RESOURCES = ResourceExtension
            .builder()
            .addResource(new ExampleResource(FOO))
            .build();

    private final WebTarget exampleResource =
            RESOURCES.getJerseyTest().target("/api/example");

    @Test
    void returnsNotFoundWhenRecentPurchasesForUserDoNotExist() {
        var bar = "abc";

        var response = exampleResource
                .path(bar).request()
                .get();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK_200);
        assertThat(response.readEntity(Example.class)).isEqualTo(new Example(FOO, bar));
    }

}
