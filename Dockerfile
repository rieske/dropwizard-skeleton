FROM openjdk:11.0.5-jdk-slim

EXPOSE 8080 8081
WORKDIR /opt/service

ENTRYPOINT /opt/service/dropwizard-skeleton/bin/dropwizard-skeleton server /opt/configuration/production.yml

ADD configuration/production.yml /opt/configuration/production.yml
ADD build/distributions/dropwizard-skeleton.tar /opt/service/
