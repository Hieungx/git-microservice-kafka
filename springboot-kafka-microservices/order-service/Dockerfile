## BUILD AGAIN AFTER CHANGE ##
#FROM openjdk:11
#ARG JAR_FILE=target/order-service-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","app.jar"]
FROM maven:3.8.6-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn -B -Dmaven.test.skip=true clean package

#
# Package stage
#
FROM openjdk:11
COPY --from=build /app/target/order-service-0.0.1-SNAPSHOT.jar order-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","order-service.jar"]