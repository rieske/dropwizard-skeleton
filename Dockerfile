FROM openjdk:11.0.1-jdk-slim

EXPOSE 8080 8081
ADD build/libs/*.jar /opt/service/service.jar
ADD build/distributions/lib /opt/service/lib
WORKDIR /opt/service

ENTRYPOINT ["java", "-jar", "service.jar", "server"]