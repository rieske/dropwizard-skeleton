package lt.rieske.skeleton.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Example {
	public final long foo;
	public final String bar;

	public Example(@JsonProperty("foo") long foo,
			@JsonProperty("bar") String bar) {
		this.foo = foo;
		this.bar = bar;
	}

}
