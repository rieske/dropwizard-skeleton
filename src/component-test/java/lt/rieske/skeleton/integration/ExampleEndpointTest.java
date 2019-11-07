package lt.rieske.skeleton.integration;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class ExampleEndpointTest {

    @Test
    public void returnsExample() {
        // @formatter:off
		when().
			get("/api/example/aaa").
		then().
			statusCode(200).
			body("foo", equalTo(42)).
			body("bar", equalTo("aaa"));
		// @formatter:on
    }

}
