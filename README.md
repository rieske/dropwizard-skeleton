Building and running
====

Using docker
----

Build and test the sources:

`./gradlew build`

Build and tag the docker container:

`docker build -t dropwizard-skeleton .`

Run the docker container and pass it the production configuration file:

`docker run --net=host -v ${PWD}/configuration:/opt/service/configuration dropwizard-skeleton /opt/service/configuration/production.yml`

This is the preferred way to build and deploy the service. After `docker build` it should be docker tagged and pushed to the docker registry.
In the target host, it is only needed to pull the wanted version tag of the service from the registry and run it. Configuration can and should be versioned and deployed separately from the service.

Using docker-compose
---

Build and test the sources:

`./gradlew build`

Run docker-compose:

`docker-compose up`

Directly from gradle (convenient during development)
---

`./gradlew run`
