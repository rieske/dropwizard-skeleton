package lt.rieske.skeleton;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import lt.rieske.skeleton.resources.ExampleResource;

public class SkeletonService extends Application<ServiceConfiguration> {

	public static void main(String[] args) throws Exception {
		new SkeletonService().run(args);
	}

	@Override
	public String getName() {
		return "skeleton-service";
	}

	@Override
	public void run(ServiceConfiguration configuration, Environment environment) {
		environment.jersey().register(new ExampleResource(configuration.getFoo()));
	}
}
