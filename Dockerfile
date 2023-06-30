
FROM openjdk:17-jdk-alpine

WORKDIR /app


COPY target/belezzeAPIREST-0.0.1-SNAPSHOT.jar app.jar


COPY src/main/resources/application.properties application.properties


CMD ["java", "-jar", "app.jar"]
