package lt.rieske.skeleton.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;
import lt.rieske.skeleton.api.Example;

public class ExampleTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws IOException {
        Example purchase = new Example(11L, "foobar");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/example.json"), Example.class));

        assertThat(MAPPER.writeValueAsString(purchase)).isEqualTo(expected);
    }
}
