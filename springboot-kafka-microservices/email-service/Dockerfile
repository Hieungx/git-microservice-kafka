# BUILD AGAIN AFTER CHANGE ##
FROM openjdk:11
WORKDIR /app
ARG JAR_FILE=target/email-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]