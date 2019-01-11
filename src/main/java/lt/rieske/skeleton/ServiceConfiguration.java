package lt.rieske.skeleton;

import io.dropwizard.Configuration;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
class ServiceConfiguration extends Configuration {

    @NotNull
    private final Integer foo;
}
