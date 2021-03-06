package lt.rieske.skeleton.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

class ExampleTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    void serializesToJSON() throws IOException {
        var purchase = new Example(11L, "foobar");

        var expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/example.json"), Example.class));

        assertThat(MAPPER.writeValueAsString(purchase)).isEqualTo(expected);
    }
}
