Building and running
====

[![Build Status](https://travis-ci.org/rieske/dropwizard-skeleton.png?branch=master)](https://travis-ci.org/rieske/dropwizard-skeleton) [![Build Status](https://drone.io/github.com/rieske/dropwizard-skeleton/status.png)](https://drone.io/github.com/rieske/dropwizard-skeleton/latest) [![Coverage Status](https://coveralls.io/repos/rieske/dropwizard-skeleton/badge.svg?branch=master)](https://coveralls.io/r/rieske/dropwizard-skeleton?branch=master) [![Dependency Status](https://www.versioneye.com/user/projects/5694099aaf789b004300015b/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5694099aaf789b004300015b)

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
