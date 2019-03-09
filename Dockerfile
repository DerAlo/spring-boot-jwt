FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/spring-boot-jwt-1.0-SNAPSHOT.jar $PROJECT_HOME/spring-boot-jwt-1.0-SNAPSHOT.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-jar","./spring-boot-jwt-1.0-SNAPSHOT.jar"]