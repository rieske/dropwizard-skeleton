package lt.rieske.skeleton.resources;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;
import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;
import lt.rieske.skeleton.api.Example;

public class ExampleResourceTest {

	private static final int FOO = 123;
	
    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule
            .builder()
            .addResource(new ExampleResource(FOO))
            .build();

    private final WebTarget exampleResource =
            RESOURCES.getJerseyTest().target("/api/example");

    @Test
    public void returnsNotFoundWhenRecentPurchasesForUserDoNotExist() {
    	String bar = "abc";
    	
        Response response = exampleResource
                .path(bar).request()
                .get();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK_200);
        assertThat(response.readEntity(Example.class))
                .isEqualToComparingFieldByField(new Example(FOO, bar));
    }

}
