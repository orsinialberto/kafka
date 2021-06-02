FROM openjdk:13-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY configuration/application-docker.yml application.yml
ENTRYPOINT ["java","-jar","/app.jar"]
