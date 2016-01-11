package lt.rieske.skeleton;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ServiceConfiguration extends Configuration {

    @NotNull
    public final Integer foo;

    public ServiceConfiguration(@JsonProperty("foo") Integer foo) {
        this.foo = foo;
    }
}
