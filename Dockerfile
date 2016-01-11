FROM webdizz/centos-java8

EXPOSE 8080 8081
ADD build/distributions/*.jar /opt/service/service.jar
ADD build/distributions/lib /opt/service/lib
WORKDIR /opt/service

ENTRYPOINT ["java", "-jar", "service.jar", "server"]